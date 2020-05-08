package com.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(value = "select movieId, movieName, movieDescription from movie, show as s  where s.theater_theaterId = ?1", nativeQuery = true)
	public List<Object[]> getMovieByTheateID(long ID);
}