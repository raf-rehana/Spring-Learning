package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country/")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<Country> save(@RequestBody Country country) {
        Country savedCountry = countryService.save(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAll() {
        List<Country> list = countryService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Country> findById(@PathVariable("id") Integer id) {
        Country country = countryService.getById(id)
                .orElseThrow(() -> new RuntimeException("Country Not Found with this ID"));

        return ResponseEntity.ok(country);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        countryService.delete(id);

        return ResponseEntity.ok("Country Deleted Successfully");
    }

    @PutMapping("{id}")
    public  ResponseEntity<Country> update(
            @PathVariable Integer id,
            @RequestBody Country country
    ){

        country.setId(id);
        Country updatedCountry = countryService.save(country);

        return  ResponseEntity.ok(updatedCountry);

    }
}
