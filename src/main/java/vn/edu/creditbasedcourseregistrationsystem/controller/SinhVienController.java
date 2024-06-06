package vn.edu.creditbasedcourseregistrationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.LoginRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.SinhVienLoginResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import vn.edu.creditbasedcourseregistrationsystem.service.AuthenticationService;
import vn.edu.creditbasedcourseregistrationsystem.service.UserService;
@RestController
@RequestMapping("/SinhVien")
@CrossOrigin(origins="http://localhost:3000/")
public class SinhVienController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public SinhVienLoginResponse login(@RequestBody LoginRequest loginRequest) {
        SinhVien sinhVien = authenticationService.dangNhapSinhVien(loginRequest.getTenDangNhap(), loginRequest.getMatKhau());
        return new SinhVienLoginResponse(sinhVien);
    }
}
