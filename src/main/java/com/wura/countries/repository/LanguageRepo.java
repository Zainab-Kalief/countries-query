package com.wura.countries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wura.countries.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {
	
	@Query("SELECT l.country_id FROM Language l WHERE language = ?1")
	List<Long> getCountryIdByLang(String name);
	
	@Query(value="SELECT languages.language, countries.name, languages.percentage "
			+ "FROM languages LEFT JOIN countries ON country_id = countries.id "
			+ "WHERE language = ?1 ORDER BY percentage DESC", nativeQuery=true)
	List<Object[]> joinCountryAndLang( String name);
	
}
