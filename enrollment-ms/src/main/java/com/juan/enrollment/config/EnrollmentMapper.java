package com.juan.enrollment.config;

import com.juan.enrollment.dto.EnrollmentDTO;
import com.juan.enrollment.entity.Enrollment;

public class EnrollmentMapper {
    public static EnrollmentDTO toDTO(Enrollment enrollment) {
        // Long id, String courseCode, String identificationNumber, LocalDateTime enrollmentDate
        return new EnrollmentDTO(
                enrollment.getId(),
                enrollment.getCourseCode(),
                enrollment.getIdentificationNumber(),
                enrollment.getEnrollmentDate()
        );
    }
}
