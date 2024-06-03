package vn.edu.creditbasedcourseregistrationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.LoginRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.SinhVienResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import vn.edu.creditbasedcourseregistrationsystem.service.AuthenticationService;
import vn.edu.creditbasedcourseregistrationsystem.service.UserService;
@RestController
@RequestMapping("/SinhVien")
public class SinhVienController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authenticationService;
    @GetMapping("/login")
    public SinhVienResponse login(@RequestBody LoginRequest loginRequest) {
        SinhVien sinhVien = authenticationService.dangNhapSinhVien(loginRequest.getTenDangNhap(), loginRequest.getMatKhau());
        return new SinhVienResponse(sinhVien);
    }
}
