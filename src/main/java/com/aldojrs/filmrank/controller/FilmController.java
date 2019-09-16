package com.aldojrs.filmrank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aldojrs.filmrank.dto.FilmDTO;
import com.aldojrs.filmrank.service.FilmService;

/**
 * Controller para endpoints relacionados a las películas.
 * 
 * @author aldo.saia
 */
@RestController
@RequestMapping("films")
public class FilmController {

	@Autowired
	FilmService filmService;

	@GetMapping
	public ResponseEntity<List<FilmDTO>> get(@RequestParam(required = false) String title,
			@RequestParam(required = false) Integer year, @RequestParam(required = false) String country,
			@RequestParam(required = false) String director, @PageableDefault(value = 5, page = 0) Pageable pageable) {

		ResponseEntity<List<FilmDTO>> response;

		try {
			response = new ResponseEntity<List<FilmDTO>>(filmService.get(title, year, country, director, pageable), HttpStatus.FOUND);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

		return response;
	}

	@GetMapping("/{id}/detail")
	public ResponseEntity<FilmDTO> get(@PathVariable Long id) {

		ResponseEntity<FilmDTO> response;

		try {
			response = new ResponseEntity<FilmDTO>(filmService.get(id), HttpStatus.FOUND);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

		return response;
	}	
	
}
