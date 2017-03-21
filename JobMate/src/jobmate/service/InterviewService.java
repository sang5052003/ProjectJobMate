package jobmate.service;

import java.util.List;

import jobmate.domain.Question;

public interface InterviewService {
	
	List<Question> findByInterview(String category);
	List<Question> findMyQuestionByCustomerID(String customerID);

}
