package com.wura.countries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wura.countries.models.Country;
import com.wura.countries.models.Language;
import com.wura.countries.repository.LanguageRepo;
import com.wura.countries.repository.WorldRepo;

@Service
public class WorldService {
	private WorldRepo worldRepo;
	private LanguageRepo langRepo;
	
	public WorldService(WorldRepo worldRepo, LanguageRepo langRepo) {
		this.worldRepo = worldRepo;
		this.langRepo = langRepo;
	}
	
	public List<Country> all() {
		
		return (List<Country>) worldRepo.findAll();
	}
	
	public List<Country> findCountryByCont(String continent) {
		return worldRepo.getCountriesByContinent(continent);
	}
	
	public List<Object[]> findCountryByLang(String name) {
		return langRepo.joinCountryAndLang(name);
	}
	public List<Object[]> totalCities() {
		return worldRepo.totalCities();
	}
	public List<Object[]> citiesPop(String name, Integer val) {
		return worldRepo.citiesPopulation(name, val);
	}
	public List<Object[]> countriesWithLang(Integer val) {
		return worldRepo.countriesWithLang(val);
	}
	public List<Object[]> question5(Integer val, Integer val2) {
		return worldRepo.question5(val, val2);
	}
	public List<Object[]> question6() {
		return worldRepo.question6();
	}
	public List<Object[]> question7() {
		return worldRepo.question7();
	}
	public List<Object[]> question8() {
		return worldRepo.question8();
	}
}
