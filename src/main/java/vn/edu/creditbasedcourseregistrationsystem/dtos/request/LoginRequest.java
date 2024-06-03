package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private long tenDangNhap;
    private String matKhau;

}
