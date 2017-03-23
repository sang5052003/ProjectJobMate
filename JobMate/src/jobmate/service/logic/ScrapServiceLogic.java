package jobmate.service.logic;

import java.util.List;

import jobmate.domain.Question;
import jobmate.domain.Recruit;
import jobmate.service.ScrapService;
import jobmate.store.ScrapStore;
import jobmate.store.logic.ScrapStoreLogic;

public class ScrapServiceLogic implements ScrapService{
	
	private ScrapStore store;
	
	public ScrapServiceLogic() {
		store = new ScrapStoreLogic();
	}

	@Override
	public boolean createMyRecruit(String recruitID,String name,String title,String customerID) {
		return store.insertMyRecruit(recruitID,name,title,customerID);
	}

	@Override
	public boolean removeMyRecruit(String recruitID,String customerID) {
		return store.deleteMyRecruit(recruitID, customerID);
	}

	@Override
	public List<Recruit> findMyRecruitByCustomerID(String customerID) {
		return store.readMyRecruitByCustomerID(customerID);
	}

	@Override
	public List<Question> findMyQuestionByCustomerID(String customerID) {
		return store.readMyQuestionByCustomerID(customerID);
	}

	@Override
	public boolean createMyQuestion(int questionNo, String customerID) {
		return store.insertMyQuestion(questionNo, customerID);
	}

	@Override
	public boolean removeMyQuestion(int questionNo, String customerID) {
		return store.deleteMyQuestion(questionNo, customerID);
	}

}
