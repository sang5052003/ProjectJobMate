package jobmate.store.mapper;

import jobmate.domain.Customer;

public interface CustomerMapper {
	
	boolean insert(Customer customer);			
	Customer readByID(String customerID);		
	boolean delete (String customerID);			
	boolean update(Customer customer);			
	
	 
}
