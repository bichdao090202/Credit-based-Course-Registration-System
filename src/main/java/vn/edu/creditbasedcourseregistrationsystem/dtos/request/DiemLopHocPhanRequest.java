package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DiemLopHocPhanRequest {
    private long maHocPhan;
    private int hocKy;
    private List<KetQuaSinhVien> listKetQuaSinhVien;

}
