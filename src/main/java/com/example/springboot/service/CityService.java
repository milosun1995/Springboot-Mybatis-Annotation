package com.example.springboot.service;

import java.util.List;

import com.example.springboot.domain.City;

/**
 * 城市业务逻辑接口类
 *
 * Created by xchunzhao on 02/05/2017.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
    
    List<City> findCityAll();
    
    Long saveCity(City city);
    
    Long updateCityById(City city);
    
    Long deleteCityById(Long id);
}
