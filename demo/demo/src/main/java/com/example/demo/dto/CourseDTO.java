package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDTO {
    private Integer courseId;
    private  String courseName;
    private Integer departmentId;
    private  String departmentName;
}
