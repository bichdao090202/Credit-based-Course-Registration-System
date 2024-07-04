package vn.edu.creditbasedcourseregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.creditbasedcourseregistrationsystem.id.SinhVien_HocPhanPK;

import java.time.LocalDate;

@Entity
@Table(name = "hoc_phan_da_dang_ky")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(SinhVien_HocPhanPK.class)
public class HocPhanDaDangKy {
    @Id
    @ManyToOne
    @JoinColumn(name = "maSV")
    @JsonIgnoreProperties(value = {"email", "diaChi", "nganh"})
    private SinhVien maSV;

    @Id
    @ManyToOne
    @JoinColumn(name = "maHocPhan")
    @JsonIgnoreProperties(value = {"hocKy", "khoa", "nganh"})
    private HocPhan maHocPhan;

    private float hocKyDangKy;
    private LocalDate ngayDangKy;
}
