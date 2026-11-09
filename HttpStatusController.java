package com.example.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medical-records")
public class HttpStatusController {

    // TH1 & TH4: Lỗi 400 Bad Request (Thiếu tên hoặc tuổi < 0)
    @PostMapping("/appointments")
    public ResponseEntity<String> createAppointment(
            @RequestParam(required = false) String patientName,
            @RequestParam int age) {

        if (patientName == null || patientName.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("400 Bad Request: Tên bệnh nhân không được để trống.");
        }

        if (age < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("400 Bad Request: Tuổi bệnh nhân không hợp lệ.");
        }

        return ResponseEntity.ok("Đặt lịch khám thành công.");
    }

    // TH2: Lỗi 404 Not Found (Không tìm thấy ID = 999)
    @GetMapping("/{id}")
    public ResponseEntity<String> getMedicalRecord(@PathVariable Long id) {
        if (id == 999L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("404 Not Found: Không tìm thấy hồ sơ bệnh án với ID " + id);
        }
        return ResponseEntity.ok("Thông tin hồ sơ bệnh án ID: " + id);
    }

    // TH3: Lỗi 500 Internal Server Error (Database bị sập)
    @GetMapping("/test-db")
    public ResponseEntity<String> checkDatabase() {
        boolean isDatabaseDown = true; // Giả lập lỗi sập MySQL
        if (isDatabaseDown) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("500 Internal Server Error: Không thể kết nối tới Database MySQL.");
        }
        return ResponseEntity.ok("Kết nối Database bình thường.");
    }
}