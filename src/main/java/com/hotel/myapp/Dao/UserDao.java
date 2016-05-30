package com.hotel.myapp.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hotel.myapp.model.User;

public class UserDao extends DAO{

	public User queryByUsernameAndPassword(String username, String password) throws Exception{

		try{
			Query q=getSession().createQuery("from User where username=:username and password=:password");
			q.setString("username", username);
			q.setString("password", password);

			User user=(User) q.uniqueResult();

			return user;
			
		}catch(HibernateException e){
			throw new Exception("Could not get user " + username, e);
		}

	}

}
