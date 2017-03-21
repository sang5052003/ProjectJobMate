package jobmate.store;

import java.util.List;

import jobmate.domain.Question;

public interface QuestionStore {
	
	boolean insert(Question question);
	List<Question> readAll();
	Question readByQuestionNo(int questionNo);
	List<Question> readByContent(String content);
	boolean delete(int questionNo);
	List<Question> readByInterview(String category);
}
