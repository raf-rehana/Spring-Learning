package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptService {
    @Autowired
    public DeptRepository deptRepository;

    public List<Department> getAll(){
        return deptRepository.findAll();
    }

    public Department saveOrUpdate(Department department){
        return deptRepository.save(department);
    }

    public Optional<Department> getById(long id){
        return deptRepository.findById(id);
    }

    public void delete(long id){
        deptRepository.deleteById(id);
    }
}
