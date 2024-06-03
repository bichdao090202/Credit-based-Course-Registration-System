package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.Khoa;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Long> {
    Khoa findByTenKhoa(String tenKhoa);
}
