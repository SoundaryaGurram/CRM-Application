package com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDao;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}
 
	@Override
	@Transactional
	public void  saveCustomer(Customer theCustomer)
	
	{
		 customerDao.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		
		
		return customerDao.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		 customerDao.deleteCustomer(id);
	}
}
