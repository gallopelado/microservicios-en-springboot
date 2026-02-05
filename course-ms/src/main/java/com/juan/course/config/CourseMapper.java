package com.juan.course.config;

import com.juan.course.dto.CourseDTO;
import com.juan.course.entity.Course;

public class CourseMapper {
    public static CourseDTO toDTO(Course course) {
        //  Long id, String courseCode, String title, String description
        return new CourseDTO(
                course.getId(), course.getCourseCode(), course.getTitle(), course.getDescription()
        );
    }
}
