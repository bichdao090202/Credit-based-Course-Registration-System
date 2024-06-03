package vn.edu.creditbasedcourseregistrationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import vn.edu.creditbasedcourseregistrationsystem.model.TaiKhoan;
import vn.edu.creditbasedcourseregistrationsystem.repository.SinhVienRepository;
import vn.edu.creditbasedcourseregistrationsystem.repository.TaiKhoanRepository;

@Service
public class AuthenticationService {
    @Autowired
    private SinhVienRepository sinhVienRepository;
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
}
