package store;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jobmate.domain.Customer;
import jobmate.store.logic.CustomerStoreLogic;

public class CustomerStoreLogicTest {
	
	private CustomerStoreLogic store;
	
	@Before
	public void setUp(){
		store = new CustomerStoreLogic();
	}

//	@Test
//	public void testInsert() {
//		
//		Customer customer = new Customer();
//		customer.setCustomerID("jungki");
//		customer.setName("송중기");
//		customer.setPassword("6547");
//		
//		store.insert(customer);
//		
//		
//		
//	}

	@Test
	public void testReadByID() {
		
		Customer customer = store.readByID("jungki");
		assertEquals("jungki", customer.getCustomerID());
		assertEquals("1004", customer.getPassword());
	}
//
//	@Test
//	public void testDelete() {
//	
//		store.delete("mimi");
//	
//	}
//
//	@Test
//	public void testUpdate() {
//		
//		Customer customer = new Customer();
//		customer.setCustomerID("jungki");
//		customer.setName("송중기");
//		customer.setPassword("1004");
//		
//		store.update(customer);
//	}

}
