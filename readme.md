# Hệ thống giáo dục theo tín chỉ
## Các API:
* SampleData:
    * [GET] /Sample/createSample1
```http 
localhost:8080/Sample/createSample1
```

* SinhVien:
    * [GET] [/SinhVien/login](#SinhVien/login)
* GiaoVu:
    * [POST] [/GiaoVu/createDanhSachSinhVien](#GiaoVu/createDanhSachSinhVien)
      
  
[Menu Item Text](#h)

## Chi tiết API
### Sinh viên
#### SinhVien/login
Path:
```http
localhost:8080/SinhVien/login
```

Body Request:
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
  "khoa": 16,
  "ngaySinh": "2002-02-09",
  "gioiTinh": true,
  "totNghiep": false,
  "nganh": {
    "maNganh": 1,
    "tenNganh": "Kỹ thuật phần mềm",
    "khoa": {
      "maKhoa": 1,
      "tenKhoa": "Khoa Công nghệ thông tin"
    }
  }
}
```

### Giáo vụ
#### GiaoVu/createDanhSachSinhVien
Path:
```http
localhost:8080/GiaoVu/createDanhSachSinhVien
```

Body Request:
```json
{
  "maNganh": 1,
  "khoa": 16,
  "danhSachSinhVien": [
    {
      "tenSinhVien": "Đào Thị Ngọc Bích",
        "ngaySinh": "2002-02-09",
        "gioiTinh": true,
        "diaChi": "phường 7, Gò Vấp",
        "soDienThoai": "0123456789",
        "soCCCD": "123456789"
    },
    {
      "tenSinhVien": "Nguyễn Văn A",
      "ngaySinh": "2002-03-08",
      "gioiTinh": true,
      "diaChi": "Hà Nội",
      "soDienThoai": "0123456789",
      "soCCCD": "987654321"
    }
  ]
}
```

Response:
```json
{
  "maLop": 1,
  "maMonHoc": 1,
  "maGiaoVien": 1,
  "danhSachSinhVien": [
    {
      "maSinhVien": 10001,
      "diem": 0
    },
    {
      "maSinhVien": 10002,
      "diem": 0
    }
  ]
}
```

#### h
