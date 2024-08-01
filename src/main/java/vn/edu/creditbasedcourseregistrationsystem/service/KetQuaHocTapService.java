package vn.edu.creditbasedcourseregistrationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.DiemLopHocPhanRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.KetQuaSinhVien;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.KetQuaHocTapSinhVienDetail;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocKy;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import vn.edu.creditbasedcourseregistrationsystem.repository.HocPhanRepository;
import vn.edu.creditbasedcourseregistrationsystem.repository.KetQuaHocKyRepository;
import vn.edu.creditbasedcourseregistrationsystem.repository.KetQuaHocPhanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class KetQuaHocTapService {
    @Autowired
    private KetQuaHocPhanRepository ketQuaHocPhanRepository;
    @Autowired
    private KetQuaHocKyRepository ketQuaHocKyRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;

    public List<Long> nhapDiemChoLopHocPhan(DiemLopHocPhanRequest diemLopHocPhanRequest) {
        HocPhan hocPhan = hocPhanRepository.findById(diemLopHocPhanRequest.getMaHocPhan()).orElse(null);
        if (hocPhan == null)
            return null;    // mã học phần không tồn tại
        List<Long> danhSachMSSVDiemKhongHopLe = new ArrayList<>();
        for (KetQuaSinhVien ketQuaSinhVien : diemLopHocPhanRequest.getListKetQuaSinhVien()) {
            if (createKetQuaHocPhan(ketQuaSinhVien, diemLopHocPhanRequest.getHocKy(),hocPhan)==null)
                danhSachMSSVDiemKhongHopLe.add(ketQuaSinhVien.getMaSinhVien());
        }
        return danhSachMSSVDiemKhongHopLe;
    }

    private KetQuaHocPhan createKetQuaHocPhan(KetQuaSinhVien ketQuaSinhVien, int hocKy, HocPhan hocPhan){
        if (hocKy<1)
            return null;    // học kỳ không hợp lệ
        if (ketQuaSinhVien.getListDiem().size() != 5 && ketQuaSinhVien.getListDiem().size() != 8)
            return null;    // số lượng điểm không hợp lệ
        if (hocPhan.getSoTinChiThucHanh() > 0 && ketQuaSinhVien.getListDiem().size() == 5 ||
                hocPhan.getSoTinChiThucHanh() == 0 && ketQuaSinhVien.getListDiem().size() == 8)
            return null;    // số lượng điểm không hợp lệ
        KetQuaHocPhan ketQuaHocPhan = new KetQuaHocPhan(ketQuaSinhVien,hocPhan, hocKy);
        if (!ketQuaHocPhan.checkDiemHopLe())
            return null;    // điểm không hợp lệ
        ketQuaHocPhan.setHocPhan(hocPhan);
        KetQuaHocPhan tmp = ketQuaHocPhanRepository.findByHocPhanAndMaSinhVien(hocPhan, ketQuaSinhVien.getMaSinhVien());
        if (tmp != null)
            ketQuaHocPhan.setMaKetQuaHocPhan(tmp.getMaKetQuaHocPhan());     // update kết quả cũ
        ketQuaHocPhan.setHocPhan(hocPhan);
        createKetQuaHocKy(ketQuaSinhVien.getMaSinhVien(), hocKy, ketQuaHocPhan);
        return ketQuaHocPhanRepository.save(ketQuaHocPhan);
    }

    private void createKetQuaHocKy(long maSinhVien, int hocKy, KetQuaHocPhan ketQuaHocPhan){
        KetQuaHocKy ketQuaHocKy = ketQuaHocKyRepository.findByMaSinhVienAndHocKy(maSinhVien, hocKy);
        if (ketQuaHocKy == null){
            ketQuaHocKy = new KetQuaHocKy(maSinhVien, ketQuaHocPhan, hocKy);
            ketQuaHocKyRepository.save(ketQuaHocKy);
        } else {
            List<KetQuaHocPhan> ketQuaHocPhanList = ketQuaHocPhanRepository.findByKetQuaHocKy(new KetQuaHocKy(maSinhVien, hocKy));
            if (!ketQuaHocPhanList.contains(ketQuaHocPhan))
                ketQuaHocPhanList.add(ketQuaHocPhan);
            ketQuaHocKy.updateKeQuaHocKy(ketQuaHocPhanList);
            ketQuaHocKyRepository.save(ketQuaHocKy);
        }
    }

    public KetQuaHocTapSinhVienDetail getKetQuaSinhVien(long maSinhVien) {
        List<KetQuaHocKy> ketQuaHocKyList = ketQuaHocKyRepository.findByMaSinhVien(maSinhVien);
        if (ketQuaHocKyList.isEmpty())
            return null;    // sinh viên chưa có kết quả học tập
        for (KetQuaHocKy ketQuaHocKy : ketQuaHocKyList) {
            List<KetQuaHocPhan> ketQuaHocPhanList = ketQuaHocPhanRepository.findByKetQuaHocKy(ketQuaHocKy);
//            List<KetQuaHocPhan> ketQuaHocPhanList = ketQuaHocKy.getKetQuaHocPhans();
            for (KetQuaHocPhan ketQuaHocPhan : ketQuaHocPhanList) {
                System.out.println(ketQuaHocPhan.getHocPhan().getTenHocPhan());
            }
//            ketQuaHocKy.setKetQuaHocPhans(ketQuaHocPhanList);
        }
        KetQuaHocTapSinhVienDetail ketQuaHocTapSinhVienDetail = new KetQuaHocTapSinhVienDetail(ketQuaHocKyList);
        return ketQuaHocTapSinhVienDetail;
    }
}
