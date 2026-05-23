package com.example.demo.controller;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.FacultyDTO;
import com.example.demo.entity.Faculty;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty/")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public ResponseEntity<Faculty> save(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.save(faculty));
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAll() {
        return ResponseEntity.ok(facultyService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getById(@PathVariable Integer id) {
        Faculty faculty = facultyService.getById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        return ResponseEntity.ok(faculty);
    }

    @PutMapping("{id}")
    public ResponseEntity<Faculty> update(
            @PathVariable Integer id,
            @RequestBody Faculty faculty) {
        faculty.setId(id);
        return ResponseEntity.ok(facultyService.save(faculty));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        facultyService.delete(id);
        return ResponseEntity.ok("Faculty Deleted Successfully");
    }


    @GetMapping("{id}/details")
    public ResponseEntity<FacultyDTO> getFacultyWithDepartments(@PathVariable Integer id) {
        return ResponseEntity.ok(facultyService.getFacultyWithDepartments(id));
    }


    @GetMapping("{id}/departments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments(@PathVariable Integer id) {
        return ResponseEntity.ok(facultyService.getDepartmentsByFacultyId(id));
    }
}