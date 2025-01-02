package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bookings.BookTravel;
import com.example.demo.Service.Myservice;
import com.example.demo.SignUp.Signup;

@CrossOrigin
@RestController
public class MyController {
	
	@Autowired
	private Myservice service;
	
	
	
	@GetMapping("/getdetails")
	public List<BookTravel>getAllBooking(){
		return service.getAllBookings();
	}
	
	@PostMapping("/insertbooking")
	public BookTravel insertBooking(@RequestBody BookTravel bookTravel) {
		
		return service.insertBooking(bookTravel);
	}

	@PutMapping("/updatedetails")
	public BookTravel updateBooking(@RequestBody BookTravel bookTravel) {
		return service.updateBooking(bookTravel);
	}
	
	@DeleteMapping("/deletebooking/{id}")
	public String deleteBooking(@PathVariable int id) {
		return service.deleteBooking(id);
	}
	
	
	 @PostMapping("/signup")
	public Signup insertUser(@RequestBody Signup signup) {
		return service.insertUser(signup);
	}
	 

	
}
