package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "courses")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String courseName;
    private Integer semester;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference(value = "department-course")
    private Department department;

    @ManyToMany(mappedBy = "courses")
    @JsonBackReference(value = "course-user")
    private List<User> users;

}
