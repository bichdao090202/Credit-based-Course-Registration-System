package vn.edu.creditbasedcourseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.creditbasedcourseregistrationsystem.model.HocPhan;
import vn.edu.creditbasedcourseregistrationsystem.model.Nganh;

import java.util.List;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
    boolean existsByNganh(Nganh nganh);

    @Query("SELECT h FROM HocPhan h WHERE h.maHocPhan IN (SELECT k.hocPhan.maHocPhan FROM KetQuaHocPhan k WHERE k.ketQuaHocKy.id.maSinhVien = ?1 AND k.ketQuaHocKy.id.hocKy = ?2)")
    List<HocPhan> findByMaSinhVienAndHocKy(long maSinhVien, int hocKy);


    @Query("SELECT hp FROM HocPhan  hp WHERE hp.maHocPhan IN\n" +
            "( SELECT lhp.hocPhan.maHocPhan FROM LopHocPhan lhp WHERE lhp.maLopHocPhan IN \n" +
            "\t(SELECT lh.lopHocPhan.maLopHocPhan FROM LichHoc lh WHERE lh.maLichHoc = :maLichHoc)\n" +
            ")")
    HocPhan getHocPhanByLichHoc(@Param("maLichHoc") long maLichHoc);


        @Query(value = "SELECT * FROM hoc_phan WHERE ma_hoc_phan IN " +
                "(SELECT ma_hoc_phan FROM hoc_phan_theo_nien_giam WHERE ma_hoc_ky_nien_giam IN " +
                "(SELECT ma_hoc_ky_nien_giam FROM hoc_ky_nien_giam " +
                "WHERE ma_nganh = :maNganh AND khoa = :khoa))",
                nativeQuery = true)
        List<HocPhan> findHocPhanSinhVienDangKy(@Param("maNganh") long maNganh, @Param("khoa") int khoa);



}