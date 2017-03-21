package jobmate.service;

import jobmate.domain.Customer;

public interface CustomerService {
	
	boolean create(Customer customer);			
	Customer findByID(String customerID);		
	boolean remove(String customerID);			
	boolean modify(Customer customer);			

}
