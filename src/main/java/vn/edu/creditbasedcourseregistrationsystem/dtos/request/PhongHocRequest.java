package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhongHocRequest {
    private String tenPhong;
    private boolean phongLyThuyet;
}
