# Hệ thống giáo dục theo tín chỉ
## Các API:
* SampleData:
    * [GET] /Sample/createSample1
```http 
localhost:8080/Sample/createSample1
```

* SinhVien:
    * [GET] [/sinhvien/login](#SinhVien/login) - 
    * [POST] [/sinhvien/dangKyHocPhan](#SinhVien/dangKyHocPhan)
    * [GET] [/sinhvien/getLichHoc](#SinhVien/getLichHoc)
    * [GET] [/sinhvien/getKetQuaHocTap](#SinhVien/getKetQuaHocTap) -
    * [GET] [/sinhvien/getChuongTrinhHoc](#SinhVien/getChuongTrinhHoc)
* GiangVien: 
    * [POST] [/giangvien/nhapDiemChoLopHocPhan](#giangvien/nhapDiemChoLopHocPhan) -
    * [GET] [/giangvien/getLichDay](#GiangVien/getLichDay)
* GiaoVu:
    * [POST] [/giaovu/createDanhSachSinhVien](#GiaoVu/createDanhSachSinhVien) -
    * [POST] [/giaovu/createPhongHoc](#GiaoVu/createPhongHoc)
    * [POST] [/giaovu/createHocPhan](#GiaoVu/createHocPhan)
    * [POST] [/giaovu/createLopHocPhan](#GiaoVu/createLopHocPhan)
    * Tạo niên giám

## Chi tiết API
### Giáo vụ
#### createDanhSachSinhVien
Path:
```
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
[
  {
    "maSinhVien": 10031,
    "tenSinhVien": "Đào Thị Ngọc Bích",
    "ngaySinh": "2002-02-09",
    "gioiTinh": true,
    "diaChi": "phường 7, Gò Vấp",
    "soDienThoai": "0123456789",
    "soCCCD": "123456789",
    "khoa": 16
  },
  {
    "maSinhVien": 10032,
    "tenSinhVien": "Nguyễn Văn A",
    "ngaySinh": "2002-03-08",
    "gioiTinh": true,
    "diaChi": "Hà Nội",
    "soDienThoai": "0123456789",
    "soCCCD": "987654321",
    "khoa": 16
  }
]
```

### Giảng viên
#### Nhập điểm cho danh sách sinh viên
Path:
```
localhost:8080/giangvien/nhapDiemChoLopHocPhan
```

Body Request:

Môn lý thuyết:
```json
{
  "maHocPhan": 19,
  "hocKy":1,
  "listKetQuaSinhVien": [
    {
      "maSinhVien": 10031,
      "listDiem": [9,9,9,9,9]
    },
    {
      "maSinhVien": 10032,
      "listDiem": [8,8,8,8,8]
    }
  ]
}
```

Môn thực hành:
```json
{
  "maHocPhan": 20,
  "hocKy":1,
  "listKetQuaSinhVien": [
    {
      "maSinhVien": 10031,
      "listDiem": [9,9,9,6,9,9,9,8]
    },
    {
      "maSinhVien": 10032,
      "listDiem": [6,6,6,9,6,6,6,9]
    }
  ]
}
```


Response: Trả về danh sách sinh viên có điểm không hợp lệ, ví dụ:
Body request:
```json
{
  "maHocPhan": 20,
  "hocKy":1,
  "listKetQuaSinhVien": [
    {
      "maSinhVien": 10031,
      "listDiem": [9,9,0,6,9,9,9,8]
    },
    {
      "maSinhVien": 10032,
      "listDiem": [6,6,7,9,6,6,6,9]
    }
  ]
}
```

Response:
```json
[
    10031
]
```
### Sinh viên
#### SinhVien/login
Path:
```
localhost:8080/sinhvien/login
```

Body Request:
```json
{
  "tenDangNhap": "10031",
  "matKhau":1111
}
```

Response:
```json
{
  "maSinhVien": 10031,
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

#### Xem kết quả học tập của sinh viên: 

Path:
```
/sinhvien/getKetQuaSinhVien/{maSinhVien}
```

Response:
```json
{
  "diemTrungBinh": 8.53,
  "soTinChiTichLuy": 6,
  "xepLoai": "Giỏi",
  "ketQuaHocKySinhViens": [
    {
      "hocKy": 1,
      "ketQuaHocPhanDetails": [
        {
          "listDiem": [
            9.0,
            9.0,
            9.0,
            9.0,
            0.0,
            0.0,
            0.0,
            9.0
          ],
          "ketQuaHeSo": 9.0,
          "ketQuaChu": "A+",
          "xepLoai": "Xuất sắc",
          "quaMon": true,
          "maHocPhan": 19,
          "tenHocPhan": "Cấu trúc rời rạc"
        },
        {
          "listDiem": [
            9.0,
            9.0,
            9.0,
            6.0,
            9.0,
            9.0,
            9.0,
            8.0
          ],
          "ketQuaHeSo": 8.07,
          "ketQuaChu": "A",
          "xepLoai": "Giỏi",
          "quaMon": true,
          "maHocPhan": 20,
          "tenHocPhan": "Hệ Thống và Công nghệ Web"
        }
      ],
      "diemTrungBinh": 8.53,
      "soTinChiTichLuy": 6,
      "xepLoai": "Giỏi"
    }
  ]
}
```


