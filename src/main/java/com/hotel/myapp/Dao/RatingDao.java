package com.hotel.myapp.Dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hotel.myapp.model.Rating;

public class RatingDao extends DAO{
	
	public Rating lastRating(){
		
		Query q=getSession().createQuery("from Rating order by rateID DESC");
		
		q.setMaxResults(1);
		
		return (Rating) q.uniqueResult();
	}
	
}
