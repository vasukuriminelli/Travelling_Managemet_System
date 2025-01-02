package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bookings.BookTravel;
import com.example.demo.Repository.MyRepository;
import com.example.demo.Repository.SignUpRepository;
import com.example.demo.SignUp.Signup;

@Service
public class ServiceImpl implements Myservice{
	
	@Autowired
	private MyRepository repo;
	
	@Autowired
	private SignUpRepository sgRepo;
	
	

	@Override
	public BookTravel insertBooking(BookTravel bookTravel) {
		
		return repo.save(bookTravel);
	}

	@Override
	public List<BookTravel> getAllBookings() {
		
		List<BookTravel>list=repo.findAll();
		return list;
	}

	@Override
	public BookTravel updateBooking(BookTravel bookTravel) {
		
		BookTravel bookTravel1=repo.findById(bookTravel.getId()).get();
		
		System.out.println(bookTravel1);
		
		bookTravel1.setId(bookTravel.getId());
		bookTravel1.setFromDestination(bookTravel.getFromDestination());
		bookTravel1.setToDestination(bookTravel.getToDestination());
		bookTravel1.setPrice(bookTravel.getPrice());
		bookTravel1.setDate(bookTravel.getDate());
		
		repo.save(bookTravel1);
		
		return bookTravel1;
	}

	@Override
	public String deleteBooking(int id) {
		repo.deleteById(id);
		return "Deleted SucessFully";
	}

	@Override
	public Signup insertUser(Signup signUp) {
		
		return sgRepo.save(signUp);
	}


	
	
	

}
