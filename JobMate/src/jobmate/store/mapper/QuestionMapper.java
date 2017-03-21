package jobmate.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jobmate.domain.Question;

public interface QuestionMapper {
	
	boolean insert(Question question);
	List<Question> readAll();
	Question readByQuestionNo(int questionNo);
	List<Question> readByContent(String content);
	boolean delete(int questionNo);
	
	//
	//인자가 두개!
	List<Question> readByInterview(@Param("category") String category, @Param("admin") String admin);
}
