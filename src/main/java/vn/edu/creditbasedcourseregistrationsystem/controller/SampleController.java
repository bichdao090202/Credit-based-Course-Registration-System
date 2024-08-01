package vn.edu.creditbasedcourseregistrationsystem.controller;

import vn.edu.creditbasedcourseregistrationsystem.dtos.request.*;
import vn.edu.creditbasedcourseregistrationsystem.model.*;
import vn.edu.creditbasedcourseregistrationsystem.repository.KetQuaHocPhanRepository;
import vn.edu.creditbasedcourseregistrationsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private UserAndAuthenticationService userAndAuthenticationService;
    @Autowired
    private KhoaNganhService khoaNganhService;
    @Autowired
    private PhongHocService phongHocService;
    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private LopHocPhanService lopHocPhanService;
    @Autowired
    private KetQuaHocPhanRepository ketQuaHocPhanRepository;


    //Khoa, ngành, phòng học
    @GetMapping("/createSample1")
    public Khoa createSample1() {
        Khoa khoaCNTT = khoaNganhService.createKhoa("Khoa Công nghệ thông tin");
        Khoa khoaKT = khoaNganhService.createKhoa("Khoa Kế");
        khoaNganhService.createNganh("Kỹ thuật phần mềm", khoaCNTT);
        khoaNganhService.createNganh("Hệ thống thông tin", khoaCNTT);
        khoaNganhService.createNganh("Khoa học máy tính", khoaCNTT);
        khoaNganhService.createNganh("Khoa học dữ liệu", khoaCNTT);
        khoaNganhService.createNganh("Ke toan", khoaKT);
        List<PhongHocRequest> phongHocRequests = Arrays.asList(
                new PhongHocRequest("Phong X.01", true),
                new PhongHocRequest("Phong X.02", true),
                new PhongHocRequest("Phong X.03", true),
                new PhongHocRequest("Phong X.04", true),
                new PhongHocRequest("Phong X.05", true),
                new PhongHocRequest("Phong X.06", true),
                new PhongHocRequest("Phong X.07", true),
                new PhongHocRequest("Phong X.08", true),
                new PhongHocRequest("Phong X.09", true),
                new PhongHocRequest("Phong X.10", true),
                new PhongHocRequest("Phong H.01", false),
                new PhongHocRequest("Phong H.02", false),
                new PhongHocRequest("Phong H.03", false),
                new PhongHocRequest("Phong H.04", false),
                new PhongHocRequest("Phong H.05", false),
                new PhongHocRequest("Phong H.06", false),
                new PhongHocRequest("Phong H.07", false),
                new PhongHocRequest("Phong H.08", false)
        );
        for (PhongHocRequest phongHocRequest : phongHocRequests) {
            phongHocService.createPhongHoc(phongHocRequest);
        }
        lopHocPhanService.createHocKy("Học kỳ 1 (2021-2022)");
        lopHocPhanService.createHocKy("Học kỳ 2 (2021-2022)");
        lopHocPhanService.createHocKy("Học kỳ 1 (2022-2023)");
        lopHocPhanService.createHocKy("Học kỳ 2 (2022-2023)");
        lopHocPhanService.createHocKy("Học kỳ 1 (2023-2024)");
        lopHocPhanService.createHocKy("Học kỳ 2 (2023-2024)");
        lopHocPhanService.createHocKy("Học kỳ 1 (2024-2025)");
        lopHocPhanService.createHocKy("Học kỳ 2 (2024-2025)");
        return khoaCNTT;
    }

    //Sinh viên, giảng viên, giáo vụ
    @GetMapping("/createSample2")
    public boolean createSample2() {
        DanhSachSinhVienRequest danhSachSinhVienRequest = new DanhSachSinhVienRequest();
        danhSachSinhVienRequest.setKhoa(16);
        danhSachSinhVienRequest.setMaNganh(1);
        List<SinhVienCreate> sinhVienCreates = Arrays.asList(
                new SinhVienCreate("Đào Thị Ngọc Bích", LocalDate.of(2002, 2, 9), true, "Gò Vấp, TP.HCM", "0123456789", "123456789"),
                new SinhVienCreate("Nguyễn Văn A", LocalDate.of(2001, 1, 10), false, "Quận 1, TP.HCM", "0987654321", "987654321"),
                new SinhVienCreate("Trần Thị Bảo", LocalDate.of(2003, 3, 15), true, "Quận 2, TP.HCM", "0912345678", "192837465"),
                new SinhVienCreate("Lê Minh Hoàng", LocalDate.of(2000, 4, 20), false, "Quận 3, TP.HCM", "0908765432", "109283746"),
                new SinhVienCreate("Phạm Thị Mai", LocalDate.of(2002, 5, 25), true, "Quận 4, TP.HCM", "0923456789", "876543210"),
                new SinhVienCreate("Ngô Văn Long", LocalDate.of(2001, 6, 30), false, "Quận 5, TP.HCM", "0934567890", "102938475"),
                new SinhVienCreate("Vũ Thị Lan", LocalDate.of(2003, 7, 5), true, "Quận 6, TP.HCM", "0945678901", "293847561"),
                new SinhVienCreate("Đặng Minh Tâm", LocalDate.of(2000, 8, 10), false, "Quận 7, TP.HCM", "0956789012", "384756192"),
                new SinhVienCreate("Hoàng Thị Nhung", LocalDate.of(2002, 9, 15), true, "Quận 8, TP.HCM", "0967890123", "475619283"),
                new SinhVienCreate("Lý Văn Thành", LocalDate.of(2001, 10, 20), false, "Quận 9, TP.HCM", "0978901234", "561928374"),
                new SinhVienCreate("Trương Thị Hương", LocalDate.of(2003, 11, 25), true, "Quận 10, TP.HCM", "0989012345", "649283715"),
                new SinhVienCreate("Nguyễn Văn Tuấn", LocalDate.of(2000, 12, 30), false, "Quận 11, TP.HCM", "0990123456", "738291564"),
                new SinhVienCreate("Lê Thị Thu", LocalDate.of(2002, 1, 5), true, "Quận 12, TP.HCM", "0910123456", "827364591"),
                new SinhVienCreate("Phạm Văn Dũng", LocalDate.of(2001, 2, 10), false, "Thủ Đức, TP.HCM", "0901234567", "918273645"),
                new SinhVienCreate("Trần Thị Bích", LocalDate.of(2003, 3, 15), true, "Bình Thạnh, TP.HCM", "0912345678", "827364592"),
                new SinhVienCreate("Lê Minh Đức", LocalDate.of(2000, 4, 20), false, "Phú Nhuận, TP.HCM", "0923456789", "918273644"),
                new SinhVienCreate("Ngô Thị Thanh", LocalDate.of(2002, 5, 25), true, "Gò Vấp, TP.HCM", "0934567890", "102938477"),
                new SinhVienCreate("Vũ Văn Tùng", LocalDate.of(2001, 6, 30), false, "Tân Bình, TP.HCM", "0945678901", "109283745"),
                new SinhVienCreate("Đặng Thị Liên", LocalDate.of(2003, 7, 5), true, "Tân Phú, TP.HCM", "0956789012", "293847563"),
                new SinhVienCreate("Hoàng Văn Bình", LocalDate.of(2000, 8, 10), false, "Bình Tân, TP.HCM", "0967890123", "384756191"),
                new SinhVienCreate("Lý Thị Lan", LocalDate.of(2002, 9, 15), true, "Củ Chi, TP.HCM", "0978901234", "475619281"),
                new SinhVienCreate("Trương Văn Hùng", LocalDate.of(2001, 10, 20), false, "Hóc Môn, TP.HCM", "0989012345", "561928372"),
                new SinhVienCreate("Nguyễn Thị Hồng", LocalDate.of(2003, 11, 25), true, "Nhà Bè, TP.HCM", "0990123456", "649283713"),
                new SinhVienCreate("Lê Văn Khánh", LocalDate.of(2000, 12, 30), false, "Bình Chánh, TP.HCM", "0910123456", "738291562"),
                new SinhVienCreate("Phạm Thị Mai", LocalDate.of(2002, 1, 5), true, "Cần Giờ, TP.HCM", "0901234567", "827364590"),
                new SinhVienCreate("Trần Văn Nam", LocalDate.of(2001, 2, 10), false, "Gò Vấp, TP.HCM", "0912345678", "918273642"),
                new SinhVienCreate("Lê Thị Thùy", LocalDate.of(2003, 3, 15), true, "Quận 1, TP.HCM", "0923456789", "827364593"),
                new SinhVienCreate("Ngô Văn Phúc", LocalDate.of(2000, 4, 20), false, "Quận 2, TP.HCM", "0934567890", "918273647"),
                new SinhVienCreate("Vũ Thị Phương", LocalDate.of(2002, 5, 25), true, "Quận 3, TP.HCM", "0945678901", "102938479"),
                new SinhVienCreate("Đặng Văn Thanh", LocalDate.of(2001, 6, 30), false, "Quận 4, TP.HCM", "0956789012", "109283748")
        );
        danhSachSinhVienRequest.setDanhSachSinhVien(sinhVienCreates);
        userAndAuthenticationService.createListSinhVien(danhSachSinhVienRequest);
        List<GiangVienRequest> giangVienRequests = Arrays.asList(
                // 15 giảng viên ngành 1
                new GiangVienRequest("Nguyễn Thị Lan", LocalDate.of(1985, 4, 10), true, "Quận 1, TP.HCM", "0331234567", "NguyenThiLan@gmail.com", "223344556", 1, "050093210765"),
                new GiangVienRequest("Hoàng Văn Bình", LocalDate.of(1981, 11, 19), false, "Quận Bình Thạnh, TP.HCM", "0345678901", "HoangVanBinh@gmail.com", "334455667", 1, "050092109854"),
                new GiangVienRequest("Phạm Thị Thu", LocalDate.of(1977, 7, 23), true, "Quận Phú Nhuận, TP.HCM", "0356789012", "PhamThiThu@gmail.com", "445566778", 1, "050091098743"),
                new GiangVienRequest("Lê Minh Tuấn", LocalDate.of(1992, 2, 28), false, "Quận Tân Bình, TP.HCM", "0367890123", "LeMinhTuan@gmail.com", "556677889", 1, "050090987632"),
                new GiangVienRequest("Ngô Thị Hạnh", LocalDate.of(1988, 6, 14), true, "Quận Tân Phú, TP.HCM", "0378901234", "NgoThiHanh@gmail.com", "667788990", 1, "050089876521"),
                new GiangVienRequest("Đặng Văn Tùng", LocalDate.of(1979, 12, 5), false, "Quận Bình Tân, TP.HCM", "0389012345", "DangVanTung@gmail.com", "778899001", 1, "050088765410"),
                new GiangVienRequest("Trương Thị Bích", LocalDate.of(1986, 3, 9), true, "Quận 2, TP.HCM", "0390123456", "TruongThiBich@gmail.com", "889900112", 1, "050087654309"),
                new GiangVienRequest("Nguyễn Thành Long", LocalDate.of(1984, 10, 17), false, "Quận 5, TP.HCM", "0310234567", "NguyenThanhLong@gmail.com", "990011223", 1, "050086543298"),
                new GiangVienRequest("Phạm Thị Thu Hằng", LocalDate.of(1982, 9, 27), true, "Quận 6, TP.HCM", "0321345678", "PhamThiThuHang@gmail.com", "011122334", 1, "050085432187"),
                new GiangVienRequest("Trần Minh Hòa", LocalDate.of(1991, 5, 31), false, "Quận 8, TP.HCM", "0332456789", "TranMinhHoa@gmail.com", "122233445", 1, "050084321076"),
                new GiangVienRequest("Lê Thị Thùy", LocalDate.of(1989, 11, 22), true, "Quận 10, TP.HCM", "0343567890", "LeThiThuy@gmail.com", "233344556", 1, "050083210965"),
                new GiangVienRequest("Nguyễn Văn An", LocalDate.of(1976, 8, 18), false, "Quận 11, TP.HCM", "0354678901", "NguyenVanAn@gmail.com", "344455667", 1, "050082109854"),
                new GiangVienRequest("Hoàng Thị Ngọc", LocalDate.of(1987, 6, 3), true, "Quận 12, TP.HCM", "0365789012", "HoangThiNgoc@gmail.com", "455566778", 1, "050081098743"),
                new GiangVienRequest("Phạm Văn Dũng", LocalDate.of(1993, 4, 11), false, "Quận Thủ Đức, TP.HCM", "0376890123", "PhamVanDung@gmail.com", "566677889", 1, "050080987632"),
                new GiangVienRequest("Lê Thị Mỹ Linh", LocalDate.of(1980, 1, 1), true, "Quận Gò Vấp, TP.HCM", "0387901234", "LeThiMyLinh@gmail.com", "677788990", 1, "050079876521"),
                // 15 giảng viên ngành 2, 3, 4, 5
                new GiangVienRequest("Nguyễn Văn Lường", LocalDate.of(1980, 1, 1), false, "Gò Vấp, TP.HCM", "0379046322", "NguyenVanLuong@gmail.com", "272908456", 2, "050097821573"),
                new GiangVienRequest("Trần Thị Mai", LocalDate.of(1975, 5, 15), true, "Quận 1, TP.HCM", "0381234567", "TranThiMai@gmail.com", "182736455", 2, "050098765432"),
                new GiangVienRequest("Phạm Minh Hoàng", LocalDate.of(1983, 8, 20), false, "Quận 3, TP.HCM", "0398765432", "PhamMinhHoang@gmail.com", "192837465", 2, "050096543210"),
                new GiangVienRequest("Lê Thị Hồng", LocalDate.of(1990, 12, 30), true, "Quận 7, TP.HCM", "0312345678", "LeThiHong@gmail.com", "102938475", 2, "050095432187"),
                new GiangVienRequest("Vũ Văn Hưng", LocalDate.of(1978, 3, 25), false, "Thủ Đức, TP.HCM", "0321456789", "VuVanHung@gmail.com", "112233445", 3, "050094321876"),
                new GiangVienRequest("Nguyễn Thị Lan Anh", LocalDate.of(1985, 4, 10), true, "Quận 9, TP.HCM", "0331234567", "NguyenThiLanAnh@gmail.com", "223344556", 3, "050093210765"),
                new GiangVienRequest("Hoàng Văn Tú", LocalDate.of(1981, 11, 19), false, "Quận Bình Thạnh, TP.HCM", "0345678901", "HoangVanTu@gmail.com", "334455667", 3, "050092109854"),
                new GiangVienRequest("Phạm Thị Thanh", LocalDate.of(1977, 7, 23), true, "Quận Phú Nhuận, TP.HCM", "0356789012", "PhamThiThanh@gmail.com", "445566778", 4, "050091098743"),
                new GiangVienRequest("Lê Minh Đức", LocalDate.of(1992, 2, 28), false, "Quận Tân Bình, TP.HCM", "0367890123", "LeMinhDuc@gmail.com", "556677889", 4, "050090987632"),
                new GiangVienRequest("Ngô Thị Minh", LocalDate.of(1988, 6, 14), true, "Quận Tân Phú, TP.HCM", "0378901234", "NgoThiMinh@gmail.com", "667788990", 4, "050089876521"),
                new GiangVienRequest("Đặng Văn An", LocalDate.of(1979, 12, 5), false, "Quận Bình Tân, TP.HCM", "0389012345", "DangVanAn@gmail.com", "778899001", 4, "050088765410"),
                new GiangVienRequest("Trương Thị Hương", LocalDate.of(1986, 3, 9), true, "Quận 2, TP.HCM", "0390123456", "TruongThiHuong@gmail.com", "889900112", 5, "050087654309"),
                new GiangVienRequest("Nguyễn Thành Hưng", LocalDate.of(1984, 10, 17), false, "Quận 5, TP.HCM", "0310234567", "NguyenThanhHung@gmail.com", "990011223", 5, "050086543298"),
                new GiangVienRequest("Phạm Thị Hòa", LocalDate.of(1982, 9, 27), true, "Quận 6, TP.HCM", "0321345678", "PhamThiHoa@gmail.com", "011122334", 5, "050085432187"),
                new GiangVienRequest("Trần Minh Khoa", LocalDate.of(1991, 5, 31), false, "Quận 8, TP.HCM", "0332456789", "TranMinhKhoa@gmail.com", "122233445", 5, "050084321076")
        );
        for (GiangVienRequest giangVienRequest : giangVienRequests) {
            userAndAuthenticationService.createGiangVien(giangVienRequest);
        }
        List<HocPhanCreateRequest> hocPhanCreateRequests = Arrays.asList(
                // Môn đại cương
                new HocPhanCreateRequest("Nhập môn Tin học", 0, 0, 2, 0),
                new HocPhanCreateRequest("Chứng chỉ TOEIC 450", 0, 0, 0, 0),
                new HocPhanCreateRequest("Kỹ năng làm việc nhóm", 0, 0, 2, 0),
                new HocPhanCreateRequest("Giáo dục Quốc phòng và An ninh 1", 0, 0, 4, 0),
                new HocPhanCreateRequest("Toán cao cấp 1", 0, 0, 2, 0),
                new HocPhanCreateRequest("Giáo dục thể chất 1", 0, 0, 0, 2),
                new HocPhanCreateRequest("Nhập môn Lập trình", 0, 0, 0, 2),
                new HocPhanCreateRequest("Triết học Mác - Lênin", 0, 0, 3, 0),
                new HocPhanCreateRequest("Tiếng anh 1", 0, 0, 3, 0),
                new HocPhanCreateRequest("Giáo dục thể chất 2", 0, 0, 0, 2),
                new HocPhanCreateRequest("Giáo dục quốc phòng và an ninh 2", 0, 0, 2, 2),
                new HocPhanCreateRequest("Kinh tế chính trị Mác - Lênin", 0, 0, 2, 0),
                new HocPhanCreateRequest("Tiếng Anh 2", 0, 0, 3, 0),
                new HocPhanCreateRequest("Toán cao cấp 2", 0, 0, 2, 0),
                new HocPhanCreateRequest("Pháp luật đại cương", 0, 0, 2, 0),
                new HocPhanCreateRequest("Lịch sử Đảng Cộng sản Việt Nam", 0, 0, 2, 0),
                new HocPhanCreateRequest("Tư tưởng Hồ Chí Minh", 0, 0, 2, 0),

                // Môn của khoa (CNTT)
                new HocPhanCreateRequest("Hệ Thống Máy tính", 0, 1, 3, 1),
                new HocPhanCreateRequest("Cấu trúc rời rạc", 0, 1, 3, 0),
                new HocPhanCreateRequest("Hệ Thống và Công nghệ Web", 0, 1, 2, 1),
                new HocPhanCreateRequest("Thống kê máy tính và ứng dụng", 0, 1, 1, 1),
                new HocPhanCreateRequest("Công nghệ mới trong phát triển ứng dụng CNTT", 0, 1, 1, 1),
                new HocPhanCreateRequest("Thực tập doanh nghiệp", 0, 1, 0, 5),
                new HocPhanCreateRequest("Khóa luận tốt nghiệp", 0, 1, 0, 8),

                // Môn chuyên ngành
                new HocPhanCreateRequest("Kỹ thuật lập trình", 1, 0, 2, 1),
                new HocPhanCreateRequest("Cấu trúc dữ liệu và giải thuật", 1, 0, 3, 1),
                new HocPhanCreateRequest("Hệ cơ sở dữ liệu", 1, 0, 3, 1),
                new HocPhanCreateRequest("Lập trình hướng đối tượng", 1, 0, 2, 1),
                new HocPhanCreateRequest("Lập trình hướng sự kiện với công nghệ .NET", 1, 0, 3, 1),
                new HocPhanCreateRequest("Lập trình hướng sự kiện với công nghệ Java", 1, 0, 3, 1),
                new HocPhanCreateRequest("Lập trình GUI với Qt Framework", 1, 0, 3, 1),
                new HocPhanCreateRequest("Kỹ thuật điện tử", 1, 0, 2, 1),
                new HocPhanCreateRequest("Lập trình phân tích dữ liệu 1", 1, 0, 2, 1),
                new HocPhanCreateRequest("Khai thác dữ liệu và ứng dụng", 1, 0, 2, 1),
                new HocPhanCreateRequest("Lập trình WWW (Java)", 1, 0, 3, 1),
                new HocPhanCreateRequest("Automat & ngôn ngữ hình thức", 1, 0, 3, 0),
                new HocPhanCreateRequest("Nhập môn dữ liệu lớn", 1, 0, 2, 1),
                new HocPhanCreateRequest("Lập trình phân tích dữ liệu 2", 1, 0, 2, 1),
                new HocPhanCreateRequest("Tiếp thị điện tử", 1, 0, 2, 1),
                new HocPhanCreateRequest("Kiến trúc hướng dịch vụ và Điện toán đám mây", 1, 0, 2, 1),
                new HocPhanCreateRequest("Lập trình thiết bị di động nâng cao", 1, 0, 2, 1),
                new HocPhanCreateRequest("Quản lý dự án CNTT", 1, 0, 2, 1)
        );
        for (HocPhanCreateRequest hocPhanCreateRequest : hocPhanCreateRequests) {
            hocPhanService.createHocPhan(hocPhanCreateRequest);
        }
        return true;
    }

    //Get all sinh vien
    @GetMapping("/getAllSinhVien")
    public List<SinhVien> getAllSinhVien() {
        return userAndAuthenticationService.getAllSinhVien();
    }

    @GetMapping("/getKetQuaHocPhan")
    public KetQuaHocPhan getKetQuaHocPhan(){
        KetQuaHocPhan ketQuaHocPhan = ketQuaHocPhanRepository.getReferenceById(5L);
        return ketQuaHocPhan;
    }

}
