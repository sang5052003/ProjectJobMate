package jobmate.store.logic;

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
			IntroduceMapper mapper = session.getMapper(jobmate.store.mapper.IntroduceMapper.class);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Introduce> readByTitle(String customerID, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Introduce> readByContent(String customerID, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Introduce introduce) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int intorduceNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Introduce> readAllSpec(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
