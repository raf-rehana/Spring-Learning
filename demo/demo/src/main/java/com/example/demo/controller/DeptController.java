package com.example.demo.controller;
import com.example.demo.entity.Department;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department/")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department department) {
        Department savedDepartment = deptService.save(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        List<Department> list = deptService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> findById(@PathVariable("id") Integer id) {
        Department department = deptService.getById(id)
                .orElseThrow(() -> new RuntimeException("Department Not Found with this ID"));

        return ResponseEntity.ok(department);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        deptService.delete(id);

        return ResponseEntity.ok("Department Deleted Successfully");
    }

    @PutMapping("{id}")
    public  ResponseEntity<Department> update(
            @PathVariable Integer id,
            @RequestBody Department department
    ){

        department.setId(id);
        Department updatedDepartment = deptService.save(department);

        return  ResponseEntity.ok(updatedDepartment);

    }
}
