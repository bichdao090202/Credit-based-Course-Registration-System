package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.HocKyNienGiam;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhanTheoNienGiam;

import java.util.List;
@Repository

public interface HocPhanTheoNienGiamRepository extends JpaRepository<HocPhanTheoNienGiam, Long> {
    List<HocPhanTheoNienGiam> findByHocKyNienGiam(HocKyNienGiam hocKyNienGiam);
    boolean existsByHocPhan(HocPhan hocPhan);

    boolean existsByHocPhanAndHocKyNienGiam(HocPhan hocPhan, HocKyNienGiam hocKyNienGiam);

    List<HocPhanTheoNienGiam> findByHocKyNienGiamIn(List<HocKyNienGiam> hocKyNienGiamList);
}
