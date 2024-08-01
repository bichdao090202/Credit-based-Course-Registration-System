package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocKy;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocPhan;

import java.util.List;
@Repository
public interface KetQuaHocPhanRepository extends JpaRepository<KetQuaHocPhan, Long> {
    @Query("SELECT k FROM KetQuaHocPhan k WHERE k.hocPhan = ?1 AND k.ketQuaHocKy.id.maSinhVien = ?2")
    KetQuaHocPhan findByHocPhanAndMaSinhVien(HocPhan hocPhan, long maSinhVien);

    List<KetQuaHocPhan> findByKetQuaHocKy(KetQuaHocKy ketQuaHocKy);

}
