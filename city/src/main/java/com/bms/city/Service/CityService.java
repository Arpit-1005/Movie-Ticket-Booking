package com.bms.city.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bms.city.Model.City;

@Service
public interface CityService {
    String createCity(City city);
    List<City> readCities();
    // City readCity(Long cityId);
    String updateCity(Long cityId, City city);
    boolean deleteCity(Long cityId);
    City readCityByName(String name);
}
