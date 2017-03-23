package jobmate.service;

import java.util.List;

import jobmate.domain.Question;
import jobmate.domain.Recruit;

public interface ScrapService {
	boolean createMyRecruit(String recruitID,String name,String title,String customerID);
	boolean removeMyRecruit(String recruitID,String customerID);
	List<Recruit> findMyRecruitByCustomerID(String customerID);
	
	
	boolean createMyQuestion(int questionNo,String customerID );
	boolean removeMyQuestion(int questionNo,String customerID);
	List<Question> findMyQuestionByCustomerID(String customerID);
	
	

}
