package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GiangVienRequest {
    private String tenGiangVien;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private long maNganh;
    private String soTaiKhoanNganHang;

    public GiangVienRequest(String tenGiangVien, LocalDate ngaySinh, boolean gioiTinh, String diaChi, String soDienThoai, String email, String soCCCD, long maNganh, String soTaiKhoanNganHang) {
        this.tenGiangVien = tenGiangVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.soCCCD = soCCCD;
        this.maNganh = maNganh;
        this.soTaiKhoanNganHang = soTaiKhoanNganHang;
    }

}
