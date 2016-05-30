package com.hotel.myapp;

import java.util.Date;

import org.hibernate.Session;

import com.hotel.myapp.model.Booking;
import com.hotel.myapp.model.Hotel;
import com.hotel.myapp.model.Likes;
import com.hotel.myapp.model.Rating;
import com.hotel.myapp.model.Review;
import com.hotel.myapp.model.User;
import com.hotel.myapp.Dao.HibernateUtil;

public class MainTest {
/*
	public static void main(String[] args){

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		User user=new User();

		user.setFirstname("Dhawal");
		user.setLastname("Vora");
		user.setPassword("Password");
		user.setRoletype("Customer");
		user.setUsername("username");
		user.setDob("05/05/2014");

		session.save(user);
		
		Hotel hotel=new Hotel();
		
		hotel.setHotelName("Hotel 1");
		hotel.setLocation("Boston");
		
		session.save(hotel);

		Booking booking=new Booking();

		booking.setHotelID("1");
		booking.setUsername("username");
		booking.setFirstname("Dhawal");
		booking.setLastname("Vora");
		booking.setRoomType("Deluxe");
		booking.setPrice("50,000");
		booking.setArrivalDate("1st May, 2015");
		booking.setDepartureDate("30th April, 2015");
		booking.setSpecialrequest("None");

		booking.setUser(user);
		booking.setHotel(hotel);
		
		user.getBookingList().add(booking);
		
		session.save(booking);
		
		Rating rating=new Rating();
		
		rating.setUsername("username");
		rating.setHotelID("1");
		rating.setValue(10);
		
		rating.setUser(user);
		rating.setHotel(hotel);
		
		user.getRatingList().add(rating);
		
		session.save(rating);
		
		Review review=new Review();
		
		review.setUsername("username");
		review.setHotelID("1");
		review.setTitle("Review 1");
		review.setReviewDate(new Date());
		
		review.setUser(user);
		review.setHotel(hotel);
		
		user.getReviewList().add(review);
		
		session.save(review);
		
		Likes likes=new Likes();
		
		likes.setUsername("username");
		likes.setHotelID("1");
		
		likes.setUser(user);
		likes.setHotel(hotel);
		
		user.getLikesList().add(likes);
		
		session.save(likes);

		session.getTransaction().commit();

	}
*/
}
