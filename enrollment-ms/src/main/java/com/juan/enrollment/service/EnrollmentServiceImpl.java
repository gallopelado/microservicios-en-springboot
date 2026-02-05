package com.juan.enrollment.service;

import com.juan.enrollment.entity.Enrollment;
import com.juan.enrollment.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }
}
