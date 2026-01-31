package com.juan.students.service;

import com.juan.students.entity.Student;

public interface StudentService {

    public Student save(Student student);

    public Student findByIdentificationNumber(String identificationNumber);

}
