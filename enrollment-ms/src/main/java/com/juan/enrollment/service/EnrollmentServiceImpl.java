package com.juan.enrollment.service;

import com.juan.enrollment.config.EnrollmentMapper;
import com.juan.enrollment.dto.CourseDTO;
import com.juan.enrollment.dto.EnrollmentDTO;
import com.juan.enrollment.dto.EnrollmentResponseDTO;
import com.juan.enrollment.dto.StudentDTO;
import com.juan.enrollment.entity.Enrollment;
import com.juan.enrollment.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;

    @Override
    public EnrollmentDTO save(EnrollmentDTO enrollmentDTO) {
        return EnrollmentMapper.toDTO(enrollmentRepository.save(modelMapper.map(enrollmentDTO, Enrollment.class)));
    }

    @Override
    public EnrollmentResponseDTO findById(Long id) {

        Enrollment enrollmentDB = enrollmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Enrollment with id " + id + " not found"));

        String studentUrl = "http://localhost:8081/api/v1/students/identification-number/" + enrollmentDB.getIdentificationNumber();
        String courseUrl = "http://localhost:8082/api/v1/courses/course-code/" + enrollmentDB.getCourseCode();

        // Usamos block() para que sean síncronas
        var studentDTO = webClient.get().uri(studentUrl)
                .retrieve()
                .bodyToMono(StudentDTO.class)
                .block();

        var courseDTO = webClient.get().uri(courseUrl)
                .retrieve()
                .bodyToMono(CourseDTO.class)
                .block();

        EnrollmentDTO enrollmentDTO = EnrollmentMapper.toDTO(enrollmentDB);

        return new EnrollmentResponseDTO(enrollmentDTO, courseDTO, studentDTO);
    }
}
