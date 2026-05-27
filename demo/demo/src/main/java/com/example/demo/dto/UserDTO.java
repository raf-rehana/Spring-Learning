package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private Integer countryId;
    private String countryName;
    private Integer divisionId;
    private String divisionName;
    private Integer districtId;
    private String districtName;
    private Integer departmentId;
    private String departmentName;
}