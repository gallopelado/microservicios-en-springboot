package com.juan.course.service;

import com.juan.course.config.CourseMapper;
import com.juan.course.dto.CourseDTO;
import com.juan.course.entity.Course;
import com.juan.course.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    // crea un atributo del tipo interfaz
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        return CourseMapper.toDTO(courseRepository.save(modelMapper.map(courseDTO, Course.class)));
    }

    @Override
    public CourseDTO findByCourseCode(String courseCode) {
        return CourseMapper.toDTO(courseRepository.findByCourseCode(courseCode));
    }
}
