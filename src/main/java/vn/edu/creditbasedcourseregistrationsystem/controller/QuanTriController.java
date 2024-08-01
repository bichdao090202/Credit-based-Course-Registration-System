package vn.edu.creditbasedcourseregistrationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.HocPhanCreateRequest;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.PhongHocRequest;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.service.KhoaNganhService;
import vn.edu.creditbasedcourseregistrationsystem.service.HocPhanService;
import vn.edu.creditbasedcourseregistrationsystem.service.LopHocPhanService;
import vn.edu.creditbasedcourseregistrationsystem.service.PhongHocService;

import java.util.List;

@RestController
@RequestMapping("/quantri")
public class QuanTriController {
    @Autowired
    private KhoaNganhService khoaNganhService;
    @Autowired
    private PhongHocService phongHocService;
    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private LopHocPhanService lopHocPhanService;

    @PostMapping("/createPhongHoc")
    public PhongHoc createPhongHoc(PhongHocRequest phongHocRequest) {
        return phongHocService.createPhongHoc(phongHocRequest);
    }

    @PostMapping("/createHocKy")
    public boolean createHocKy(@RequestBody String tenHocKy) {
        return lopHocPhanService.createHocKy(tenHocKy);
    }

    @PostMapping("/createHocPhan")
    public HocPhan createHocPhan(@RequestBody HocPhanCreateRequest hocPhanCreateRequest) {
        return hocPhanService.createHocPhan(hocPhanCreateRequest);
    }

    @GetMapping("/getKhoaById/{id}")
    public Khoa getKhoaById(@PathVariable long id) {
        return khoaNganhService.getKhoaById(id);
    }

    @GetMapping("/getNganhById/{id}")
    public Nganh getNganhById(@PathVariable long id) {
        return khoaNganhService.getNganhById(id);
    }

    @PostMapping("/createKhoa/{tenKhoa}")
    public Khoa createKhoa(@PathVariable String tenKhoa) {
        return khoaNganhService.createKhoa(tenKhoa);
    }

    @PostMapping("/createNganh/{maKhoa}/{tenNganh}")
    public Nganh createNganh(@PathVariable String tenNganh, @PathVariable long maKhoa) {
        return khoaNganhService.createNganh(tenNganh, new Khoa(maKhoa));
    }

    @PostMapping("/updateTenKhoa/{maKhoa}/{tenKhoa}")
    public Khoa updateTenKhoa(@PathVariable long maKhoa, @PathVariable String tenKhoa) {
        return khoaNganhService.updateTenKhoa(maKhoa, tenKhoa);
    }

    @PostMapping("/updateTenNganh/{maNganh}/{tenNganh}")
    public Nganh updateTenNganh(@PathVariable long maNganh, @PathVariable String tenNganh) {
        return khoaNganhService.updateTenNganh(maNganh, tenNganh);
    }

    @PostMapping("/deleteKhoa/{id}")
    public boolean deleteKhoa(@PathVariable long id) {
        return khoaNganhService.deleteKhoa(id);
    }

    @GetMapping("/getNganhByKhoa/{id}")
    public List<Nganh> getNganhByKhoa(@PathVariable long id) {
        return khoaNganhService.getNganhByKhoa(id);
    }

}
