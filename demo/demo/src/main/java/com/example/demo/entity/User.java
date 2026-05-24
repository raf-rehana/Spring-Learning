package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String password;
    private String image;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference(value = "country-user")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "division_id")
    @JsonBackReference(value = "division-user")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonBackReference(value = "district-user")
    private District district;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    @JsonBackReference(value = "faculty-user")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference(value = "department-user")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "user_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonManagedReference(value = "course-user")
    private List<Course> courses;

}
