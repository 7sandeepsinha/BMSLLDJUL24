package dev.sandeep.BMSJUL24.service;

import dev.sandeep.BMSJUL24.exception.CityNotFoundException;
import dev.sandeep.BMSJUL24.model.City;
import dev.sandeep.BMSJUL24.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City getCityById(int id) {
        return cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City with id " + id + " not found")
        );
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public void deleteCityById(int id) {
        cityRepository.deleteById(id);
    }
}

/*
    IoC container -> Inversion of Control Container
    maintains object all the dependencies and injects them wherever
    needed
    1. Create object of all dependencies -> Singleton[default]
        a. Mark the classes which could be dependencies ->
            @Repository, @Service, @Controller, @RestController, @Component

            @Repository -> @Component + readability that the class is a repo
            @Service -> @Component + readability that class is a service
            @Component -> marks the class as a possible dependency for another classes.

            @Controller -> creates the object and injects in IoC container and connects with TomCat.
            @RestController -> creates the object and injects in IoC container and connects with TomCat + support for RestAPIs [json]

    2. Inject these dependency objects wherever needed
        b. Mark the dependencies inside the class -> @Autowired





 */