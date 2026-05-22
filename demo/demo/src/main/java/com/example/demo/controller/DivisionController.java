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
    public ResponseEntity<Division> save(@RequestBody Division division) {
        Division savedDivision = divisionService.save(division);
        return ResponseEntity.ok(savedDivision);

    }


    @GetMapping
    public ResponseEntity<List<Division>> getAll() {
        List<Division> list = divisionService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<Division> findById(@PathVariable("id") Integer id) {
        Division division = divisionService.getById(id)
                .orElseThrow(() -> new RuntimeException("Division Not Found with this ID"));
        return ResponseEntity.ok(division);
    }

    @PutMapping("{id}")
    public ResponseEntity<Division> update(
            @PathVariable Integer id,
            @RequestBody Division division) {
            division.setId(id);
    Division updatedDivision = divisionService.save(division);
    return ResponseEntity.ok(updatedDivision);
}

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        divisionService.delete(id);
        return ResponseEntity.ok("Division Deleted Successfully");
    }

    @GetMapping("country{id}")
    public List<DivisionDTO> getByCountryId(@PathVariable Integer id) {
        return divisionService.getDivisionsByCountryId(id);
    }


    @GetMapping("country/name/{name}")
    public List<DivisionDTO> getByCountryName(@PathVariable String name) {
        return divisionService.getDivisionsByCountryName(name);
    }

}
