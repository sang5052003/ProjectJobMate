package jobmate.service;

import jobmate.domain.Reply;

public interface ReplyService {

	boolean create(Reply reply);

	boolean modify(Reply reply);

	boolean remove(int replyNo);

	Reply findReply(int replyNo);

}
