package com.example.demo.serviceImp;

import com.example.demo.dto.DivisionDTO;
import com.example.demo.entity.Country;
import com.example.demo.entity.Division;

import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.DivisionRepository;
import com.example.demo.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DivisionServiceImp implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Division save(Division division) {
        Integer countryId = division.getCountry().getId();
        Country country = countryRepository.findById(countryId)
                .orElseThrow(()-> new RuntimeException("Country not found with this ID"));
        division.setCountry(country);
        return divisionRepository.save(division) ;
    }

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll() ;
    }

    @Override
    public Optional<Division> getById(Integer id) {
        return divisionRepository.findById(id) ;
    }

    @Override
    public void delete(Integer id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public List<DivisionDTO> getDivisionsByCountryId(Integer countryId) {
        List<Division> list = divisionRepository.findByCountryId(countryId);

        return  list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DivisionDTO > getDivisionsByCountryName(String countryName) {
        List<Division> list = divisionRepository.findByCountryCountryName(countryName);

        return  list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private DivisionDTO convertToDTO(Division division) {

        return new DivisionDTO(
                division.getId(),
                division.getDivisionName(),
                division.getCountry().getId(),
                division.getCountry().getCountryName()

        );
    }


}
