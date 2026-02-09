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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Override
    public EnrollmentDTO save(EnrollmentDTO enrollmentDTO) {
        return EnrollmentMapper.toDTO(enrollmentRepository.save(modelMapper.map(enrollmentDTO, Enrollment.class)));
    }

    @Override
    public EnrollmentResponseDTO findById(Long id) {

        //return EnrollmentMapper.toDTO(enrollmentRepository.findById(id).get());

        Enrollment enrollmentDB = enrollmentRepository.findById(id).get();
        String studentUrl = "http://localhost:8081/api/v1/students/identification-number/" + enrollmentDB.getIdentificationNumber();
        ResponseEntity<StudentDTO> studentDTOResponseEntity = restTemplate
                .getForEntity(studentUrl, StudentDTO.class);

        String courseUrl = "http://localhost:8082/api/v1/courses/course-code/" + enrollmentDB.getCourseCode();
        ResponseEntity<CourseDTO> courseDTOResponseEntity = restTemplate
                .getForEntity(courseUrl, CourseDTO.class);

        EnrollmentDTO enrollmentDTO = EnrollmentMapper.toDTO(enrollmentDB);
        CourseDTO courseDTO = courseDTOResponseEntity.getBody();
        StudentDTO studentDTO = studentDTOResponseEntity.getBody();

        return new EnrollmentResponseDTO(enrollmentDTO, courseDTO, studentDTO);
    }
}
