package com.example.demo.controller;

import com.example.demo.dto.DivisionDTO;
import com.example.demo.entity.Division;
import com.example.demo.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/division/")
public class DivisionController {

   @Autowired
    private DivisionService divisionService;

    @PostMapping
    public ResponseEntity<Division> save(@RequestBody Division division){
        Division savedDivision = divisionService.save(division);
        return  ResponseEntity.ok(savedDivision);

    }
    @GetMapping
    public  ResponseEntity<List<Division>> getAll(){
        List<Division> list = divisionService.findAll();
        return  ResponseEntity.ok(list);
    }

    @GetMapping("country/{id}")
    public List<DivisionDTO> getByCountryId(@PathVariable Integer id) {
        return divisionService.getDivisionsByCountryId(id);
    }

    @GetMapping("country/name/{name}")
    public List<DivisionDTO> getByCountryName(@PathVariable String name) {
        return divisionService.getDivisionsByCountryName(name);
    }
}
