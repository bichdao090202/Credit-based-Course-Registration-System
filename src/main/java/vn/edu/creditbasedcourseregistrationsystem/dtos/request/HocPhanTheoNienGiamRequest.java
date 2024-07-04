package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class HocPhanTheoNienGiamRequest {
    private long maHocPhan;
    private long maHocKyNienGiam;

}
