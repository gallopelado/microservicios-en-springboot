package com.juan.students.controller;

import com.juan.students.entity.Student;
import com.juan.students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/identification-number/{identification}")
    public Student getByIdentificationNumber(@PathVariable("identification") String identificationNumber) {
        return studentService.findByIdentificationNumber(identificationNumber);
    }

}
