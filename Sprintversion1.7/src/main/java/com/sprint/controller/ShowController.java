package com.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.Bookings;
import com.sprint.entity.Movie;
import com.sprint.entity.Show;
import com.sprint.service.ShowService;

@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	ShowService showService ;
	
//	Get Available Show for a particular movie 
	
	@GetMapping("/movie/{id}/show")
	public List<Show> geShowByMovieId(@PathVariable(value ="id") long id){
		
		Movie theMovie = showService.findOne(id);
	
		return showService.fetchByMovie(theMovie);
	}
}