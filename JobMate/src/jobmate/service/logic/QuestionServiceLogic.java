package jobmate.service.logic;

import java.util.List;

import jobmate.domain.Question;
import jobmate.service.QuestionService;
import jobmate.store.QuestionStore;
import jobmate.store.ReplyStore;
import jobmate.store.ScrapStore;
import jobmate.store.logic.QuestionStoreLogic;

public class QuestionServiceLogic implements QuestionService{

	private QuestionStore store;
	private ReplyStore replyStore;
	private ScrapStore scrapStore;
	
	public QuestionServiceLogic() {
		this.store = new QuestionStoreLogic();
		
		
	}
	
	@Override
	public boolean create(Question question) {
		return this.store.insert(question);
	}

	@Override
	public List<Question> findAll() {
		return this.store.readAll();
	}

	@Override
	public Question findByQuestionNo(int questionNo) {
		return this.store.readByQuestionNo(questionNo);
	}

	@Override
	public List<Question> findByContent(String content) {
		return this.store.readByContent(content);
	}

	@Override
	public boolean remove(int questionNo) {
		
		//transaction 처리?
		//답변들을 지우고
		//스크랩들을 지우고
		//질문을 지운다
		
		
		this.store.delete(questionNo);
		
		return false;
	}

}
