package com.juan.enrollment.service;

import com.juan.enrollment.config.EnrollmentMapper;
import com.juan.enrollment.dto.EnrollmentDTO;
import com.juan.enrollment.dto.EnrollmentResponseDTO;
import com.juan.enrollment.entity.Enrollment;
import com.juan.enrollment.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final ModelMapper modelMapper;
    private final OpenFeingConsumeCourse openFeingConsumeCourse;
    private final OpenFeingConsumeStudent openFeingConsumeStudent;

    @Override
    public EnrollmentDTO save(EnrollmentDTO enrollmentDTO) {
        return EnrollmentMapper.toDTO(enrollmentRepository.save(modelMapper.map(enrollmentDTO, Enrollment.class)));
    }

    @Override
    public EnrollmentResponseDTO findById(Long id) {

        Enrollment enrollmentDB = enrollmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Enrollment with id " + id + " not found"));

        var courseDTO = openFeingConsumeCourse.getByCourseCode(enrollmentDB.getCourseCode());
        var studentDTO = openFeingConsumeStudent.getByIdentificationNumber(enrollmentDB.getIdentificationNumber());

        EnrollmentDTO enrollmentDTO = EnrollmentMapper.toDTO(enrollmentDB);

        return new EnrollmentResponseDTO(enrollmentDTO, courseDTO, studentDTO);
    }
}
