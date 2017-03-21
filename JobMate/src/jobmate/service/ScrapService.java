package jobmate.service;

import java.util.List;

import jobmate.domain.MyRecruit;
import jobmate.domain.Question;

public interface ScrapService {
	
	boolean createMyQuestion(int questionNo, String customerID);
	boolean removeMyQuestion(int questionNo, String customerID);
	List<Question> findMyQuestionByCustomerID(String customerID);
	boolean createRecruit(int recruitNo, String customerID);
	boolean removeRecruit(int recruitNo, String customerID);
	List<MyRecruit> findMyRecruitByCustomerId(String customerID);


}
