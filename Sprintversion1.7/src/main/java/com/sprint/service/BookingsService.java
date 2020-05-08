package com.sprint.service;

import com.sprint.entity.Bookings;

public interface BookingsService {

	public Bookings getAvailableSeat(long showID);
	
	public Bookings bookTheSeat(Bookings book);
	
	public String cancelTheSeat(Bookings b);
	
	public Bookings findOne(Long bookingId);
	
	public Bookings getAllSeat(long bookingID);
	
	public int bookingCost(long bookingId);

}
