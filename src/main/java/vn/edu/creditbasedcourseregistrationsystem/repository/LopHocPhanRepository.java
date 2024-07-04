package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.LopHocPhan;

import java.util.List;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {
    List<LopHocPhan> findAllByHocPhan(HocPhan hp);

    List<LopHocPhan> findByHocPhan(HocPhan hocPhan);
}