package com.example.demo.repository;

import com.example.demo.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {

    List<Division> findByCountryId(Integer countryId);
    List<Division> findByCountryCountryName(String countryName);
}
