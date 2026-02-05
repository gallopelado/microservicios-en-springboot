package com.juan.enrollment.controller;

import com.juan.enrollment.dto.EnrollmentDTO;
import com.juan.enrollment.entity.Enrollment;
import com.juan.enrollment.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentDTO save(@RequestBody EnrollmentDTO enrollmentDTO) {
        return enrollmentService.save(enrollmentDTO);
    }

    @GetMapping("/{id}")
    public EnrollmentDTO findById(@PathVariable("id") Long id) {
        return enrollmentService.findById(id);
    }

}
