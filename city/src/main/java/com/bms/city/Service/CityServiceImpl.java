package com.bms.city.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

import com.bms.city.Entity.CityEntity;
import com.bms.city.Model.City;
import com.bms.city.Model.Movie;
import com.bms.city.Repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String createCity(City city) {
        CityEntity cityEntity = new CityEntity();
        BeanUtils.copyProperties(city, cityEntity);
        cityRepository.save(cityEntity);
       return "City added successfully";
    }

    @Override
    public List<City> readCities() {
        List<CityEntity> citiesList = cityRepository.findAll();
        List<City> cities = new ArrayList<>();
        for (CityEntity cityEntity : citiesList) {
            City city = new City();
            BeanUtils.copyProperties(cityEntity, city);
            cities.add(city);
        }
        return cities;
    }

    // @Override
    // public City readCity(Long cityId) {
    //     CityEntity cityEntity = cityRepository.findById(cityId).get();
    //     City city = new City();
    //     BeanUtils.copyProperties(cityEntity, city);
    //     return city;   
    // }

    @Override
    public String updateCity(Long cityId, City city) {
        CityEntity extistingCity = cityRepository.findById(cityId).get();
        extistingCity.setName(city.getName());
        cityRepository.save(extistingCity);
        return "City updated successfully";
    }

    @Override
    public boolean deleteCity(Long cityId) {
       CityEntity city = cityRepository.findById(cityId).get();
         cityRepository.delete(city);
         return true;
    }

    @Override
    public City readCityByName(String name) {
        CityEntity cityEntity = cityRepository.findByName(name);
        City city = new City();
        BeanUtils.copyProperties(cityEntity, city);

        String movieServiceUrl = "http://localhost:8082/Movie/city/" + city.getName();
        Movie[] movies = restTemplate.getForObject(movieServiceUrl, Movie[].class);
        city.setMovies(Arrays.asList(movies));
        return city;
    }

}