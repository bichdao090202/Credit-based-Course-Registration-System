package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
}
