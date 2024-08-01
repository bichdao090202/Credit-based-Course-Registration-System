package vn.edu.creditbasedcourseregistrationsystem.id;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class KetQuaHocKyId implements Serializable {
    private long maSinhVien;
    private int hocKy;

    public KetQuaHocKyId(long maSinhVien, int hocKy) {
        this.maSinhVien = maSinhVien;
        this.hocKy = hocKy;
    }


    public KetQuaHocKyId() {

    }
}
