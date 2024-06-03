package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.*;

@Repository
public interface NganhRepository extends JpaRepository<Nganh, Long> {
    boolean existsByKhoa(Khoa khoa);

    Nganh findByTenNganh(String tenNganh);
}
