package com.sprint.service;

import java.util.List;

import com.sprint.entity.Movie;
import com.sprint.entity.Show;

public interface ShowService {
	

	public Show addShow(Show show) ;
	
	public List<Show> getShow() ;
	
	public String deleteShow(Show s) ;
	
	public Movie findOne(long Id) ;
	
	public Show fetchById(long Id);
		
	public List<Show> fetchByMovie(Movie m) ;
	
}