package com.aldojrs.filmrank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aldojrs.filmrank.common.Converter;
import com.aldojrs.filmrank.dto.FilmDTO;
import com.aldojrs.filmrank.repository.CustomFilmRepository;
import com.aldojrs.filmrank.repository.FilmRepository;
import com.aldojrs.filmrank.service.FilmService;

/**
 * Implementación de los servicios relacionados a las películas.
 * 
 * @author aldo.saia
 */
@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	CustomFilmRepository customFilmRepository;

	@Override
	public List<FilmDTO> get(String title, Integer year, String country, String director, Pageable pageable) {
		return Converter.filmToFilmDTOList(customFilmRepository.find(title, year, country, director, pageable));
	}

	@Override
	public FilmDTO get(Long id) {
		return Converter.filmToFilmDTO(filmRepository.getOne(id));
	}

}
