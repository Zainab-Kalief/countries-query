package com.wura.countries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wura.countries.models.Country;

@Repository
public interface WorldRepo extends CrudRepository<Country, Long> {
	
	@Query("SELECT c FROM Country c WHERE continent = ?1")
	List<Country> getCountriesByContinent(String continent);
	
	@Query("SELECT c FROM Country c WHERE id in:ids")
	List<Country> getCountriesById(@Param("ids") List<Long> allIds);
	
	@Query(value="SELECT countries.name, COUNT(cities.id) AS numberOfCities"
			+ " FROM countries JOIN cities ON countries.id=cities.country_id "
			+ "GROUP BY countries.name ORDER BY numberOfCities", nativeQuery=true)
	List<Object[]> totalCities();
	
	@Query(value="SELECT cities.name, cities.population FROM countries JOIN "
			+ "cities ON countries.id=cities.country_id WHERE countries.name = ?1 AND "
			+ "cities.population > ?2 ORDER BY cities.population DESC", nativeQuery=true)
	List<Object[]> citiesPopulation(String name, Integer val);
	
	@Query(value="SELECT GROUP_CONCAT('', countries.name), languages.language FROM countries "
			+ "JOIN languages ON countries.id=languages.country_id WHERE languages.percentage > ?1 "
			+ "GROUP BY languages.language ORDER BY percentage DESC", nativeQuery=true)
	List<Object[]> countriesWithLang(Integer val);
	
	@Query(value="SELECT countries.name, countries.surface_area, countries.population FROM countries " + 
			"WHERE surface_area < ?1 AND countries.population > ?2", nativeQuery=true)
	List<Object[]> question5(Integer val, Integer val2);
	
	@Query(value="SELECT countries.name, countries.government_form, countries.life_expectancy, countries.capital " + 
			"FROM countries WHERE countries.government_form = 'Constitutional Monarchy' AND countries.capital "
			+ "> 200 AND countries.life_expectancy > 75", nativeQuery=true)
	List<Object[]> question6();
	
	@Query(value="SELECT countries.name AS country_name, cities.name AS city_name, cities.district, cities.population AS city_population " + 
			"FROM countries JOIN cities ON countries.id = cities.country_id WHERE countries.name = "
			+ "'Argentina' AND cities.district = 'Buenos Aires' AND cities.population > 500000", nativeQuery=true)
	List<Object[]> question7();
	
	@Query(value="SELECT countries.region, COUNT(countries.id) AS no_of_countries, GROUP_CONCAT(' ', countries.name) AS countries" + 
			" FROM countries GROUP BY countries.region ORDER BY no_of_countries DESC", nativeQuery=true)
	List<Object[]> question8();
}
