package com.example.demo.service;

import com.example.demo.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {
    Country save(Country country);
    List<Country> findAll();
    Optional<Country> getById(Integer id);
    void delete(Integer id);
}
