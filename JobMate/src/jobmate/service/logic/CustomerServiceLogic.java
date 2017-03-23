package jobmate.service.logic;

import jobmate.domain.Customer;
import jobmate.service.CustomerService;
import jobmate.store.CustomerStore;
import jobmate.store.logic.CustomerStoreLogic;

public class CustomerServiceLogic implements CustomerService{
	
	private CustomerStore store;


	public CustomerServiceLogic() {
		store = new CustomerStoreLogic();
	}

	@Override
	public boolean create(Customer customer) {
		return store.insert(customer);
	}

	@Override
	public Customer findByID(String customerID) {
		return store.readByID(customerID);
	}

	@Override
	public boolean remove(String customerID) {
		return store.delete(customerID);
	}

	@Override
	public boolean modify(Customer customer) {
		return store.update(customer);
	}

}
