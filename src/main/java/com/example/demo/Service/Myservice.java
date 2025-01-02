package com.example.demo.Service;

import java.util.List;

import com.example.demo.Bookings.BookTravel;
import com.example.demo.SignUp.Signup;

public interface Myservice {
	
	public BookTravel insertBooking(BookTravel bookTravel);
	
	public List<BookTravel>getAllBookings();
	
	public BookTravel updateBooking(BookTravel bookTravel);
	
	public String deleteBooking(int id);
	
	public Signup insertUser(Signup signUp);
	
	

}
