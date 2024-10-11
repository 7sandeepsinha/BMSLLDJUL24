package dev.sandeep.BMSJUL24.controller;

import dev.sandeep.BMSJUL24.model.City;
import dev.sandeep.BMSJUL24.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<City> createCity(@RequestBody City city){
        City savedCity = cityService.createCity(city);
        return ResponseEntity.ok(savedCity);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") int id){
        City city = cityService.getCityById(id);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/city")
    public ResponseEntity<List<City>> getAllCities(){
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") int id){
        cityService.deleteCityById(id);
        return ResponseEntity.ok("Deleted City");
    }

}
