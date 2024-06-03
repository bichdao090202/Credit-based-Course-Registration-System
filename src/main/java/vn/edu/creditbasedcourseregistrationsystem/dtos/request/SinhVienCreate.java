package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SinhVienCreate {
    private String tenSinhVien;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String soCCCD;

}
