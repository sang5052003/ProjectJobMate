package jobmate.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jobmate.domain.Constant;
import jobmate.domain.Question;
import jobmate.store.QuestionStore;
import jobmate.store.mapper.QuestionMapper;

public class QuestionStoreLogic implements QuestionStore {

	private SqlSessionFactory factory;
	
	public QuestionStoreLogic() {
		this.factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	
	@Override
	public boolean insert(Question question) {
		
		SqlSession session = this.factory.openSession();
		boolean b = false;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			b = mapper.insert(question); //insert인데 boolean으로 받아짐?
			
			if(b){
				session.commit();
			}else{
				session.rollback();
			}

		} finally {
			session.close();
		}
		return b;
	}

	@Override
	public List<Question> readAll() {
		
		SqlSession session = this.factory.openSession();
		List<Question> list = null;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			list = mapper.readAll();

		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Question readByQuestionNo(int questionNo) {
		
		SqlSession session = this.factory.openSession();
		Question question = null;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			question = mapper.readByQuestionNo(questionNo);

		} finally {
			session.close();
		}
		return question; 
	}

	@Override
	public List<Question> readByContent(String content) {
		
		SqlSession session = this.factory.openSession();
		List<Question> list = null;
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			list = mapper.readByContent(content);

		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean delete(int questionNo) {
		
		SqlSession session = this.factory.openSession();
		boolean b = false;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			b = mapper.delete(questionNo);
			
			if(b){
				session.commit();
			}else{
				session.rollback();
			}
		} finally {
			session.close();
		}
		return b;
	}

	//면접질문 내용(인성면접, 기술면접, 나만의 질문)에 따라 검색
	//서비스에는 존재 하지 않는다
	@Override
	public List<Question> readByInterview(String category) {
		
		SqlSession session = this.factory.openSession();
		List<Question> list = null;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			
			//관리자아이디로 올려진 질문만 받아옴
			list = mapper.readByInterview(category, Constant.ADMIN_ID); 

		} finally {
			session.close();
		}
		return list;
	}

}
