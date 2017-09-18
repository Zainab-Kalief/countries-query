package com.wura.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wura.countries.service.WorldService;

@Controller
public class WorldController {
	private final WorldService service;
	public WorldController(WorldService service) {
		this.service = service;
	}
	@RequestMapping("/") 
	public String home(Model model) {
		List<Object[]> result1 = service.findCountryByLang("French");
		List<Object[]> result2 = service.totalCities();
		List<Object[]> result3 = service.citiesPop("Nigeria", 50000);
		List<Object[]> result4 = service.countriesWithLang(89);
		List<Object[]> result5 = service.question5(501, 100000);
		List<Object[]> result6 = service.question6();
		List<Object[]> result7 = service.question7();
		List<Object[]> result8 = service.question8();
		model.addAttribute("countries", result8);
		return "home";
	}
}
