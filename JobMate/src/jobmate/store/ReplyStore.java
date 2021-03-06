package jobmate.store;

import java.util.List;

import jobmate.domain.Reply;

public interface ReplyStore {
	
	boolean insert(Reply reply);
	List<Reply> readAll(int questionNo);
	boolean update(Reply reply);
	boolean delete(int replyNo);
	Reply readReply(int replyNo);

}
