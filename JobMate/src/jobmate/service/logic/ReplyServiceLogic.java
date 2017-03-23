package jobmate.service.logic;

import jobmate.domain.Reply;
import jobmate.service.ReplyService;
import jobmate.store.ReplyStore;
import jobmate.store.logic.ReplyStoreLogic;

public class ReplyServiceLogic implements ReplyService {
	private ReplyStore store;

	public ReplyServiceLogic() {
		store = new ReplyStoreLogic();

	}

	@Override
	public boolean create(Reply reply) {
		return store.insert(reply);
	}

	@Override
	public boolean modify(Reply reply) {
		return store.update(reply);
	}

	@Override
	public boolean remove(int replyNo) {
		return store.delete(replyNo);
	}

	@Override
	public Reply findReply(int replyNo) {

		return store.readReply(replyNo);
	}

}
