package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhanTienQuyet;

import java.util.List;
@Repository

public interface HocPhanTienQuyetRepository extends JpaRepository<HocPhanTienQuyet, Long>, CrudRepository<HocPhanTienQuyet, Long> {
    public List<HocPhanTienQuyet> findByMaHocPhan(long maHocPhan);

    public boolean existsByMaHocPhanAndMaHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet);

    @Query("SELECT h FROM HocPhanTienQuyet h WHERE h.maHocPhan = ?1 AND h.maHocPhanTienQuyet = ?2")
    public HocPhanTienQuyet findByMaHocPhanAndMaHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet);

    boolean existsByMaHocPhan(long id);

}
