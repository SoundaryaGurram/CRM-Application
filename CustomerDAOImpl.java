package com.springdemo.dao;

import java.util.List;



//import javax.websocket.Session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	SessionFactory factory;

	
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		
		Session session=factory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer order by lastName",Customer.class);
		
		List<Customer> customers=query.getResultList();
				
			
		
		
		//System.out.println();
		return customers;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		Session session1=factory.getCurrentSession();
		
		session1.saveOrUpdate(theCustomer);
		
	}



	@Override
	public Customer getCustomer(int id) 
	{
		// TODO Auto-generated method stub
		
		Session session2=factory.getCurrentSession();
		Customer theCustomer=session2.get(Customer.class, id);
		return theCustomer;
}



	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
		Session session3=factory.getCurrentSession();
		Query  query=session3.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}

}

	

	
	

