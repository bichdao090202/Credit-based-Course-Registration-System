package vn.edu.creditbasedcourseregistrationsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class HocKy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maHocKy;
    private String tenHocKy;

    public HocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }

    public HocKy(long maHocKy) {
        this.maHocKy = maHocKy;
    }
}
