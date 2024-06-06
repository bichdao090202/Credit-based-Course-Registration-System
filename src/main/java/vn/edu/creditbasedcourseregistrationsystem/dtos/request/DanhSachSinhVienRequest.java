package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DanhSachSinhVienRequest {
    private long maNganh;
    private int khoa;
    private List<SinhVienCreate> danhSachSinhVien;
}
