package jobmate.store.logic;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jobmate.domain.Customer;
import jobmate.store.CustomerStore;
import jobmate.store.mapper.CustomerMapper;

public class CustomerStoreLogic implements CustomerStore {

	private SqlSessionFactory factory;

	public CustomerStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean insert(Customer customer) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CustomerMapper mapper = session.getMapper(jobmate.store.mapper.CustomerMapper.class);
			result = mapper.insert(customer);

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
	public Customer readByID(String customerID) {

		SqlSession session = factory.openSession();

		Customer customer = null;

		try {
			CustomerMapper mapper = session.getMapper(jobmate.store.mapper.CustomerMapper.class);
			customer = mapper.readByID(customerID);
		} finally {
			session.close();
		}
		return customer;
	}

	@Override
	public boolean delete(String customerID) {

		SqlSession session = factory.openSession();

		boolean result = false;

		try {
			CustomerMapper mapper = session.getMapper(jobmate.store.mapper.CustomerMapper.class);
			result = mapper.delete(customerID);

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
	public boolean update(Customer customer) {

		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			CustomerMapper mapper = session.getMapper(jobmate.store.mapper.CustomerMapper.class);
			result = mapper.update(customer);

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
}