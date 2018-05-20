package com.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String customerList(Model theModel)
	{
		List<Customer> customers=new ArrayList<>();
		customers=customerService.getCustomers();
	     theModel.addAttribute("customers",customers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String addtheCustomer(Model theModel)
	
	{
		Customer cust=new Customer();
		theModel.addAttribute("customer",cust);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	
	{
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateForm(@RequestParam("customerId") int Id,Model theModel)
	
	{
		
		Customer cust=customerService.getCustomer(Id);
		
		theModel.addAttribute(cust);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int Id)
	{
		customerService.deleteCustomer(Id);
		
		return "redirect:/customer/list";
	}
}



	

