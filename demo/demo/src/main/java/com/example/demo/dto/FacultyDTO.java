package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDTO {
    private Integer facultyId;
    private String facultyName;
    private String facultyCode;
    private List<DepartmentDTO> departments;
}