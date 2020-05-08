package com.sprint.exceptions;

public class MovieAlreadyPresent extends RuntimeException {

	public MovieAlreadyPresent(String msg) {
		super(msg);
	}
}
