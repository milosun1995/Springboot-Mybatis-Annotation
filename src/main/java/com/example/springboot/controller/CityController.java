package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.domain.City;
import com.example.springboot.service.CityService;

/**
 * Created by xchunzhao on 02/05/2017.
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }
    
    @RequestMapping(value = "/api/city/list", method = RequestMethod.GET)
    public List<City> findCityAll() {
        return cityService.findCityAll();
    }
    
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void saveCity(@RequestBody City city) {
         cityService.saveCity(city);
    }
    
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void updateCityById(@RequestBody City city) {
         cityService.updateCityById(city);
    }
    
    @RequestMapping(value = "/api/city", method = RequestMethod.DELETE)
    public void delteCityById(@RequestParam(value = "id", required = true) Long id) {
         cityService.deleteCityById(id);
    }
}