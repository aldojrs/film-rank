package com.aldojrs.filmrank.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.aldojrs.filmrank.dto.FilmDTO;

/**
 * Servicios relacionados a las películas.
 * 
 * @author aldo.saia
 */
public interface FilmService {

	/**
	 * Obtiene todas las películas según los filtros especificados.
	 * 
	 * @return Lista de películas.
	 */
	List<FilmDTO> get(String title, Integer year, String country, String director, Pageable pageable);

	/**
	 * Obtiene una película según el identificador especificado.
	 * 
	 * @return Película.
	 */
	FilmDTO get(Long id);
	
}
