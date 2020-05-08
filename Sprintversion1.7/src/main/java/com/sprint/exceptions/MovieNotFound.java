package com.sprint.exceptions;

public class MovieNotFound extends RuntimeException{

	public MovieNotFound(String msg) {
		super(msg);
	}
}
