package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.FacultyDTO;
import com.example.demo.entity.Faculty;
import java.util.List;
import java.util.Optional;

public interface FacultyService {
    Faculty save(Faculty faculty);
    List<Faculty> findAll();
    Optional<Faculty> getById(Integer id);
    void delete(Integer id);
    FacultyDTO getFacultyWithDepartments(Integer facultyId);
    List<DepartmentDTO> getDepartmentsByFacultyId(Integer facultyId);
}