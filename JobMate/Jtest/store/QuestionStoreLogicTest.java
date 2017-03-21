package store;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jobmate.domain.Question;
import jobmate.domain.QuestionCategory;
import jobmate.store.QuestionStore;
import jobmate.store.logic.QuestionStoreLogic;

public class QuestionStoreLogicTest {

	private QuestionStore store;
	
	@Before
	public void setUp(){
		this.store = new QuestionStoreLogic();
	}
	
//	@Test
//	public void testInsert() {
//		
//		boolean b = this.store.insert(new Question("kim", QuestionCategory.personality, "인성질문내용임kim", 0));
//		
//		assertEquals(true, b);
//	}
//
//	@Test
//	public void testReadAll() {
//		
//		List<Question> list = this.store.readAll();
//		
//		assertEquals(2, list.size());
//		
//	}
//
	@Test
	public void testReadByQuestionNo() {
		
		Question q = this.store.readByQuestionNo(6);
		
		assertEquals(QuestionCategory.personality, q.getCategory());
		assertEquals("admin", q.getCustomerID());
	}
//
//	@Test
//	public void testReadByContent() {
//		
//		List<Question> list = this.store.readByContent("2");
//		
//		assertEquals(1, list.size());
//	}
//
//	
//
//	@Test
//	public void testDelete() {
//		
//		boolean b = this.store.delete(3);
//		assertEquals(true, b);
//		
//		assertNull(this.store.readByQuestionNo(3));
//		
//	}
//
//	@Test
//	public void testReadByInterview() {
//		
//		List<Question> list = this.store.readByInterview(QuestionCategory.personality.toString());
//
//		assertEquals(2, list.size());
//	}

}
