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
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String dob;
	private String roletype;
	private String email;

	//@OneToMany
	//private Collection<Booking> bookingList=new ArrayList<Booking>();
	@OneToMany(mappedBy = "user")
	private Collection<Booking> bookingList=new ArrayList<Booking>();

	@OneToMany(mappedBy = "user")
	private Collection<Rating> ratingList=new ArrayList<Rating>();

	@OneToMany(mappedBy = "user")
	private Collection<Review> reviewList=new ArrayList<Review>();

	@OneToMany(mappedBy="user")
	private Collection<Likes> likesList=new ArrayList<Likes>();

	public User() {
		super();
	}

	public User(String username, String password, String firstname,
			String lastname, String dob, String roletype) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.roletype = roletype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRoletype() {
		return roletype;
	}
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	//@OneToMany
	public Collection<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Collection<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	 */

}
