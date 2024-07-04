package vn.edu.creditbasedcourseregistrationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.creditbasedcourseregistrationsystem.dtos.request.PhongHocRequest;
import vn.edu.creditbasedcourseregistrationsystem.model.PhongHoc;
import vn.edu.creditbasedcourseregistrationsystem.repository.PhongHocRepository;

import java.util.List;

@Service
public class PhongHocService {
    @Autowired
    private PhongHocRepository phongHocRepository;
    public PhongHoc createPhongHoc(PhongHocRequest phongHocRequest) {
        if (phongHocRequest.getTenPhong() == null )
            return null;
        PhongHoc phongHoc = new PhongHoc();
        phongHoc.setTenPhong(phongHocRequest.getTenPhong());
        phongHoc.setPhongLyThuyet(phongHocRequest.isPhongLyThuyet());
        return phongHocRepository.save(phongHoc);
    }

    //phân trang
    public List<PhongHoc> getAllPhongHoc() {
        return phongHocRepository.findAll();
    }


}
