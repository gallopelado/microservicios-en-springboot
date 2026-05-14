package com.juan.enrollment.service;

import com.juan.enrollment.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8082", value = "course-ms")
@FeignClient(name = "course-ms")
public interface OpenFeingConsumeCourse {

    @GetMapping("/api/v1/courses/course-code/{courseCode}")
    CourseDTO getByCourseCode(@PathVariable String courseCode);

}
