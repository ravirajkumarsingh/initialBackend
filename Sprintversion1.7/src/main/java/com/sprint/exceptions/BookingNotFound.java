package com.sprint.exceptions;

public class BookingNotFound extends RuntimeException{

	public BookingNotFound(String msg) {
		super(msg);
	}
}
