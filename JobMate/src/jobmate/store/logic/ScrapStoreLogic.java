package jobmate.store.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jobmate.domain.Question;
import jobmate.domain.Recruit;
import jobmate.store.ScrapStore;
import jobmate.store.mapper.MyScrapMapper;

public class ScrapStoreLogic implements ScrapStore {
	
	
	private SqlSessionFactory factory;

	public ScrapStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	
	
//	----------------------   Recruit  ---------------------

	@Override
	public boolean insertMyRecruit(String recruitID,String name,String title,String customerID) {
		SqlSession session = factory.openSession();
		
		HashMap<Object,Object> map = new HashMap<>();
		map.put("recruitID", recruitID);
		map.put("name", name);
		map.put("title", title);
		map.put("customerID", customerID);
		
		
		try{
			int result =0;
			if(!existMyRecruit(recruitID, customerID)){
				result = session.insert("insertMyRecruit",map);
				if(result >0){
					session.commit();
				} else{
					session.rollback();
				}
				
			}
			return result>0;
		} finally{
			session.close();
		}
		
		
	}

	@Override
	public boolean deleteMyRecruit(String recruitID, String customerID) {
		SqlSession session = factory.openSession();
		HashMap<Object,Object> map = new HashMap<>();
		map.put("recruitID", recruitID);
		map.put("customerID", customerID);
		
		try{
			int result = 0;
			result = session.delete("deleteMyRecruit",map);
			if(result>0){
				session.commit();
			} else{
				session.rollback();
			} 
			return result >0;
		} finally{
			session.close();
		}
	}

	@Override
	public List<Recruit> readMyRecruitByCustomerID(String customerID) {
		SqlSession session = factory.openSession();
		List<Recruit> list = new ArrayList<>();
		
		try{
			MyScrapMapper mapper = session.getMapper(MyScrapMapper.class);
			list = mapper.readMyRecruitByCustomerID(customerID);
		} finally{
			session.close();
		}
		return list;
	}

	@Override
	public boolean existMyRecruit(String recruitID, String customerID) {
		SqlSession session = factory.openSession();
		HashMap<Object,Object> map = new HashMap<>();
		map.put("recruitID", recruitID);
		map.put("customerID", customerID);
		
		List<Recruit> list = session.selectList("existMyRecruit",map);
		boolean result = false;
		
		try{
			if(list.size() == 0 ){
				result = false;
			} else{
				result = true;
			}
			
			return result;
		} finally{
			session.close();
		}
	}

	
//	 ----------------------   Question ---------------------
	
	
	@Override
	public List<Question> readMyQuestionByCustomerID(String customerID) {
		SqlSession session = factory.openSession();
		List<Question> list = new ArrayList<>();
		
		try{
			MyScrapMapper mapper = session.getMapper(MyScrapMapper.class);
			list = mapper.readMyQuestionByCustomerID(customerID);
		} finally{
			session.close();
		}
		return list;
	}

	@Override
	public boolean insertMyQuestion(int questionNo, String customerID) {
		SqlSession session = factory.openSession();
		
		HashMap<Object,Object> map = new HashMap<>();
		map.put("questionNo", questionNo);
		map.put("customerID", customerID);
		
		
		try{
			int result =0;
			if(!existMyQuestion(questionNo, customerID)){
				result = session.insert("insertMyQuestion",map);
				if(result >0){
					session.commit();
				} else{
					session.rollback();
				}
				
			}
			return result>0;
		} finally{
			session.close();
		}
	}

	@Override
	public boolean deleteMyQuestion(int questionNo, String customerID) {
		SqlSession session = factory.openSession();
		HashMap<Object,Object> map = new HashMap<>();
		map.put("questionNo", questionNo);
		map.put("customerID", customerID);
		
		try{
			int result = 0;
			result = session.delete("deleteMyQuestion",map);
			if(result>0){
				session.commit();
			} else{
				session.rollback();
			} 
			return result >0;
		} finally{
			session.close();
		}
	}

	@Override
	public boolean existMyQuestion(int questionNo, String customerID) {
		SqlSession session = factory.openSession();
		HashMap<Object,Object> map = new HashMap<>();
		map.put("questionNo", questionNo);
		map.put("customerID", customerID);
		
		List<Recruit> list = session.selectList("existMyQuestion",map);
		boolean result = false;
		
		try{
			if(list.size() == 0 ){
				result = false;
			} else{
				result = true;
			}
			
			return result;
		} finally{
			session.close();
		}
	}

}
