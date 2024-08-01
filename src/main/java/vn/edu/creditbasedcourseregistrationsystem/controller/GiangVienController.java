package vn.edu.creditbasedcourseregistrationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.DiemLopHocPhanRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.KetQuaHocTapSinhVienDetail;
import vn.edu.creditbasedcourseregistrationsystem.service.KetQuaHocTapService;

import java.util.List;

@RestController
@RequestMapping("/giangvien")
public class GiangVienController {
    @Autowired
    private KetQuaHocTapService ketQuaHocTapService;

    @PostMapping("/nhapDiemChoLopHocPhan")
    public List<Long> nhapDiemChoLopHocPhan(@RequestBody DiemLopHocPhanRequest diemLopHocPhanRequest) {
        List<Long> danhSachMSSVDiemKhongHopLe = ketQuaHocTapService.nhapDiemChoLopHocPhan(diemLopHocPhanRequest);
        return danhSachMSSVDiemKhongHopLe;
    }

}
