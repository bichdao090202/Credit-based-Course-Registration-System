package vn.edu.creditbasedcourseregistrationsystem.controller;

import vn.edu.creditbasedcourseregistrationsystem.dtos.request.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.SinhVienResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Sample")
public class SampleController {
    @Autowired
    private UserService userService;
    @Autowired
    private KhoaNganhService khoaNganhService;

    @GetMapping("/createSample1")
    public Khoa createSample1() {
        Khoa khoaCNTT = khoaNganhService.createKhoa("Khoa Công nghệ thông tin");
        Khoa khoaKT = khoaNganhService.createKhoa("Khoa Kế");
        Nganh nganhKyThuatPhamMem = khoaNganhService.createNganh("Kỹ thuật phần mềm", khoaCNTT);
        Nganh nganhkt = new Nganh( "Ke toan", khoaKT);
        return khoaCNTT;
    }
    @GetMapping("/createSample2")
    public List<SinhVienResponse> createSample2() {
        DanhSachSinhVienRequest danhSachSinhVienRequest = new DanhSachSinhVienRequest();
        danhSachSinhVienRequest.setKhoa(16);
        danhSachSinhVienRequest.setMaNganh(1);
        List<SinhVienCreate> sinhVienCreates = new ArrayList<>();
        sinhVienCreates.add(new SinhVienCreate("Đào Thị Ngọc Bích", LocalDate.of(2002,2,9), true, "Gò Vâp, TP.HCM", "0123456789", "123456789"));
        sinhVienCreates.add(new SinhVienCreate("Nguyễn Văn An", LocalDate.of(2002,3,8), false, "Gò Vâp, TP.HCM", "0123456789", "123456789"));
        sinhVienCreates.add(new SinhVienCreate("Trần Thị Bình", LocalDate.of(2002,4,7), true, "Gò Vâp, TP.HCM", "0123456789", "123456789"));
        sinhVienCreates.add(new SinhVienCreate("Lê Thị Dậu", LocalDate.of(2002,5,6), true, "Gò Vâp, TP.HCM", "0123456789", "123456789"));
        sinhVienCreates.add(new SinhVienCreate("Nguyễn Văn Tí", LocalDate.of(2002,6,5), false, "Gò Vâp, TP.HCM", "0123456789", "123456789"));
        sinhVienCreates.add(new SinhVienCreate("Nguyễn Thị Mậu", LocalDate.of(2002,7,4), false, "Gò Vâp, TP.HCM", "0123456789", "123456789"));
        danhSachSinhVienRequest.setSinhVienList(sinhVienCreates);
        return userService.createListSinhVien(danhSachSinhVienRequest);
    }

}
