package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.CityDao;
import com.example.springboot.domain.City;
import com.example.springboot.service.CityService;

/**
 * 城市业务逻辑实现类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
    
	@Override
	public Long deleteCityById(Long id) {
		return cityDao.deleteCityById(id);
	}

	@Override
	public List<City> findCityAll() {
		return cityDao.findCityAll();
	}
	
	@Override
	public Long updateCityById(City city) {
		return cityDao.updateCityById(city);
	}

	@Override
	public Long saveCity(City city) {
		return cityDao.saveCity(city);
	}

}