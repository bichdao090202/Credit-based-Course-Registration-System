package vn.edu.creditbasedcourseregistrationsystem.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocKy;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocPhan;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KetQuaHocKySinhVien {
    private int hocKy;
    private List<KetQuaHocPhanDetail> ketQuaHocPhanDetails = new ArrayList<>();
    private double diemTrungBinh;
    private int soTinChiTichLuy;
    private String xepLoai;

    public KetQuaHocKySinhVien(KetQuaHocKy ketQuaHocKy) {
        this.hocKy = ketQuaHocKy.getId().getHocKy();
        for (KetQuaHocPhan ketQuaHocPhan : ketQuaHocKy.getKetQuaHocPhans()) {
            ketQuaHocPhanDetails.add(new KetQuaHocPhanDetail(ketQuaHocPhan));
        }
        this.diemTrungBinh = Math.round(ketQuaHocKy.getDiemTrungBinh() * 100.0) / 100.0;
        this.soTinChiTichLuy = ketQuaHocKy.getSoTinChiTichLuy();
        this.xepLoai = ketQuaHocKy.getXepLoai();
    }
}
