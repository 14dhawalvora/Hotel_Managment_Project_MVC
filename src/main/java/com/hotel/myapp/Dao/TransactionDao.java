package com.hotel.myapp.Dao;

import org.hibernate.Query;

import com.hotel.myapp.model.Rating;
import com.hotel.myapp.model.Transaction;

public class TransactionDao extends DAO{

	public Transaction getTransaction(int transactionID)throws Exception{

		try{
			Query q=getSession().createQuery("FROM Transaction where transactionID = :transactionID");
			q.setInteger("transactionID", transactionID);

			Transaction transaction=(Transaction) q.uniqueResult();
			return transaction;

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error in BookingDAO");
		}

		return null;		
	}

	public Transaction lastTransaction(){
		
		Query q=getSession().createQuery("from Transaction order by transactionID DESC");
		
		q.setMaxResults(1);
		
		return (Transaction) q.uniqueResult();
		
	}

}
