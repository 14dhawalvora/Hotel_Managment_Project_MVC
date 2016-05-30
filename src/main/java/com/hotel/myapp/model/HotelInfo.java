package com.hotel.myapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HotelInfo {
	
	@Id
	private String hotelID;
	private String name;
	private String address;
	private String city,stateProvinceCode,postalCode,countryCode;
	private String hotelRating, shortDesc, highrate, lowRate, currency, thumbnailURL;
	private String arrivalDate,departureDate;
	private String checkinTime,checkoutTime;
	private String roomDetailDesc;
	private String propertyDesc;
	private ArrayList<String> imagesURL;
	
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public ArrayList<String> getImagesURL() {
		return imagesURL;
	}
	public void setImagesURL(ArrayList<String> imagesURL) {
		this.imagesURL = imagesURL;
	}

}
