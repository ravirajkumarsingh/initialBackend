package com.sprint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.Bookings;
import com.sprint.service.BookingsServiceImpl;

@RestController
@RequestMapping("/user")
public class BookingController {
	
	@Autowired
	BookingsServiceImpl bookingsService;
	
//	Get the seat available for a particular Show using the show ID
	
	@GetMapping("/show/{id}")
	public Bookings getAvailableSeat(@PathVariable ( value = "id") long id)
	{
		return bookingsService.getAvailableSeat(id);
	}

//	Book a Seat using the show id By passing the show POJO to the API 
	
	@PostMapping("show/{id}/bookings")
	public Bookings bookSeatForShow(@PathVariable (value = "id") long id, @Valid @RequestBody Bookings b)
	{
		
		return bookingsService.bookTheSeat(b);
	}
	
// Cancel the seat for the given booking ID
	@DeleteMapping("show/cancelBookings/{bookingId}")
	public  ResponseEntity<String> cancelSeatForShow(@PathVariable (value = "bookingId") long bookingId)
	{
		
		Bookings theBooking = bookingsService.findOne(bookingId);
		if(theBooking == null) {
			return ResponseEntity.notFound().build();
		}
		bookingsService.cancelTheSeat(theBooking);
		return ResponseEntity.ok().build();
	}
	
// View Booking for the given show ID
	@GetMapping("/show/{id}/AllBookings")
	public Bookings getAllSeat(@PathVariable ( value = "id") long id)
	{
		
		return bookingsService.getAllSeat(id);
	}

// Calculate Cost of the Booking 
	@GetMapping("/show/{id}/BookingCost")
	public int bookingCost(@PathVariable (value = "id") long id)
	{
		return bookingsService.bookingCost(id);
	}
	
}
