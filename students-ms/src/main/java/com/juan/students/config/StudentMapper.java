package com.juan.students.config;

import com.juan.students.dto.StudentDTO;
import com.juan.students.entity.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student student) {
        // Long id, String identificationNumber, String name, String email
        return new StudentDTO(student.getId(), student.getIdentificationNumber(), student.getName(), student.getEmail());
    }
}
