package com.aldojrs.filmrank.common;

import java.util.List;
import java.util.stream.Collectors;

import com.aldojrs.filmrank.dto.FilmDTO;
import com.aldojrs.filmrank.model.Film;

/**
 * Clase encargada de las conversiones de Entidades a Objetos de Transferencia de Datos y viceversa.
 * 
 * @author aldo.saia
 */
public class Converter {

	public static List<FilmDTO> filmToFilmDTOList(List<Film> films) {
		return films.stream().map(e -> filmToFilmDTO(e)).collect(Collectors.toList());
	}
	
	public static FilmDTO filmToFilmDTO(Film film) {

		FilmDTO filmDTO = new FilmDTO();

		filmDTO.setId(film.getId());
		filmDTO.setCategory(film.getCategory());
		filmDTO.setCountry(film.getCountry());
		filmDTO.setDirector(film.getDirector());
		filmDTO.setStaff(film.getStaff());
		filmDTO.setSynopsis(film.getSynopsis());
		filmDTO.setTitle(film.getTitle());
		filmDTO.setYear(film.getYear());
		
		return filmDTO;
	}

	public static Film filmDTOToFilm(FilmDTO filmDTO) {

		Film film = new Film();

		film.setId(film.getId());
		film.setCategory(filmDTO.getCategory());
		film.setCountry(filmDTO.getCountry());
		film.setDirector(filmDTO.getDirector());
		film.setStaff(filmDTO.getStaff());
		film.setSynopsis(filmDTO.getSynopsis());
		film.setTitle(filmDTO.getTitle());
		film.setYear(filmDTO.getYear());

		return film;
	}

}
