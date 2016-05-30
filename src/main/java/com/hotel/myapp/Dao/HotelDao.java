package com.hotel.myapp.Dao;

import java.util.List;

import org.hibernate.Query;

import com.hotel.myapp.model.Hotel;

public class HotelDao extends DAO{

	public Hotel getHotelList(int hotelId)throws Exception{

		try{
			Query q=getSession().createQuery("FROM Hotel where hotelId = :hotelId");
			//q.setCacheable(true);
			q.setInteger("hotelId", hotelId);

			Hotel hotel=(Hotel) q.uniqueResult();

			return hotel;

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error in HotelDAO");
		}

		return null;		
	}

}
