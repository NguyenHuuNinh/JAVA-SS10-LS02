# [Bài tập 2] Chuẩn hóa mã lỗi HTTP (HTTP Status Codes)

## 1. Bảng tổng hợp và giải thích mã lỗi

| Tình huống | Kịch bản | Mã lỗi HTTP | Giải thích lý do |
| :--- | :--- | :--- | :--- |
| **TH1** | Người dùng gửi yêu cầu đặt lịch khám nhưng bỏ trống tên bệnh nhân. | `400 Bad Request` | Lỗi xuất phát từ phía Client do gửi thiếu dữ liệu bắt buộc (thiếu trường tên bệnh nhân), Server không thể xử lý yêu cầu. |
| **TH2** | Tìm kiếm hồ sơ bệnh án với ID là `999` nhưng trong Database không tồn tại. | `404 Not Found` | Yêu cầu hợp lệ về mặt cú pháp, nhưng tài nguyên (hồ sơ bệnh án có ID `999`) không tồn tại trên hệ thống. |
| **TH3** | Hệ thống đang chạy thì Database MySQL bị sập, không thể truy vấn dữ liệu. | `500 Internal Server Error` | Lỗi xuất phát từ phía Server (hạ tầng/cơ sở dữ liệu gặp sự cố bất ngờ), Client gửi yêu cầu hoàn toàn bình thường nhưng Server không thể thực hiện. |
| **TH4** | Người dùng nhập tuổi bệnh nhân là `-5` (Dữ liệu không hợp lệ về mặt logic). | `400 Bad Request` | Lỗi xuất phát từ phía Client do gửi dữ liệu sai quy tắc nghiệp vụ/logic (tuổi không thể là số âm). |