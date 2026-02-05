package com.juan.students.service;

import com.juan.students.config.StudentMapper;
import com.juan.students.dto.StudentDTO;
import com.juan.students.entity.Student;
import com.juan.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        return StudentMapper.toDTO(studentRepository.save(modelMapper.map(studentDTO, Student.class)));
    }

    @Override
    public StudentDTO findByIdentificationNumber(String identificationNumber) {
        return StudentMapper.toDTO(studentRepository.findByIdentificationNumber(identificationNumber));
    }
}
