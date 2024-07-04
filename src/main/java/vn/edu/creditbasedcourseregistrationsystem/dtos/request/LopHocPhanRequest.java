package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.creditbasedcourseregistrationsystem.model.GiangVien;
import vn.edu.creditbasedcourseregistrationsystem.model.HocKy;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.LichHoc;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LopHocPhanRequest {
    private long maLopHocPhan;
    private int soLuongToiDa;
    private long maGiangVien;
    private LocalDate ngayMoDangKy;
    private String tenLopHocPhan;
}
