package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.HocKyNienGiam;
import vn.edu.creditbasedcourseregistrationsystem.model.Nganh;

import java.util.List;
@Repository
public interface HocKyNienGiamRepository extends JpaRepository<HocKyNienGiam, Long> {
    @Query ("SELECT h FROM HocKyNienGiam h WHERE h.nganh = ?1 AND h.khoa = ?2")
    List<HocKyNienGiam> findByNganhAndKhoa(Nganh nganh, long khoa);
    // native query
     @Query (value = "SELECT * FROM hoc_ky_nien_giam WHERE ma_nganh = ?1 AND khoa = ?2", nativeQuery = true)
     List<HocKyNienGiam> findByNganhAndKhoa(long maNganh, long khoa);
    @Query ("SELECT h FROM HocKyNienGiam h WHERE h.nganh = ?1 AND h.khoa = ?2 AND h.hocKy = ?3")
    List<HocKyNienGiam> findByNganhAndKhoaAndHocKy(Nganh nganh, long khoa, int hocKy);

    boolean existsByNganhAndKhoaAndHocKy(Nganh nganh, long khoa, int hocKy);
}
