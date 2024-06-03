package vn.edu.creditbasedcourseregistrationsystem.model;

import vn.edu.creditbasedcourseregistrationsystem.dtos.request.SinhVienCreate;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class SinhVien {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ma_sinh_vien")
//    @SequenceGenerator(name = "seq_ma_sinh_vien", sequenceName = "seq_ma_sinh_vien", initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen_sinh_vien")
    @TableGenerator(name = "table_gen_sinh_vien", table = "id_gen_sinh_vien", pkColumnName = "gen_name_sinh_vien", valueColumnName = "gen_val_sinh_vien", initialValue = 10000, allocationSize = 50)
    private long maSinhVien;
    private String tenSinhVien;
    private int khoa;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private String soTaiKhoanNganHang;
    private boolean totNghiep;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @OneToOne
    @JoinColumn(name = "maSinhVien")
    private TaiKhoan taiKhoan;

    public SinhVien(String tenSinhVien, int khoa, long maNganh) {
        this.tenSinhVien = tenSinhVien;
        this.khoa = khoa;
        this.nganh = new Nganh(maNganh);
    }

    public SinhVien(long mssv) {
        this.maSinhVien = mssv;
    }

    public SinhVien(SinhVienCreate sinhVienCreate) {
        this.tenSinhVien = sinhVienCreate.getTenSinhVien();
        this.ngaySinh = sinhVienCreate.getNgaySinh();
        this.gioiTinh = sinhVienCreate.isGioiTinh();
        this.diaChi = sinhVienCreate.getDiaChi();
        this.soDienThoai = sinhVienCreate.getSoDienThoai();
        this.soCCCD = sinhVienCreate.getSoCCCD();
    }

}
