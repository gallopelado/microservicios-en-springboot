package com.juan.enrollment.service;

import com.juan.enrollment.dto.EnrollmentDTO;


public interface EnrollmentService {
    EnrollmentDTO save(EnrollmentDTO enrollmentDTO);
    EnrollmentDTO findById(Long id);
}
