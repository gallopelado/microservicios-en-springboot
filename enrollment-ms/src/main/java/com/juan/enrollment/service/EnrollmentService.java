package com.juan.enrollment.service;

import com.juan.enrollment.dto.EnrollmentDTO;
import com.juan.enrollment.dto.EnrollmentResponseDTO;


public interface EnrollmentService {
    EnrollmentDTO save(EnrollmentDTO enrollmentDTO);
    EnrollmentResponseDTO findById(Long id);
}
