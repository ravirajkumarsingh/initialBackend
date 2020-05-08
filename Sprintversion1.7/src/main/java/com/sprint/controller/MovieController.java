package com.sprint.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.Movie;
import com.sprint.model.Response;
import com.sprint.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService ;
	
	@PostMapping("/addMovie")
	public ResponseEntity<Response> createMovie(@Valid @RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(movieService.addMovie(movie), new Date()));
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable(value= "Id") long Id){
		Movie theMovie = movieService.findOne(Id);
		if(theMovie == null) {
			return ResponseEntity.notFound().build();
		}
		movieService.deleteMovie(theMovie);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/allMovies")
	public ResponseEntity<Response> getAllMovies(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(movieService.getMovie(), new Date()));
	}
	
	@PutMapping("/update/{ID}")
	public ResponseEntity<Movie> updateMovie(@PathVariable(value="ID") long ID,@Valid @RequestBody Movie m){
		Movie theMovie = movieService.findOne(ID);
		if(theMovie == null) {
			return ResponseEntity.notFound().build();
		}
		theMovie.setMovieName(m.getMovieName());
		theMovie.setMovieDirector(m.getMovieDirector());
		theMovie.setMovieDescription(m.getMovieDescription());
		theMovie.setMovieImg(m.getMovieImg());
		
		Movie updatedMovie = movieService.addMovie(theMovie);
		return ResponseEntity.ok().body(updatedMovie);
	}
	
	@GetMapping("/{ID}")
	public ResponseEntity<Movie> getOneMovie(@PathVariable(value="ID") long ID){
		Movie theMovie = movieService.findOne(ID);
		if(theMovie == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theMovie);
	}
	
//	Get Movie available on the theaters
	
	@GetMapping("/theater/{ID}/movie")
	public ResponseEntity<Response> getMovieByTheaterID(@PathVariable(value = "ID") long ID){
		return ResponseEntity.status(HttpStatus.OK)
		.body(new Response(movieService.getMovieByTheaterId(ID), new Date()));
	}
}