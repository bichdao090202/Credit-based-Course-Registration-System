package vn.edu.creditbasedcourseregistrationsystem.dtos.response;

import lombok.*;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HocPhanResponse {
    private long maHocPhan;
    private String tenHocPhan;
    private int soTinChiLythuyet;
    private int soTinChiThuchanh;
    private boolean batBuoc;

    public HocPhanResponse(HocPhan hocPhan){
        this.maHocPhan = hocPhan.getMaHocPhan();
        this.tenHocPhan = hocPhan.getTenHocPhan();
        this.soTinChiLythuyet = hocPhan.getSoTinChiLyThuyet();
        this.soTinChiThuchanh = hocPhan.getSoTinChiThucHanh();
    }


}
