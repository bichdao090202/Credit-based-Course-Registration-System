package vn.edu.creditbasedcourseregistrationsystem.service;

import vn.edu.creditbasedcourseregistrationsystem.dtos.request.DanhSachSinhVienRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.SinhVienCreate;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.SinhVienResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
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

    public SinhVien createSinhVien(SinhVienCreate sinhVienCreate){
        SinhVien sinhVien = new SinhVien(sinhVienCreate);
        sinhVienRepository.save(sinhVien);
        TaiKhoan tk = new TaiKhoan(sinhVien);
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return sinhVien;
    }

    public List<SinhVienResponse> createListSinhVien(DanhSachSinhVienRequest danhSachSinhVienRequest){
        List<SinhVienResponse> sinhVienResponses = new ArrayList<>();
        for (SinhVienCreate sinhVienCreate : danhSachSinhVienRequest.getSinhVienList()) {
            SinhVien sinhVien = new SinhVien(sinhVienCreate);
            sinhVien.setKhoa(danhSachSinhVienRequest.getKhoa());
            sinhVien.setNganh(new Nganh(danhSachSinhVienRequest.getMaNganh()));
            sinhVienRepository.save(sinhVien);
            TaiKhoan tk = new TaiKhoan(sinhVien);
            tk.setMatKhau(passwordEncoder.encode("1111"));
            taiKhoanRepository.save(tk);
            sinhVienResponses.add(new SinhVienResponse(sinhVien));
        }
        return sinhVienResponses;
    }

    public GiangVien createGiangVien(GiangVien giangVien) {
        GiangVien gv = giangVienRepository.save(giangVien);
        TaiKhoan tk = new TaiKhoan(giangVien.getMaGiangVien());
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return gv;
    }

    public GiaoVu createGiaoVu(GiaoVu giaoVu) {
        GiaoVu gv = giaoVuRepository.save(giaoVu);
        TaiKhoan tk = new TaiKhoan(giaoVu.getMaGiaoVu());
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return gv;
    }


}
