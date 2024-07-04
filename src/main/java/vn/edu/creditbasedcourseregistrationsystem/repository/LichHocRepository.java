package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.LichHoc;
import vn.edu.creditbasedcourseregistrationsystem.model.LopHocPhan;

import java.util.List;

@Repository
public interface LichHocRepository extends JpaRepository<LichHoc, Long> {
    List<LichHoc> findAllByLopHocPhan(LopHocPhan lhp);
}