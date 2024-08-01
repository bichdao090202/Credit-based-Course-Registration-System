package vn.edu.creditbasedcourseregistrationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.DiemLopHocPhanRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.LoginRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.KetQuaHocTapSinhVienDetail;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.SinhVienLoginResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import vn.edu.creditbasedcourseregistrationsystem.service.KetQuaHocTapService;
import vn.edu.creditbasedcourseregistrationsystem.service.UserAndAuthenticationService;

import java.util.List;

@RestController
@RequestMapping("/sinhvien")
@CrossOrigin(origins="http://localhost:3000/")
public class SinhVienController {
    @Autowired
    private UserAndAuthenticationService userAndAuthenticationService;

    @Autowired
    private KetQuaHocTapService ketQuaHocTapService;

    @PostMapping("/login")
    public SinhVienLoginResponse login(@RequestBody LoginRequest loginRequest) {
        SinhVien sinhVien = userAndAuthenticationService.dangNhapSinhVien(loginRequest.getTenDangNhap(), loginRequest.getMatKhau());
        return new SinhVienLoginResponse(sinhVien);
    }

    @GetMapping("/getKetQuaSinhVien/{maSinhVien}")
    public KetQuaHocTapSinhVienDetail getKetQuaSinhVien(@PathVariable long maSinhVien) {
        return ketQuaHocTapService.getKetQuaSinhVien(maSinhVien);
    }
}
