 package com.hotel.myapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Hotel implements Serializable{
	
	@Id
	private Integer hotelId;
	private String hotelName;
	private String address;
	private String city,stateProvinceCode,postalCode,countryCode;
	private String hotelRating, shortDesc, highrate, lowRate, currency, thumbnailURL;
	private String arrivalDate,departureDate;
	private String checkinTime,checkoutTime;
	private String roomDetailDesc;
	private String propertyDesc;
	
	@OneToMany(mappedBy = "hotel")
	private Collection<Booking> bookingList=new ArrayList<Booking>();

	@OneToMany(mappedBy = "hotel")
	private Collection<Rating> ratingList=new ArrayList<Rating>();

	@OneToMany(mappedBy = "hotel")
	private Collection<Review> reviewList=new ArrayList<Review>();

	@OneToMany(mappedBy="hotel")
	private Collection<Likes> likesList=new ArrayList<Likes>();
	
	/*
	public Hotel(String hotelTableID, String name, String location) {
		this.hotelTableID = hotelTableID;
		this.name = name;
		this.location = location;
	}
*/
	public Hotel() {
		super();
	}


	public Integer getHotelId() {
		return hotelId;
	}


	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Collection<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Collection<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	public Collection<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(Collection<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	public Collection<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(Collection<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public Collection<Likes> getLikesList() {
		return likesList;
	}

	public void setLikesList(Collection<Likes> likesList) {
		this.likesList = likesList;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStateProvinceCode() {
		return stateProvinceCode;
	}


	public void setStateProvinceCode(String stateProvinceCode) {
		this.stateProvinceCode = stateProvinceCode;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getHotelRating() {
		return hotelRating;
	}


	public void setHotelRating(String hotelRating) {
		this.hotelRating = hotelRating;
	}


	public String getShortDesc() {
		return shortDesc;
	}


	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}


	public String getHighrate() {
		return highrate;
	}


	public void setHighrate(String highrate) {
		this.highrate = highrate;
	}


	public String getLowRate() {
		return lowRate;
	}


	public void setLowRate(String lowRate) {
		this.lowRate = lowRate;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getThumbnailURL() {
		return thumbnailURL;
	}


	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
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


	public String getCheckinTime() {
		return checkinTime;
	}


	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}


	public String getCheckoutTime() {
		return checkoutTime;
	}


	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}


	public String getRoomDetailDesc() {
		return roomDetailDesc;
	}


	public void setRoomDetailDesc(String roomDetailDesc) {
		this.roomDetailDesc = roomDetailDesc;
	}


	public String getPropertyDesc() {
		return propertyDesc;
	}


	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}
	
}
