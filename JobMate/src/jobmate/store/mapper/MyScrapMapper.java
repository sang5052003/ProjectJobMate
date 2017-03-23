package jobmate.store.mapper;

import java.util.List;

import jobmate.domain.Question;
import jobmate.domain.Recruit;

public interface MyScrapMapper {
	
	boolean insertMyRecruit(String recruitID,String name,String title,String customerID);
	boolean deleteMyRecruit(int recruitID,String customerID );
	
	boolean insertMyQuestion(int questionNo,String customerID);
	boolean deleteMyQuestion(int questionNo,String customerID);
	
	boolean existMyRecruit(int recruitID,String customerID);
	boolean existMyQuestion(int questionNo,String customerID);
	
	List<Recruit> readMyRecruitByCustomerID(String customerID);
	List<Question> readMyQuestionByCustomerID(String customerID);
	
}
