package vn.edu.creditbasedcourseregistrationsystem.dtos.response;


import lombok.Getter;
import lombok.Setter;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocKy;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class KetQuaHocTapSinhVienDetail {
    private double diemTrungBinh;
    private int soTinChiTichLuy;
    private String xepLoai;
    private List<KetQuaHocKySinhVien> ketQuaHocKySinhViens = new ArrayList<>();

    public KetQuaHocTapSinhVienDetail(List<KetQuaHocKy> ketQuaHocKyList){
        double tongDiem = 0;
        this.soTinChiTichLuy = 0;
        for (KetQuaHocKy ketQuaHocKy : ketQuaHocKyList) {
            this.ketQuaHocKySinhViens.add(new KetQuaHocKySinhVien(ketQuaHocKy));
            tongDiem += ketQuaHocKy.getDiemTrungBinh()*ketQuaHocKy.getSoTinChiTichLuy();
            soTinChiTichLuy += ketQuaHocKy.getSoTinChiTichLuy();
        }
        this.diemTrungBinh = Math.round(tongDiem / soTinChiTichLuy * 100.0) / 100.0;
        this.xepLoai = xepLoai();
    }

    private String xepLoai() {
        if (diemTrungBinh >= 9)
            return "Xuất sắc";
        if (diemTrungBinh >= 8)
            return "Giỏi";
        if (diemTrungBinh >= 7)
            return "Khá";
        if (diemTrungBinh >= 5)
            return "Trung bình";
        return "Yếu";
    }
}
