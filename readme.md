# Hệ thống giáo dục theo tín chỉ
## API:
* SampleData:
    * [GET] /Sample/createSample1
https://localhost:8080/Sample/createSample1

* SinhVien:
    * [GET] /SinhVien/login
https://localhost:8080/SinhVien/login
  
Body: 
```json
{
  "tenDangNhap": "10001",
  "matKhau":1111
}
```

Response:
```json
{
  "maSinhVien": 10001,
  "tenSinhVien": "Đào Thị Ngọc Bích",
  "khoa": 0,
  "ngaySinh": "2002-02-09",
  "gioiTinh": true,
  "totNghiep": false,
  "nganh": null
}
```
