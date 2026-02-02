package com.juan.students.service;

import com.juan.students.entity.Student;

public interface StudentService {

    Student save(Student student);

    Student findByIdentificationNumber(String identificationNumber);

}
