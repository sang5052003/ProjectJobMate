package store;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jobmate.domain.Question;
import jobmate.store.ScrapStore;
import jobmate.store.logic.ScrapStoreLogic;

public class ScrapStoreLogicTest {

	
	private ScrapStore store;
	
	@Before
	public void setUp(){
		this.store = new ScrapStoreLogic();
	}
//	@Test
//	public void testScrapStoreLogic() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertMyRecruit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteMyRecruit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testReadMyRecruitByCustomerID() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testExistMyRecruit() {
//		fail("Not yet implemented");
//	}

	//@Test
	public void testReadMyQuestionByCustomerID() {
		List<Question> list =store.readMyQuestionByCustomerID("박막내");
		assertEquals(3,list.size());
	}

//	@Test
//	public void testInsertMyQuestion() {
//		boolean check = store.insertMyQuestion(3, "박막내");
//		assertEquals(true, check);
//	}

	//@Test
	public void testDeleteMyQuestion() {
		boolean check = store.deleteMyQuestion(3,"박막내");
		assertEquals(true, check);
		
	}
//
	@Test
	public void testExistMyQuestion() {
		boolean check = store.existMyQuestion(1, "박막내");
		assertEquals(true, check);
	}

}
