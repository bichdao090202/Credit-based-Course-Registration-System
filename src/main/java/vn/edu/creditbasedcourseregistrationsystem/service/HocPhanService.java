package vn.edu.creditbasedcourseregistrationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.*;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.repository.*;

import java.util.List;

@Service
public class HocPhanService {
    @Autowired
    private KhoaRepository khoaRepository;
    @Autowired
    private NganhRepository nganhRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;
    @Autowired
    private HocPhanTienQuyetRepository hocPhanTienQuyetRepository;
    @Autowired
    private HocPhanTheoNienGiamRepository hocPhanTheoNienGiamRepository;

    public HocPhan createHocPhan(HocPhanCreateRequest hocPhanCreateRequest) {
        if ((hocPhanCreateRequest.getMaKhoa() != 0 && !khoaRepository.existsById(hocPhanCreateRequest.getMaKhoa()))
                || (hocPhanCreateRequest.getMaNganh() != 0 && !nganhRepository.existsById(hocPhanCreateRequest.getMaNganh()))) {
            return null;    // mã ngành hoặc mã khoa không tồn tại
        }
        HocPhan hocPhan = new HocPhan(hocPhanCreateRequest.getTenHocPhan(),
                hocPhanCreateRequest.getMaNganh() == 0 ? null : new Nganh(hocPhanCreateRequest.getMaNganh()),
                hocPhanCreateRequest.getMaKhoa() == 0 ? null : new Khoa(hocPhanCreateRequest.getMaKhoa()),
                hocPhanCreateRequest.getSoTinChiLyThuyet(),
                hocPhanCreateRequest.getSoTinChiThucHanh());
        hocPhanRepository.save(hocPhan);
        return hocPhan;
    }

    public HocPhan getHocPhanById(long id) {
        return hocPhanRepository.findById(id).orElse(null);
    }

    public boolean deleteHocPhan(long id) {
        if (!hocPhanRepository.existsById(id))
            return false;       // không tìm thấy id
        if (hocPhanTheoNienGiamRepository.existsByHocPhan(new HocPhan(id)))
            return false;       // học phần đã được sử dụng trong học kỳ niên giảm
        if (hocPhanTienQuyetRepository.existsByMaHocPhan(id))
            return false;       // học phần đã được sử dụng trong học phần tiên quyết
        hocPhanRepository.deleteById(id);
        return true;
    }

    public HocPhanTienQuyet setHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet) {
        if (!existsHocPhan(maHocPhan) || !existsHocPhan(maHocPhanTienQuyet))
            return null;       // không tìm thấy mã học phần hoặc mã học phần tiên quyết
        HocPhanTienQuyet hptq = new HocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        boolean res = hocPhanTienQuyetRepository.existsByMaHocPhanAndMaHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        if (res)
            return null;    // đã tồn tại quan hệ
        return hocPhanTienQuyetRepository.save(hptq);
    }

    public List<HocPhanTienQuyet> getHocPhanTienQuyet(long id) {
        if (!existsHocPhan(id))
            return null;    // không tìm thấy mã học phần
        return hocPhanTienQuyetRepository.findByMaHocPhan(id);
    }

    public boolean deleteHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet) {
        if (!existsHocPhan(maHocPhan) || !existsHocPhan(maHocPhanTienQuyet))
            return false;       // không tìm thấy mã học phần hoặc mã học phần tiên quyết
        HocPhanTienQuyet hptq = hocPhanTienQuyetRepository.findByMaHocPhanAndMaHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        if (hptq != null)
            hocPhanTienQuyetRepository.delete(hptq);
        return true;
    }

    public boolean existsHocPhan(long id) {
        return hocPhanRepository.existsById(id);
    }


}
