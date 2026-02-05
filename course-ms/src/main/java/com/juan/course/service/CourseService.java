package com.juan.course.service;

import com.juan.course.dto.CourseDTO;

public interface CourseService {
    CourseDTO save(CourseDTO courseDTO);
    CourseDTO findByCourseCode(String courseCode);
}
