package com.hotel.myapp.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Cacheable(false)
public class Booking implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingID;
	
	private String hotelID;
	private String username;
	private String firstname;
	private String lastname;
	private String roomType;
	private String price;
	private String arrivalDate;
	private String departureDate;
	private String specialrequest;
	private Integer telephone;
	private String Purpose;
	private String emailConf;
	private Integer active = 1;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "", nullable = false)
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Hotel hotel;
	
	@OneToOne
	private Transaction transaction;

	public Booking() {
		super();

	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getEmailConf() {
		return emailConf;
	}

	public void setEmailConf(String emailConf) {
		this.emailConf = emailConf;
	}

	public String getPurpose() {
		return Purpose;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public Integer getBookingID() {
		return bookingID;
	}

	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getSpecialrequest() {
		return specialrequest;
	}

	public void setSpecialrequest(String specialrequest) {
		this.specialrequest = specialrequest;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	public User getUser() {
		return user;
	}


	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", hotelID=" + hotelID
				+ ", username=" + username + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", roomType=" + roomType
				+ ", price=" + price + ", arrivalDate=" + arrivalDate
				+ ", departureDate=" + departureDate + ", specialrequest="
				+ specialrequest + "]";
	}

	public void setUser(User user2) {
		this.user=user2;
		
	}
}
