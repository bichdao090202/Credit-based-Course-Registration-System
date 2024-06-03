package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
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

    public GiangVienRequest(String tenGiangVien, long maNganh) {
        this.tenGiangVien = tenGiangVien;
        this.maNganh = maNganh;
    }
}
