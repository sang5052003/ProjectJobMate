package jobmate.service.logic;

import java.util.List;

import jobmate.domain.Question;
import jobmate.service.InterviewService;
import jobmate.store.QuestionStore;
import jobmate.store.ScrapStore;
import jobmate.store.logic.QuestionStoreLogic;
import jobmate.store.logic.ScrapStoreLogic;

public class InterviewServiceLogic implements InterviewService {

	private QuestionStore questionStore;
	private ScrapStore scrapStore;

	public InterviewServiceLogic() {
		questionStore = new QuestionStoreLogic();
		scrapStore = new ScrapStoreLogic();
	}
	
	@Override
	public List<Question> findByInterview(String category) {


		List<Question> list = questionStore.readByInterview(category);
		return list;
	}

	@Override
	public List<Question> findMyQuestionByCustomerID(String customerID) {

		
		List<Question> list = scrapStore.readMyQuestionByCustomerID(customerID);
		return list;
	}

}
