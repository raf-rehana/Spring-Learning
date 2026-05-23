package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Subject save(Subject subject);
    List<Subject> findAll();
    Optional<Subject> getById(Integer id);
    void delete(Integer id);

    List<CourseDTO> getSubjectByDepartmentId(Integer departmentId);

    List<CourseDTO> getSubjectByDepartmentName(String departmentName);
}
