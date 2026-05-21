package com.example.demo.service;

import com.example.demo.dto.DivisionDTO;
import com.example.demo.entity.Division;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DivisionService {
    Division save(Division divison);
    List<Division> findAll();
    Optional<Division> getById(Integer id);
    void delete(Integer id);

    List<DivisionDTO> getDivisionsByCountryId(Integer countryId);

    List<DivisionDTO> getDivisionsByCountryName(String countryName);

}
