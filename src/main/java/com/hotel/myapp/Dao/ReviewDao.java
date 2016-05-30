package com.hotel.myapp.Dao;

import org.hibernate.Query;

import com.hotel.myapp.model.Review;

public class ReviewDao extends DAO{

	public Review getReviews(String username,String title, String review)throws Exception{

		try{
			Query q=getSession().createQuery("FROM Review where username = :username and title = :title and review = :review");

			q.setString("username", username);
			q.setString("title", title);
			q.setString("review", review);

			Review reviewResult=(Review) q.uniqueResult();
			return reviewResult;

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error in ReviewDAO");
		}

		return null;		
	}

}
