package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.id.SinhVien_HocPhanPK;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhanDaDangKy;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import java.util.List;
@Repository
public interface HocPhanDaDangKyRepository extends JpaRepository<HocPhanDaDangKy, SinhVien_HocPhanPK> {
    List<HocPhanDaDangKy> findAllByMaSV(SinhVien sv);
}