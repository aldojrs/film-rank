package com.aldojrs.filmrank.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.aldojrs.filmrank.model.Film;

/**
 * Repository para administrar el acceso a datos de una película.
 * 
 * @author aldo.saia
 */
@Repository
public interface CustomFilmRepository {

	List<Film> find(String title, Integer year, String country, String director, Pageable pageable);
	
}
