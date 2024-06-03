package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.GiaoVu;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GiaoVuRepository extends JpaRepository<GiaoVu, Long>{

}
