package com.example.demo.repository;

import com.example.demo.entity.District;
import com.example.demo.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

    List<District> findByDivisionId(Integer divisionId);

    List<District> findByDivisionDivisionName(String divisionName);
}
