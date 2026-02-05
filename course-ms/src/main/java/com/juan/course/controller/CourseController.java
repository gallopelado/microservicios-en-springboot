package com.juan.course.controller;

import com.juan.course.dto.CourseDTO;
import com.juan.course.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseDTO save(@RequestBody CourseDTO courseDTO) {
        return courseService.save(courseDTO);
    }

    @GetMapping("/course-code/{courseCode}")
    public CourseDTO getByCourseCode(@PathVariable("courseCode") String courseCode) {
        return courseService.findByCourseCode(courseCode);
    }

}
