package com.juan.enrollment.dto;

public record EnrollmentResponseDTO(
        EnrollmentDTO enrollmentDTO,
        CourseDTO courseDTO,
        StudentDTO studentDTO
) {
}
