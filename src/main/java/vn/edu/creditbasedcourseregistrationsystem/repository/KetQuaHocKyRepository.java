package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.id.KetQuaHocKyId;
import vn.edu.creditbasedcourseregistrationsystem.model.KetQuaHocKy;

import java.util.List;

@Repository
public interface KetQuaHocKyRepository extends JpaRepository<KetQuaHocKy, KetQuaHocKyId> {
    @Query("SELECT k FROM KetQuaHocKy k WHERE k.id.maSinhVien = ?1 AND k.id.hocKy = ?2")
    KetQuaHocKy findByMaSinhVienAndHocKy(long maSinhVien, int hocKy);

    @Query("SELECT k FROM KetQuaHocKy k WHERE k.id.maSinhVien = ?1")
    List<KetQuaHocKy> findByMaSinhVien(long maSinhVien);
}
