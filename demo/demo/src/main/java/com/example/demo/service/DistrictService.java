package com.example.demo.service;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.DivisionDTO;
import com.example.demo.entity.District;
import com.example.demo.entity.Division;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DistrictService {
    District save(District district);
    List<District> findAll();
    Optional<District> getById(Integer id);
    void delete(Integer id);

    List<DistrictDTO> getDistrictByDivisionId(Integer divisionId);

    List<DistrictDTO> getDistrictByDivisionName(String divisionName);

}
