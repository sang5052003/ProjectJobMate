package jobmate.store;

import java.util.List;

import jobmate.domain.Question;
import jobmate.domain.Recruit;

public interface ScrapStore {
	boolean insertMyRecruit(String recruitID,String name,String title,String customerID);
	boolean deleteMyRecruit(String recruitID,String customerID);
	boolean existMyRecruit(String recruitID,String customerID);
	List<Recruit> readMyRecruitByCustomerID(String customerID);
	
	
	boolean insertMyQuestion(int questionNo,String customerID);
	boolean deleteMyQuestion(int questionNo,String customerID);
	boolean existMyQuestion(int questionNo,String customerID);
	List<Question> readMyQuestionByCustomerID(String customerID);
	

}
