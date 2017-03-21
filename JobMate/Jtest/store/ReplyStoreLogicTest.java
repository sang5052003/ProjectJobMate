package store;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jobmate.domain.Reply;
import jobmate.store.ReplyStore;
import jobmate.store.logic.ReplyStoreLogic;

public class ReplyStoreLogicTest {
	private ReplyStore store;
	
	@Before
	public void setUp(){
		this.store = new  ReplyStoreLogic();
	}

//	@Test
//	public void testInsert() {
//		Reply reply = new Reply();
//		boolean s = false;
//		
//		reply.setCustomerID("1");
//		reply.setContent("2");
//		reply.setReplyNo(3);
//		reply.setQuestionNo(4);
//		
//		
//		s = store.insert(reply);
//		
//		assertEquals(true, s);
//				
//		
//	}

//	@Test
//	public void testReadAll() {
//		
//		List<Reply> list = store.readAll(4);
//		
//		assertEquals(1, list.size());
//		
//	}
////
//	@Test
//	public void testUpdate() {
//		Reply reply = new Reply();
//		boolean s = false;
//		
//		reply.setCustomerID("1");
//		reply.setContent("3");
//		reply.setReplyNo(1);
//		reply.setQuestionNo(4);
//		
//		s = store.update(reply);
//		
//		assertEquals(true, s );
//		
//		
//	}

	@Test
	public void testDelete() {
		boolean s = false;
		s= store.delete(1);
		
		assertEquals(true, s);
	}

}
