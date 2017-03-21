package jobmate.store;

import jobmate.domain.Customer;

public interface CustomerStore {
	
	boolean insert(Customer customer);			
	Customer readByID(String customerID);		
	boolean delete (String customerID);			
	boolean update(Customer customer);			
	
	 
}
