package com.juan.course.service;

import com.juan.course.entity.Course;
import com.juan.course.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    // crea un atributo del tipo interfaz
    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }
}
