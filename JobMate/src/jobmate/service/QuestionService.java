package jobmate.service;

import java.util.List;

import jobmate.domain.Question;

public interface QuestionService {
	
	boolean create(Question question);
	List<Question> findAll();
	Question findByQuestionNo(int questionNo);
	List<Question> findByContent(String content);
	boolean remove(int questionNo);

}
