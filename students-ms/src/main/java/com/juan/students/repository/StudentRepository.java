package com.juan.students.repository;

import com.juan.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByIdentificationNumber(String identificationNumber);
}
