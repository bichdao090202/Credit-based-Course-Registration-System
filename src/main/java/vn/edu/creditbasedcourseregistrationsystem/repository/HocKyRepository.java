package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.HocKy;

@Repository
public interface HocKyRepository extends JpaRepository<HocKy, Long> {

}
