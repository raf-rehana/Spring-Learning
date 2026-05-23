package com.example.demo.service;
import com.example.demo.entity.Department;
import java.util.List;
import java.util.Optional;

public interface DeptService {
    Department save(Department department);
    List<Department> findAll();
    Optional<Department> getById(Integer id);
    void delete(Integer id);
}

