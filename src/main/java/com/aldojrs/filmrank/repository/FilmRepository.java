package com.aldojrs.filmrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aldojrs.filmrank.model.Film;

/**
 * Repository para administrar el acceso a datos de una película.
 * 
 * @author aldo.saia
 */
@Transactional
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
	
}
