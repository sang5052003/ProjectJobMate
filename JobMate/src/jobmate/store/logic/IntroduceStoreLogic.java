package jobmate.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jobmate.domain.Introduce;
import jobmate.store.IntroduceStore;
import jobmate.store.mapper.IntroduceMapper;

public class IntroduceStoreLogic implements IntroduceStore {

	private SqlSessionFactory factory;

	public IntroduceStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean insert(Introduce introduce) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			IntroduceMapper mapper = session.getMapper(IntroduceMapper.class);
			result = mapper.insert(introduce);

			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;

		} finally {
			session.close();
		}
	}

	@Override
	public List<Introduce> readAllByCustomerID(String customerID) {
		SqlSession session = factory.openSession();
		List<Introduce> list =null;
		
		try{
		IntroduceMapper mapper = session.getMapper(IntroduceMapper.class);
		list=mapper.readAllByCustomerID(customerID);
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Introduce> readByTitle(String customerID, String title) {
		SqlSession session = factory.openSession();
		List<Introduce> list =null;
		HashMap<String, String> map = new HashMap<>();
		map.put("customerID", customerID);
		map.put("title", title);
		
		try{
		list=session.selectList("readByTitle", map);
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Introduce> readByIntroduceContent(String customerID, String content) {
		SqlSession session = factory.openSession();
		List<Introduce> list =null;
		HashMap<String, String> map = new HashMap<>();
		map.put("customerID", customerID);
		map.put("content", content);
		
		try{
		list=session.selectList("readByIntroduceContent", map);
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public boolean update(Introduce introduce) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			IntroduceMapper mapper = session.getMapper(IntroduceMapper.class);
			result = mapper.update(introduce);

			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;

		} finally {
			session.close();
		}
	}

	@Override
	public boolean delete(int intorduceNo) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			IntroduceMapper mapper = session.getMapper(IntroduceMapper.class);
			result = mapper.delete(intorduceNo);

			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;

		} finally {
			session.close();
		}
	}

	@Override
	public List<Introduce> readAllSpec() {
		SqlSession session = factory.openSession();
		List<Introduce> list =null;
		
		try{
		IntroduceMapper mapper = session.getMapper(IntroduceMapper.class);
		list=mapper.readAllSpec();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public Introduce readByIntroduceNo(int IntroduceNo) {
		SqlSession session = factory.openSession();
		Introduce introduce=null;
		
		try{
		IntroduceMapper mapper = session.getMapper(IntroduceMapper.class);
		introduce = mapper.readByIntroduceNo(IntroduceNo);
		}finally{
			session.close();
		}
		return introduce;
	}

}
