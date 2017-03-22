package store;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import jobmate.domain.Customer;
import jobmate.domain.Introduce;
import jobmate.domain.IntroduceCategory;
import jobmate.store.IntroduceStore;
import jobmate.store.logic.CustomerStoreLogic;
import jobmate.store.logic.IntroduceStoreLogic;

public class IntroduceStoreLogicTest {
	
	private IntroduceStoreLogic introduceStore;
	private CustomerStoreLogic customerStore;
	
	@Before
	public void setUp(){
		introduceStore = new IntroduceStoreLogic();
		customerStore = new CustomerStoreLogic();
		
	}
	
	
	
//	@Test
//	public void testInsert() {
//		Introduce introduce = new Introduce();
//		introduce.setCategory(IntroduceCategory.cons);
//		introduce.setTitle("111");
//		introduce.setContent("ddddddd");
//		Customer customer = customerStore.readByID("choi");
//		introduce.setCustomer(customer);
//		
//		assertTrue(introduceStore.insert(introduce));
//	}

	@Test
	public void testReadAllByCustomerID() {
		List<Introduce> list = introduceStore.readAllByCustomerID("choi");
		assertEquals(2, list.size());
	}

//	@Test
//	public void testReadByTitle() {
//		List<Introduce> list = introduceStore.readByTitle("choi", "2");
//		assertEquals(1, list.size());
//	}
//
//	@Test
//	public void testReadByContent() {
//		List<Introduce> list = introduceStore.readByContent("choi", "2");
//		assertEquals(1, list.size());
//	}

//	@Test
//	public void testUpdate() {
//		Introduce introduce =introduceStore.readByIntroduceNo(2);
//		introduce.setCategory(IntroduceCategory.aspiration);
//		assertTrue(introduceStore.update(introduce));
//		
//	}
//
//	@Test
//	public void testDelete() {
//		assertTrue(introduceStore.delete(2));
//	}

//	@Test
//	public void testReadAllSpec() {
//		List<Introduce> list = introduceStore.readAllSpec();
//		assertEquals(2, list.size());
//	}
//
//	
	

}
