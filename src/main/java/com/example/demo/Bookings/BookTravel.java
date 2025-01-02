package com.example.demo.Bookings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookTravel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String FromDestination;
	private String ToDestination;
	private String Price;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromDestination() {
		return FromDestination;
	}
	public void setFromDestination(String fromDestination) {
		FromDestination = fromDestination;
	}
	public String getToDestination() {
		return ToDestination;
	}
	public void setToDestination(String toDestination) {
		ToDestination = toDestination;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BookTravel [id=" + id + ", FromDestination=" + FromDestination + ", ToDestination=" + ToDestination
				+ ", Price=" + Price + ", date=" + date + "]";
	}
	
	
	
}
