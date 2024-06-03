package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
}
