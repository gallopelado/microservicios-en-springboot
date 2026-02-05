package com.juan.students.service;

import com.juan.students.dto.StudentDTO;

public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);

    StudentDTO findByIdentificationNumber(String identificationNumber);

}
