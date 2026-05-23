package com.example.demo.controller;
import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Subject;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject/")

public class CourseController {
@Autowired
private CourseService courseService;



    @PostMapping
    public ResponseEntity<Subject> save(@RequestBody Subject subject) {
        Subject savedSubject = courseService.save(subject);
        return ResponseEntity.ok(savedSubject);

    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAll() {
        List<Subject> list = courseService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Subject> findById(@PathVariable("id") Integer id) {
        Subject subject = courseService.getById(id)
                .orElseThrow(() -> new RuntimeException("Subject Not Found with this ID"));
        return ResponseEntity.ok(subject);
    }

    @PutMapping("{id}")
    public ResponseEntity<Subject> update(
            @PathVariable Integer id,
            @RequestBody Subject subject) {
        subject.setId(id);
        Subject updatedSubject = courseService.save(subject);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        courseService.delete(id);
        return ResponseEntity.ok("Subject Deleted Successfully");
    }

    @GetMapping("department/id/{id}")
    public ResponseEntity<List<CourseDTO>> getByDepartmentId(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getSubjectByDepartmentId(id));
    }


    @GetMapping("department/name/{name}")
    public ResponseEntity<List<CourseDTO>> getByDepartmentName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.getSubjectByDepartmentName(name));
    }
}
