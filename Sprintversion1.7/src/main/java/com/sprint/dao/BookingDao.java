package com.sprint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sprint.entity.Bookings;
import com.sprint.repository.BookingsRepository;

@Repository
public class BookingDao{

	@Autowired
	BookingsRepository theBookingsRepository;
	
//	Get the available seat for the movie 
	public Bookings getAvailableSeat(long showID) {
		return theBookingsRepository.getOne(showID);
	}
	
//	Book the seat
	public Bookings bookTheSeat(Bookings book) {
		return theBookingsRepository.save(book);
	}
	
// Cancel the seat
	public String cancelTheSeat(Bookings b) {
		theBookingsRepository.deleteById(b.getShow_id());
		return "Delete Successful";
	}
	
// get Booking by ID
	public Bookings findOne(Long bookingId) {
		return theBookingsRepository.getOne(bookingId);
	}
	
//	View the seat Booked
	public Bookings getAllSeat(long bookingID) {
		return theBookingsRepository.getOne(bookingID);
	}
	
// calculate cost of Booking
	public int bookingCost(long bookingId) {
		int seat = theBookingsRepository.getOne(bookingId).getTotalSeat();
		int cost = 100;
		return seat*cost;
		
	}
	
	
}
