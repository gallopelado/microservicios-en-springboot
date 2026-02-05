package com.juan.enrollment.service;

import com.juan.enrollment.config.EnrollmentMapper;
import com.juan.enrollment.dto.EnrollmentDTO;
import com.juan.enrollment.entity.Enrollment;
import com.juan.enrollment.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public EnrollmentDTO save(EnrollmentDTO enrollmentDTO) {
        return EnrollmentMapper.toDTO(enrollmentRepository.save(modelMapper.map(enrollmentDTO, Enrollment.class)));
    }

    @Override
    public EnrollmentDTO findById(Long id) {

        return EnrollmentMapper.toDTO(enrollmentRepository.findById(id).get()) ;
    }
}
