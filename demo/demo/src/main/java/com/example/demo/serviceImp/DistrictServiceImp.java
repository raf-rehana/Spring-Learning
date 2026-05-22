package com.example.demo.serviceImp;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.entity.District;
import com.example.demo.entity.Division;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.DivisionRepository;
import com.example.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImp implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public District save(District district) {
        Integer divisionId = district.getDivision().getId();
        Division division = divisionRepository.findById(divisionId)
                .orElseThrow(() -> new RuntimeException("Division not found with this ID"));
        district.setDivision(division);
        return districtRepository.save(district);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> getById(Integer id) {
        return districtRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        districtRepository.deleteById(id);
    }

    @Override
    public List<DistrictDTO> getDistrictByDivisionId(Integer divisionId) {
        List<District> list = districtRepository.findByDivisionId(divisionId);
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DistrictDTO> getDistrictByDivisionName(String divisionName) {
        List<District> list = districtRepository.findByDivisionName(divisionName);
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private DistrictDTO convertToDTO(District district) {
        return new DistrictDTO(
                district.getId(),
                district.getName(),
                district.getDivision().getId(),
                district.getDivision().getName(),
                district.getDivision().getCountry().getId(),
                district.getDivision().getCountry().getName()

        );
    }
}