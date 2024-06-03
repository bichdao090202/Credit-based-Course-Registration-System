package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Long>{
}
