package jobmate.store.mapper;

import java.util.List;

import jobmate.domain.Question;

public interface ScrapMapper {
	
	boolean insertMyQuestion(int questionNo, String customerID);
	boolean deleteMyQuestion(int questionNo, String customerID);
	List<Question> readMyQuestionByCustomerID(String customerID);
	boolean existCustomerQuestion(int questionNo, String customerID);
	boolean insertRecruit(int recruitNo, String customerID);
	boolean deleteRecruit(int recruitNo, String customerID);
}
