package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GiaoVuRequest {
    private String tenGiaoVu;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private String soTaiKhoanNganHang;

}
