package com.example.demo.controller;
import com.example.demo.dto.DistrictDTO;
import com.example.demo.entity.District;
import com.example.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/district/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;


    @PostMapping
    public ResponseEntity<District> save(@RequestBody District district) {
        District savedDistrict = districtService.save(district);
        return ResponseEntity.ok(savedDistrict);

    }


    @GetMapping
    public ResponseEntity<List<District>> getAll() {
        List<District> list = districtService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<District> findById(@PathVariable("id") Integer id) {
        District district = districtService.getById(id)
                .orElseThrow(() -> new RuntimeException("District Not Found with this ID"));
        return ResponseEntity.ok(district);
    }

    @PutMapping("{id}")
    public ResponseEntity<District> update(
            @PathVariable Integer id,
            @RequestBody District district) {
        district.setId(id);
        District updatedDistrict = districtService.save(district);
        return ResponseEntity.ok(updatedDistrict);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        districtService.delete(id);
        return ResponseEntity.ok("District Deleted Successfully");
    }

    @GetMapping("division/{id}")
    public List<DistrictDTO> getByDivisionId(@PathVariable Integer id) {
        return districtService.getDistrictByDivisionId(id);
    }


    @GetMapping("division/name/{name}")
    public List<DistrictDTO> getByCountryName(@PathVariable String name) {
        return districtService.getDistrictByDivisionName(name);
    }
}
