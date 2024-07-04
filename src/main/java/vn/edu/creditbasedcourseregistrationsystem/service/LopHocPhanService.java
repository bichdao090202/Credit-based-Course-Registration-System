package vn.edu.creditbasedcourseregistrationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.LopHocPhanRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.PhongHocRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.LopHocPhanResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LopHocPhanService {
    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    @Autowired
    private PhongHocRepository phongHocRepository;

    @Autowired
    private HocKyRepository hocKyRepository;

    public PhongHoc createPhongHoc(PhongHocRequest phongHocRequest) {
        PhongHoc phongHoc = new PhongHoc(phongHocRequest.getTenPhong(), phongHocRequest.isPhongLyThuyet());
        return phongHocRepository.save(phongHoc);
    }

    public boolean createHocKy(String tenHocKy){
        HocKy hocKy = new HocKy(tenHocKy);
        hocKyRepository.save(hocKy);
        return true;
    }

    public List<LopHocPhanResponse> getLopHocPhanByHocPhan(HocPhan hocPhan) {
        List<LopHocPhanResponse> lopHocPhanResponses = new ArrayList<>();
        List<LopHocPhan> lopHocPhans = lopHocPhanRepository.findByHocPhan(hocPhan);
        if (lopHocPhans == null)
            return null;    // không tìm thấy
        for (LopHocPhan lopHocPhan : lopHocPhans) {
            LopHocPhanResponse lopHocPhanResponse = new LopHocPhanResponse(lopHocPhan);
            lopHocPhanResponses.add(lopHocPhanResponse);
        }
        return lopHocPhanResponses;
    }

    public List<LopHocPhan> createListLopHocPhan(long maHocPhan, int soLuongLop, LocalDate ngayMoDangKy, int soLuongToiDa, long maHocKy) {
        List<LopHocPhan> lopHocPhans = new ArrayList<>();
        for (int i = 0; i < soLuongLop; i++) {
            LopHocPhan lopHocPhan = new LopHocPhan();
            lopHocPhan.setHocPhan(new HocPhan(maHocPhan));
            lopHocPhan.setNgayMoDangKy(ngayMoDangKy);
            lopHocPhan.setSoLuongToiDa(soLuongToiDa);
            lopHocPhan.setSoLuongHienTai(0);
            lopHocPhan.setHocKy(new HocKy(maHocKy));
            lopHocPhans.add(lopHocPhan);
        }
        return lopHocPhanRepository.saveAll(lopHocPhans);
    }

    public LopHocPhan updateLopHocPhan(LopHocPhanRequest lopHocPhanRequest){
        LopHocPhan lopHocPhan = lopHocPhanRepository.findById(lopHocPhanRequest.getMaLopHocPhan()).orElse(null);
        if (lopHocPhan==null)
            return null;
        if (lopHocPhanRequest.getSoLuongToiDa()!=0 && lopHocPhanRequest.getSoLuongToiDa()>0)
            lopHocPhan.setSoLuongToiDa(lopHocPhanRequest.getSoLuongToiDa());
        if (lopHocPhanRequest.getMaGiangVien()!=0)
            lopHocPhan.setGiangVien(new GiangVien(lopHocPhanRequest.getMaGiangVien()));
        if (lopHocPhanRequest.getNgayMoDangKy()!=null)
            lopHocPhan.setNgayMoDangKy(lopHocPhanRequest.getNgayMoDangKy());
        if (lopHocPhanRequest.getTenLopHocPhan()!=null)
            lopHocPhan.setTenLopHocPhan(lopHocPhanRequest.getTenLopHocPhan());
        return lopHocPhanRepository.save(lopHocPhan);
    }

}
