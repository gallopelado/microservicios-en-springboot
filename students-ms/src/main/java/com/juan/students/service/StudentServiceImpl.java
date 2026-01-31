package com.juan.students.service;

import com.juan.students.entity.Student;
import com.juan.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByIdentificationNumber(String identificationNumber) {
        return studentRepository.findByIdentificationNumber(identificationNumber);
    }
}
