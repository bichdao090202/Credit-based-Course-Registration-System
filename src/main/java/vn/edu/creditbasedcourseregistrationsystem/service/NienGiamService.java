package vn.edu.creditbasedcourseregistrationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.HocKyNienGiamRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.HocPhanTheoNienGiamRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.HocPhanResponse;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.HocPhanTheoNienGiamResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.HocKyNienGiam;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhanTheoNienGiam;
import vn.edu.creditbasedcourseregistrationsystem.model.Nganh;
import vn.edu.creditbasedcourseregistrationsystem.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class NienGiamService {
    @Autowired
    private NganhRepository nganhRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;
    @Autowired
    private HocKyNienGiamRepository hocKyNienGiamRepository;
    @Autowired
    private HocPhanTheoNienGiamRepository hocPhanTheoNienGiamRepository;
    public HocKyNienGiam createHocKyNienGiam(HocKyNienGiamRequest hocKyNienGiamRequest) {
        HocKyNienGiam hocKyNienGiam = new HocKyNienGiam(hocKyNienGiamRequest.getMaNganh(), hocKyNienGiamRequest.getKhoa(), hocKyNienGiamRequest.getHocKy());
        if (hocKyNienGiamRepository.existsByNganhAndKhoaAndHocKy(hocKyNienGiam.getNganh(), hocKyNienGiam.getKhoa(), hocKyNienGiam.getHocKy()))
            return null;    // đã tồn tại học kỳ niên giảm
        if (!nganhRepository.existsById(hocKyNienGiamRequest.getMaNganh()))
            return null;    // mã ngành không tồn tại
        hocKyNienGiamRepository.save(hocKyNienGiam);
        if (hocKyNienGiamRequest.getHocPhanTheoNienGiam()==null)
            return hocKyNienGiam;
        for (Long id : hocKyNienGiamRequest.getHocPhanTheoNienGiam()) {
            HocPhanTheoNienGiam hocPhanTheoNienGiam = new HocPhanTheoNienGiam(new HocPhan(id), hocKyNienGiam);
            hocPhanTheoNienGiamRepository.save(hocPhanTheoNienGiam);        //thêm học phần vào học kỳ niên giảm
        }
        return hocKyNienGiam; // chỉ tạo học kỳ
    }

    public boolean themHocPhanVaoNienGiam(HocPhanTheoNienGiamRequest hocPhanTheoNienGiamRequest) {
        if (!hocPhanRepository.existsById(hocPhanTheoNienGiamRequest.getMaHocPhan()))
            return false;       // không tìm thấy mã học phần
        if (!hocKyNienGiamRepository.existsById(hocPhanTheoNienGiamRequest.getMaHocKyNienGiam()))
            return false;       // không tìm thấy mã học kỳ niên giảm
        HocPhan hocPhan = new HocPhan(hocPhanTheoNienGiamRequest.getMaHocPhan());
        HocKyNienGiam hocKyNienGiam = new HocKyNienGiam(hocPhanTheoNienGiamRequest.getMaHocKyNienGiam());
        HocPhanTheoNienGiam hocPhanTheoNienGiam = new HocPhanTheoNienGiam(hocPhanTheoNienGiamRequest.getMaHocPhan(), hocPhanTheoNienGiamRequest.getMaHocKyNienGiam());
        if (!hocPhanTheoNienGiamRepository.existsByHocPhanAndHocKyNienGiam(hocPhan, hocKyNienGiam))
            hocPhanTheoNienGiamRepository.save(hocPhanTheoNienGiam);
        return true;
    }

    public List<HocPhanTheoNienGiamResponse> getNienGiamByNganhAndKhoa(long maNganh, int khoa) {
        List<HocKyNienGiam> hocKyNienGiamList = hocKyNienGiamRepository.findByNganhAndKhoa(maNganh, khoa);
        if (hocKyNienGiamList == null)
            return null;    // không tìm thấy học kỳ niên giảm
        List<HocPhanTheoNienGiamResponse> hocPhanTheoNienGiamResponseList = new ArrayList<>();
        for (HocKyNienGiam hocKyNienGiam : hocKyNienGiamList) {
            HocPhanTheoNienGiamResponse hocPhanTheoNienGiamResponse = getHocPhanTheoNienGiamResponse(hocKyNienGiam);
            hocPhanTheoNienGiamResponseList.add(hocPhanTheoNienGiamResponse);
        }
        System.out.println(hocPhanTheoNienGiamResponseList);
        return hocPhanTheoNienGiamResponseList;
    }

    private static HocPhanTheoNienGiamResponse getHocPhanTheoNienGiamResponse(HocKyNienGiam hocKyNienGiam) {
        HocPhanTheoNienGiamResponse hocPhanTheoNienGiamResponse = new HocPhanTheoNienGiamResponse();
        hocPhanTheoNienGiamResponse.setMaHocKyNienGiam(hocKyNienGiam.getMaHocKyNienGiam());
        hocPhanTheoNienGiamResponse.setHocKy(hocKyNienGiam.getHocKy());
        for (HocPhanTheoNienGiam hocPhanTheoNienGiam : hocKyNienGiam.getHocPhanTheoNienGiam()){
            HocPhanResponse hocPhanResponse = new HocPhanResponse(hocPhanTheoNienGiam.getHocPhan());
            hocPhanTheoNienGiamResponse.addHocPhanResponse(hocPhanResponse);
        }
        return hocPhanTheoNienGiamResponse;
    }


    public List<HocKyNienGiam> getHocKyNienGiamByNganhAndKhoa(long maNganh, long khoa) {
        return hocKyNienGiamRepository.findByNganhAndKhoa(new Nganh(maNganh), khoa);
    }

    public List<HocKyNienGiam> getHocKyNienGiamByNganhAndKhoaAndHocKy(long maNganh, long khoa, int hocKy) {
        return hocKyNienGiamRepository.findByNganhAndKhoaAndHocKy(new Nganh(maNganh), khoa, hocKy);
    }

    public List<HocPhanResponse> findDanhSachHocPhanSinhVienCoTheDangKy( long maNganh, int khoa) {
        List<HocPhanResponse> hocPhanResponses = new ArrayList<>();
        List<HocPhan> hocPhans = hocPhanRepository.findHocPhanSinhVienDangKy(maNganh, khoa);
        if (hocPhans == null)
            return null;    // không tìm thấy học phần
        for (HocPhan hocPhan : hocPhans) {
            HocPhanResponse hocPhanResponse = new HocPhanResponse(hocPhan);
            hocPhanResponses.add(hocPhanResponse);
        }
        return hocPhanResponses;
    }
}
