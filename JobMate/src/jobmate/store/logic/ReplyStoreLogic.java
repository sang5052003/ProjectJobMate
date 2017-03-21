package jobmate.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jobmate.domain.Reply;
import jobmate.store.ReplyStore;
import jobmate.store.mapper.ReplyMapper;

public class ReplyStoreLogic implements ReplyStore {

	private SqlSessionFactory factory;

	public ReplyStoreLogic() {
		this.factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean insert(Reply reply) {
		
		SqlSession session = this.factory.openSession();
		boolean status = false;
		
		try{
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			status= mapper.insert(reply);
			
			if(status){
				session.commit();
			}else{
				session.rollback();
			}
		
		}finally{
			session.close();
		}
		
		return status;
	}

	@Override
	public List<Reply> readAll(int questionNo) {
		
		SqlSession session = this.factory.openSession();
		List<Reply> list = null;
		
		try{
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			list = mapper.readAll(questionNo);
		}finally{
			session.close();
		}
		
		return list;
	}

	@Override
	public boolean update(Reply reply) {
		
		SqlSession session = factory.openSession();
		boolean status = false;
		
		try{
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			status= mapper.update(reply);
			
			if(status){
				session.commit();
			}else{
				session.rollback();
			}
		
		}finally{
			session.close();
		}
		
		return status;
		
	}

	@Override
	public boolean delete(int replyNo) {
		
		SqlSession session = factory.openSession();
		boolean status = false;
		
		try{
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			status= mapper.delete(replyNo);
			
			if(status){
				session.commit();
			}else{
				session.rollback();
			}
		
		}finally{
			session.close();
		}
		
		return status;
		
		
	}

}
