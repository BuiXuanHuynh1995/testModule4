package com.example.demo.service;

import com.example.demo.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> findAll();
     Optional<City> findById(Long id);
     void save(City city);
     void delete(Long id);
}
