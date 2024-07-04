package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.PhongHoc;

@Repository
public interface PhongHocRepository extends JpaRepository<PhongHoc, Long> {
}
