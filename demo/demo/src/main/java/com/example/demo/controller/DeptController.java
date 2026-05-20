package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class DeptController {
    @Autowired
  private DeptService deptService;

    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department d ){
        Department savedDepartment = deptService.saveOrUpdate(d);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll(){
        List<Department> list = deptService.getAll();
        return ResponseEntity.ok(list);
    }
}
