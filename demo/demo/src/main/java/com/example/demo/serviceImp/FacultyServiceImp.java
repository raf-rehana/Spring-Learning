package com.example.demo.serviceImp;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.FacultyDTO;
import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImp implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional<Faculty> getById(Integer id) {
        return facultyRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public FacultyDTO getFacultyWithDepartments(Integer facultyId) {
        return null;
    }

    @Override
    public List<DepartmentDTO> getDepartmentsByFacultyId(Integer facultyId) {
        return List.of();
    }
}