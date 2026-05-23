package com.example.demo.serviceImp;

import com.example.demo.entity.Department;
import com.example.demo.repository.DeptRepository;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public Department save(Department department) {
        return deptRepository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return deptRepository.findAll();
    }

    @Override
    public Optional<Department> getById(Integer id) {
        return deptRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        deptRepository.deleteById(id);
    }
}
