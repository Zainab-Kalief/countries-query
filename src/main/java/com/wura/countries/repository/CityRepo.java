package com.wura.countries.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wura.countries.models.City;


@Repository
public interface CityRepo extends CrudRepository<City, Long> {

}
