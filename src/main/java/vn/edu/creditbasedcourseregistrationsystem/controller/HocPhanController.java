package vn.edu.creditbasedcourseregistrationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.*;
import vn.edu.creditbasedcourseregistrationsystem.dtos.response.HocPhanTheoNienGiamResponse;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.service.*;

import java.util.List;

@RestController
@RequestMapping("/hocphan")
@CrossOrigin("*")
public class HocPhanController {
    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private NienGiamService nienGiamService;
    //    {
//        "tenHocPhan": "Lập trình thiết bị di động",
//        "maNganh": 3,
//        "maKhoa": null,
//        "soTinChiLyThuyet": 3,
//        "soTinChiThucHanh": 1
//    }
    @PostMapping("/createHocPhan")
    public HocPhan createHocPhan(@RequestBody HocPhanCreateRequest hocPhanCreateRequest) {
        if (hocPhanCreateRequest.getMaNganh() != 0 && hocPhanCreateRequest.getMaKhoa() != 0)
            return null;     //chỉ được set 1 trong 2 mã ngành hoặc mã khoa
        HocPhan hocPhan = hocPhanService.createHocPhan(hocPhanCreateRequest);
        return hocPhan;
    }

    @GetMapping("/getHocPhanById/{id}")
    public HocPhan getHocPhanById(@PathVariable long id) {
        return hocPhanService.getHocPhanById(id);
    }

    @PostMapping("/deleteHocPhan")
    public boolean deleteHocPhan(@RequestParam long id) {
        return hocPhanService.deleteHocPhan(id);
    }

    @PostMapping("/createHocPhanTienQuyet")
    public HocPhanTienQuyet createHocPhanTienQuyet(@RequestParam long maHocPhan, @RequestParam long maHocPhanTienQuyet) {
        return hocPhanService.setHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
    }

    @GetMapping("/getDanhSachHocPhanTienQuyet/{id}")
    public List<HocPhanTienQuyet> getHocPhanTienQuyet(@PathVariable long id) {
        return hocPhanService.getHocPhanTienQuyet(id);
    }

    @PostMapping("/deleteHocPhanTienQuyet")
    public boolean deleteHocPhanTienQuyet(@RequestParam long maHocPhan, @RequestParam long maHocPhanTienQuyet) {
        return hocPhanService.deleteHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
    }

    // {
    //     "maNganh": 3,
    //     "khoa": 16,
    //     "hocKy": 1,
    //     "hocPhanTheoNienGiam": [1, 2, 3] //Option
    // }
    @PostMapping("/createHocKyNienGiam")
    public HocKyNienGiam createHocKyNienGiam(@RequestBody HocKyNienGiamRequest hocKyNienGiamRequest) {
        return nienGiamService.createHocKyNienGiam(hocKyNienGiamRequest);
    }

    @PostMapping("/themHocPhanVaoNienGiam")
    public boolean themHocPhanVaoNienGiam(@RequestBody HocPhanTheoNienGiamRequest hocPhanTheoNienGiamRequest) {
        return nienGiamService.themHocPhanVaoNienGiam(hocPhanTheoNienGiamRequest);
    }

    @GetMapping("/getNienGiamByNganhAndKhoa")
    public List<HocPhanTheoNienGiamResponse> getNienGiamByNganhAndKhoa(@RequestParam long maNganh, @RequestParam int khoa) {
        return nienGiamService.getNienGiamByNganhAndKhoa(maNganh, khoa);
    }
}
