package com.example.demo.repository;

import com.example.demo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Subject, Integer> {

    List<Subject> findByDepartmentId(Integer departmentId);
    List<Subject> findByDepartmentName(String departmentName);
}
