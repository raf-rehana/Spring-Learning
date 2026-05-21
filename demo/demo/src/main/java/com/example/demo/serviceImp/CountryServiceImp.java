package com.example.demo.serviceImp;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImp implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
    return countryRepository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll() ;
    }

    @Override
    public Optional<Country> getById(Integer id) {
        return countryRepository.findById(id) ;
    }

    @Override
    public void delete(Integer id) {
    countryRepository.deleteById(id);
    }
}
