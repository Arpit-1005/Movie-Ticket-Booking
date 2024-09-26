package com.bms.city.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

import com.bms.city.Model.City;
import com.bms.city.Service.CityService;

@RestController
@RequestMapping("/City")
public class CityController {

    // @Autowired
    // private RestTemplate restTemplate;
    
    @Autowired
    private CityService cityService;
    
    @PostMapping
    public String addCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @GetMapping
    public List<City> getAllCity() {
        return cityService.readCities();
    }

    // @GetMapping("/{cityId}")
    // public City getCityById(@PathVariable Long cityId) {
    //     return cityService.readCity(cityId);
    // }

    @DeleteMapping("/{cityId}")
    public String deleteCity(@PathVariable Long cityId) {
        if(cityService.deleteCity(cityId)) {
            return "City deleted successfully";
        }
        return "City not found";
    }

    @PutMapping("/{cityId}")
    public String updateCity(@PathVariable Long cityId, @RequestBody City city) {
        return cityService.updateCity(cityId, city);
    }
    
    @GetMapping("/{cityName}")
    public City getCityByName(@PathVariable String cityName) {
        return cityService.readCityByName(cityName);
    }
}
