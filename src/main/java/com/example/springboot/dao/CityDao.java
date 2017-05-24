package com.example.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.example.springboot.domain.City;

/**
 * 城市 DAO 接口类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Mapper // 标志为 Mybatis 的 Mapper
public interface CityDao {
	
    /**
     * 查询全部城市信息
     *
     */
	@Select("SELECT * FROM city")
	@Results(id="cityResultId",value={
			@Result(property = "id", column = "id"),
			@Result(property = "provinceId", column = "province_id"),
			@Result(property = "cityName", column = "city_name"),
			@Result(property = "description", column = "description"),
	})
	List<City> findCityAll();

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    @Select("SELECT * FROM city where city_name=#{cityName}")
    @ResultMap("cityResultId")
    City findByName(@Param("cityName") String cityName);
    
    /**
     * 新增城市信息
     * @param city
     * @return
     */
    @Insert("INSERT INTO city(province_id,city_name,description) value(#{city.provinceId},#{city.cityName},#{city.description})")
    @Options(useGeneratedKeys=true,keyProperty="city.id")
    Long saveCity(@Param("city") City city);
 
    /**
     * 根据城市id，删除城市信息
     *
     * @param id 城市名
     */
    @ResultMap("cityResultId")
    @Delete("DELETE FROM city where id=#{id}")
    Long deleteCityById(@Param("id") Long id);
    
    
    /**
     * 根据城市id，修改城市信息
     * 
     * @param id
     * @return
     */
    @Update("UPDATE city SET province_id=#{city.provinceId},city_name=#{city.cityName},description=#{city.description} where id=#{city.id}")
    Long updateCityById(@Param("city") City city);
}