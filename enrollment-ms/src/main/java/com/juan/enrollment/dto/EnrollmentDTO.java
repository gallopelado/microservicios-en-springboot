package com.juan.enrollment.dto;

import java.time.LocalDateTime;

public record EnrollmentDTO(
        Long id, String courseCode, String identificationNumber, LocalDateTime enrollmentDate
) {
}
