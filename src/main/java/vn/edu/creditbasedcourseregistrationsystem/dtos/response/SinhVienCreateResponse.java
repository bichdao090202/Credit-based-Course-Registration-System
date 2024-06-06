package vn.edu.creditbasedcourseregistrationsystem.dtos.response;

import lombok.*;
import vn.edu.creditbasedcourseregistrationsystem.model.Nganh;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SinhVienCreateResponse {
    private long maSinhVien;
    private String tenSinhVien;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String soCCCD;
    private int khoa;

    public SinhVienCreateResponse(SinhVien sinhVien){
        this.maSinhVien = sinhVien.getMaSinhVien();
        this.tenSinhVien = sinhVien.getTenSinhVien();
        this.ngaySinh = sinhVien.getNgaySinh();
        this.gioiTinh = sinhVien.isGioiTinh();
        this.diaChi = sinhVien.getDiaChi();
        this.soDienThoai = sinhVien.getSoDienThoai();
        this.soCCCD = sinhVien.getSoCCCD();
        this.khoa = sinhVien.getKhoa();
    }

}
