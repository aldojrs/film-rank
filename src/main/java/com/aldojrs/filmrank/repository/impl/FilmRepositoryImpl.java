package com.aldojrs.filmrank.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;

import com.aldojrs.filmrank.model.Film;
import com.aldojrs.filmrank.repository.CustomFilmRepository;

/**
 * Implementación custom del acceso a datos para las películas.
 * 
 * @author aldo.saia
 */
public class FilmRepositoryImpl implements CustomFilmRepository {

	@Autowired
	private EntityManager em;

	@Override
	public List<Film> find(String title, Integer year, String country, String director, Pageable pageable) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Film> cq = cb.createQuery(Film.class);
		Root<Film> film = cq.from(Film.class);

		cq.multiselect(film.get("id"), film.get("title"), film.get("year"), film.get("country"), film.get("director"));
		List<Predicate> predicates = new ArrayList<>();

		if (title != null) {
			predicates.add(cb.equal(film.get("title"), title));
		}

		if (year != null) {
			predicates.add(cb.equal(film.get("year"), year));
		}

		if (country != null) {
			predicates.add(cb.equal(film.get("country"), country));
		}

		if (director != null) {
			predicates.add(cb.equal(film.get("director"), director));
		}

		if (!predicates.isEmpty()) {
			cq.where(predicates.toArray(new Predicate[0]));
		}

		TypedQuery<Film> query = em.createQuery(cq);

		query.setFirstResult(Long.valueOf(pageable.getOffset()).intValue());
		query.setMaxResults(pageable.getPageSize());

		List<Film> films = query.getResultList();
		Page<Film> result = PageableExecutionUtils.getPage(films, pageable, () -> getCountForQuery(Film.class));

		return result.getContent();
	}

	private Long getCountForQuery(Class<?> t) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		countQuery.select(criteriaBuilder.count(countQuery.from(t)));
		Long count = em.createQuery(countQuery).getSingleResult();

		return count;
	}

}
