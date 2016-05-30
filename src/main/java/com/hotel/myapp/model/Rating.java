package com.hotel.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rateID;
	private String username;
	private String hotelIDajax;
	private int rating;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Hotel hotel;
	
	public Integer getRateID() {
		return rateID;
	}
	public void setRateID(Integer rateID) {
		this.rateID = rateID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getHotelIDajax() {
		return hotelIDajax;
	}
	public void setHotelIDajax(String hotelIDajax) {
		this.hotelIDajax = hotelIDajax;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Rating() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
