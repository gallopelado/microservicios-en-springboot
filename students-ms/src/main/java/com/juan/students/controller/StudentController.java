package com.juan.students.controller;

import com.juan.students.dto.StudentDTO;
import com.juan.students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }

    @GetMapping("/identification-number/{identification}")
    public StudentDTO getByIdentificationNumber(@PathVariable("identification") String identificationNumber) {
        return studentService.findByIdentificationNumber(identificationNumber);
    }

}
