package com.example.demo.controller;
import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course/")

public class CourseController {
@Autowired
private CourseService courseService;



    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course) {
        Course savedCourse = courseService.save(course);
        return ResponseEntity.ok(savedCourse);

    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        List<Course> list = courseService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Integer id) {
        Course course = courseService.getById(id)
                .orElseThrow(() -> new RuntimeException("Course Not Found with this ID"));
        return ResponseEntity.ok(course);
    }

    @PutMapping("{id}")
    public ResponseEntity<Course> update(
            @PathVariable Integer id,
            @RequestBody Course course) {
        course.setId(id);
        Course updatedCourse = courseService.save(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        courseService.delete(id);
        return ResponseEntity.ok("Course Deleted Successfully");
    }

    @GetMapping("department/id/{id}")
    public ResponseEntity<List<CourseDTO>> getByDepartmentId(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourseByDepartmentId(id));
    }


    @GetMapping("department/name/{name}")
    public ResponseEntity<List<CourseDTO>> getByDepartmentName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.getCourseByDepartmentName(name));
    }
}
