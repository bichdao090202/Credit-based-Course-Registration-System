package vn.edu.creditbasedcourseregistrationsystem.dtos.response;

import vn.edu.creditbasedcourseregistrationsystem.model.Nganh;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SinhVienLoginResponse {
    private long maSinhVien;
    private String tenSinhVien;
    private int khoa;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private boolean totNghiep;
    private Nganh nganh;

    public SinhVienLoginResponse(SinhVien sinhVien) {
        this.maSinhVien = sinhVien.getMaSinhVien();
        this.tenSinhVien = sinhVien.getTenSinhVien();
        this.khoa = sinhVien.getKhoa();
        this.ngaySinh = sinhVien.getNgaySinh();
        this.gioiTinh = sinhVien.isGioiTinh();
        this.totNghiep = sinhVien.isTotNghiep();
        this.nganh = sinhVien.getNganh();
    }

}
