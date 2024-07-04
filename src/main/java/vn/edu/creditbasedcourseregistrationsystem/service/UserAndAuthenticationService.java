package vn.edu.creditbasedcourseregistrationsystem.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.*;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAndAuthenticationService {
    @Autowired
    private GiangVienRepository giangVienRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private GiaoVuRepository giaoVuRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public SinhVien dangNhapSinhVien(long tenDangNhap, String matKhau) {
        TaiKhoan tk = taiKhoanRepository.findById(tenDangNhap).orElse(null);
        if (tk == null) {
            throw new UsernameNotFoundException("Không tìm thấy tài khoản");
        }
        if (passwordEncoder.matches(matKhau, tk.getMatKhau()))
            if (tenDangNhap>=10000)
                return sinhVienRepository.findById(tenDangNhap).orElse(null);
        return null;
    }

    public SinhVien createSinhVien(SinhVienCreate sinhVienCreate){
        SinhVien sinhVien = new SinhVien(sinhVienCreate);
        sinhVienRepository.save(sinhVien);
        TaiKhoan tk = new TaiKhoan(sinhVien);
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return sinhVien;
    }

    public List<SinhVienCreateResponse> createListSinhVien(DanhSachSinhVienRequest danhSachSinhVienRequest){
        List<SinhVienCreateResponse> sinhVienCreateResponses = new ArrayList<>();
        for (SinhVienCreate sinhVienCreate : danhSachSinhVienRequest.getDanhSachSinhVien()) {
            SinhVien sinhVien = new SinhVien(sinhVienCreate);
            sinhVien.setKhoa(danhSachSinhVienRequest.getKhoa());
            sinhVien.setNganh(new Nganh(danhSachSinhVienRequest.getMaNganh()));
            sinhVienRepository.save(sinhVien);
            TaiKhoan tk = new TaiKhoan(sinhVien);
            tk.setMatKhau(passwordEncoder.encode("1111"));
            taiKhoanRepository.save(tk);
            sinhVienCreateResponses.add(new SinhVienCreateResponse(sinhVien));
        }
        return sinhVienCreateResponses;
    }

    public GiangVien createGiangVien(GiangVienRequest giangVienRequest) {
        GiangVien giangVien = new GiangVien(giangVienRequest);
        giangVienRepository.save(giangVien);
        TaiKhoan tk = new TaiKhoan(giangVien);
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return giangVien;
    }

    public GiaoVu createGiaoVu(GiaoVu giaoVu) {
        giaoVuRepository.save(giaoVu);
        TaiKhoan tk = new TaiKhoan(giaoVu);
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return giaoVu;
    }


    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }
}
