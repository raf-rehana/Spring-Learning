package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course save(Course course);
    List<Course> findAll();
    Optional<Course> getById(Integer id);
    void delete(Integer id);

    List<CourseDTO> getCourseByDepartmentId(Integer departmentId);

    List<CourseDTO> getCourseByDepartmentName(String departmentName);
}
