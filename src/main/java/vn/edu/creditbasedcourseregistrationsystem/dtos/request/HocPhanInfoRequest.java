package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HocPhanInfoRequest {
    private long maHocPhan;
    private String tenHocPhan;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;

}
