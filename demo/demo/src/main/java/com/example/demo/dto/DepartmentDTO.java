package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Integer departmentId;
    private String departmentName;
    private String departmentCode;
    private Integer facultyId;
    private String facultyName;
    private List<CourseDTO> courses;
}