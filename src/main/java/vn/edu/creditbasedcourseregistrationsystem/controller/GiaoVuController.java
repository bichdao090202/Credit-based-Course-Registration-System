package vn.edu.creditbasedcourseregistrationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.DanhSachSinhVienRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.GiangVienRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.LopHocPhanRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.PhongHocRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.SinhVienCreateResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.GiangVien;
import vn.edu.creditbasedcourseregistrationsystem.model.LopHocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.PhongHoc;
import vn.edu.creditbasedcourseregistrationsystem.service.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/giaovu")
public class GiaoVuController {
    @Autowired
    private UserAndAuthenticationService userAndAuthenticationService;
    @Autowired
    private PhongHocService phongHocService;
    @Autowired
    private LopHocPhanService lopHocPhanService;

    @PostMapping("/createDanhSachSinhVien")
    public List<SinhVienCreateResponse> createDanhSachSinhVien(@RequestBody DanhSachSinhVienRequest danhSachSinhVienRequest) {
        return userAndAuthenticationService.createListSinhVien(danhSachSinhVienRequest);
    }

    @PostMapping ("/createGiangVien")
    public GiangVien createGiangVien(@RequestBody GiangVienRequest giangVienCreate){
        return userAndAuthenticationService.createGiangVien(giangVienCreate);
    }

    @PostMapping("/createListLopHocPhan")
    public List<LopHocPhan> createListLopHocPhan(@RequestParam long maHocPhan, @RequestParam int soLuongLop, @RequestParam LocalDate ngayMoDangKy, @RequestParam int soLuongToiDa, @RequestParam long maHocKy){
        return lopHocPhanService.createListLopHocPhan(maHocPhan, soLuongLop, ngayMoDangKy, soLuongToiDa,maHocKy);
    }

    @PostMapping("/updateLopHocPhan")
    public LopHocPhan updateLopHocPhan(@RequestBody LopHocPhanRequest lopHocPhanRequest){
        return lopHocPhanService.updateLopHocPhan(lopHocPhanRequest);
    }

    @GetMapping("/getAllPhongHoc")
    public List<PhongHoc> getAllPhongHoc() {
        return phongHocService.getAllPhongHoc();
    }
}
