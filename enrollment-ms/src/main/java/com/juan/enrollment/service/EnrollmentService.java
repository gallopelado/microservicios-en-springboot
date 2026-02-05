package com.juan.enrollment.service;

import com.juan.enrollment.entity.Enrollment;


public interface EnrollmentService {
    Enrollment save(Enrollment enrollment);
    Enrollment findById(Long id);
}
