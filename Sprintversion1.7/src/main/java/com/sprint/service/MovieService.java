package com.sprint.service;

import java.util.List;

import com.sprint.entity.Movie;

public interface MovieService {

	public Movie addMovie(Movie movie) ;
	
	public List<Movie> getMovie() ;
	
	public String deleteMovie(Movie m) ;
	
	public List<Object[]> getMovieByTheaterId(long ID) ;
	
	public Movie findOne(long Id) ;
}