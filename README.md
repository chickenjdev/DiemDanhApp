# DiemDanhApp

Cập nhật :
- Thêm tính năng export dữ liệu điểm danh ra file csv
- Chi tiết được trình bày trong slide ( \resource )

- user test 
 + Giảng viên :  khoi.nht ,pass 123456
 + Sinh viên : 17520001 -> 17520030 , pass : 123456
 
Các chức năng của app điểm danh 

Dành cho giảng viên :
- Xem danh sách lớp đang dạy
- Tạo lớp học mới
- Thực hiện điểm danh 
  + Điểm danh bằng gps 
  + Tạo mã QR code cho sinh viên điểm danh
- Xem danh sách sinh viên của lớp
- Xem danh sách điểm danh theo sinh viên
- Xem danh sách điểm danh theo buổi học
- Cập nhật thông tin cá nhân.

Dành cho sinh viên
- Xem danh sách lớp đang dạy
- Xem danh sách lớp đang được mở
- Tìm kiếm lớp học đang mở
- Đăng ký lớp học mới
- Chức năng điểm danh 
  + Chọn lớp điểm danh
  + Lấy tọa độ gps tai thời điểm điểm danh
  + Thực hiện quét mã QR code trên điện thoại của giáo viên
- Xem danh sách đi học, vắng học theo từng buổi của môn học
- Cập nhật thông tin cá nhân.

Luồng của ứng dụng : Chức năng điểm danh
Giảng viên thực hiện điểm danh theo lớp đang dạy :
- Mở điểm danh cho lớp , tạo mã QR và lấy địa chỉ gps của giảng viên.
- Sinh viên thực hiện chọn lớp để điểm danh , quét mã QR và lấy địa chỉ gps
- Sinh viên gửi thông tin điểm danh lên hệ thống để kiểm tra
- Điểm danh thành công khi mã QR khớp và location của sinh viên nằm trong vùng bán kính 20m so với location của giảng viên 
- Giảng viên thực hiện kết thúc điểm danh cho buổi học.
...

