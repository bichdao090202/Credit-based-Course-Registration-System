package vn.edu.creditbasedcourseregistrationsystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class KetQuaSinhVien {
    private long maSinhVien;
    private List<Double> listDiem;




}
