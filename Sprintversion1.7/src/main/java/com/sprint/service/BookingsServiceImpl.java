package com.sprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.entity.Bookings;
import com.sprint.repository.BookingsRepository;

@Service
public class BookingsServiceImpl implements BookingsService{

	@Autowired
	BookingsRepository theBookingsRepository;
	
//	Get the available seat for the movie 
	@Override
	public Bookings getAvailableSeat(long showID) {
		return theBookingsRepository.getOne(showID);
	}
	
//	Book the seat
	@Override
	public Bookings bookTheSeat(Bookings book) {
		return theBookingsRepository.save(book);
	}
	
// Cancel the seat
	@Override
	public String cancelTheSeat(Bookings b) {
		theBookingsRepository.deleteById(b.getShow_id());
		return "Delete Successful";
	}
	
// get Booking by ID
	@Override
	public Bookings findOne(Long bookingId) {
		return theBookingsRepository.getOne(bookingId);
	}
	
//	View the seat Booked
	@Override
	public Bookings getAllSeat(long bookingID) {
		return theBookingsRepository.getOne(bookingID);
	}
	
// calculate cost of Booking
	@Override
	public int bookingCost(long bookingId) {
		int seat = theBookingsRepository.getOne(bookingId).getTotalSeat();
		int cost = 100;
		return seat*cost;
		
	}
	
	
}
