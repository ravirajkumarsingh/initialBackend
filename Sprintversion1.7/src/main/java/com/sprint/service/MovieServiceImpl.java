package com.sprint.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.MovieDao;
import com.sprint.entity.Movie;
import com.sprint.exceptions.MovieNotFound;


@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDao movieDao ;
	
	@Override
	public Movie addMovie(Movie movie) {
		return movieDao.save(movie) ;
	}

	@Override
	public List<Movie> getMovie() {
		return movieDao.getMovie() ;
	}

	@Override
	public String deleteMovie(Movie movie) {
		Optional<Movie> m = movieDao.findById(movie.getMovieId()) ;
		if(!m.isPresent()) {
			throw new MovieNotFound("Movie Not Found!") ;
		}
		return movieDao.deleteMovie(movie) ;
	}

	@Override
	public List<Object[]> getMovieByTheaterId(long Id) {
		Optional<Movie> m = movieDao.findById(Id) ;
		if(!m.isPresent()) {
			throw new MovieNotFound("Movie Not Found!") ;
		}
		return movieDao.getMovieByTheaterId(Id) ;
	}
	
	@Override
	public Movie findOne(long Id){
		return movieDao.findOne(Id) ;
	}

}