package vn.edu.creditbasedcourseregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Nganh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maNganh;
    private String tenNganh;
    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;


    public Nganh(long maNganh) {
        this.maNganh = maNganh;
    }

    public Nganh(String tenNganh, Khoa khoa) {
        this.tenNganh = tenNganh;
        this.khoa = khoa;
    }
}
