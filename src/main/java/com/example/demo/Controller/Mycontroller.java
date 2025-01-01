package com.example.demo.Controller;

import java.sql.SQLException;
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
import com.example.demo.Registrations.User;
import com.example.demo.Repository.MyRepo;
import com.example.demo.SIGNUP.Signup;


@CrossOrigin("http://localhost:4200")
@RestController
public class Mycontroller {
	
	@Autowired
	MyRepo repo;
	

	@PostMapping("/insertbooking")
	public BookTravel insertBooking(@RequestBody BookTravel bookTravel) throws ClassNotFoundException, SQLException
	{
		return repo.insertBooking(bookTravel);
	}
	
	@GetMapping("/getdetails")
	public List<BookTravel> getAllBookings() throws ClassNotFoundException, SQLException
	{
		return repo.getAllBookings();
	}
	
	@PutMapping("/updatedetails")
	public String updateBooking(@RequestBody BookTravel bookTravel) throws ClassNotFoundException, SQLException
	{
		return repo.updateBooking(bookTravel);
	}
	
	@DeleteMapping("/deletebooking/{id}")
	public String deleteBooking(@PathVariable int id) throws ClassNotFoundException, SQLException
	{
		return repo.deleteBooking(id);
	}
	
	
	
	
	 //Signup
	 @PostMapping("/signup")
	 public Signup insertUser(@RequestBody Signup signup) throws ClassNotFoundException, SQLException {
	  
	  return repo.insertUser(signup);
	 }
	
	 @GetMapping("/check/{email}/{password}")
	 public String checkUser(@PathVariable String email,@PathVariable String password) throws ClassNotFoundException, SQLException
	 {
	  
	  return repo.checkUser(email, password);
	 }
	 
	
//CURRRENTLY WE ELIMINATED THESE CLASS.
//		@PostMapping("/insert")
//		public User insert(@RequestBody User user) throws ClassNotFoundException, SQLException
//		{
//			return repo.insert(user);
//		}
	
}
