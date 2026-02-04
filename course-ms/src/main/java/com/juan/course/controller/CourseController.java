package com.juan.course.controller;

import com.juan.course.entity.Course;
import com.juan.course.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @GetMapping("/course-code/{courseCode}")
    public Course getByCourseCode(@PathVariable("courseCode") String courseCode) {
        return courseService.findByCourseCode(courseCode);
    }

}
