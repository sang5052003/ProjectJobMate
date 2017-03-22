package jobmate.service.logic;

import java.util.List;

import jobmate.domain.Introduce;
import jobmate.service.IntroduceService;
import jobmate.store.IntroduceStore;
import jobmate.store.logic.IntroduceStoreLogic;

public class IntroduceServiceLogic implements IntroduceService {
	
	private IntroduceStore store;
	
	public IntroduceServiceLogic() {
		store = new IntroduceStoreLogic();
	}
	
	
	@Override
	public boolean create(Introduce introduce) {
		return store.insert(introduce);
	}

	@Override
	public List<Introduce> findAllByCustomerID(String customerID) {
		return store.readAllByCustomerID(customerID);
	}

	@Override
	public List<Introduce> findByTitle(String customerID, String title) {
		return store.readByTitle(customerID, title);
	}

	@Override
	public List<Introduce> findByContent(String customerID, String content) {
		return store.readByIntroduceContent(customerID, content);
	}

	@Override
	public boolean modify(Introduce introduce) {
		return store.update(introduce);
	}

	@Override
	public boolean remove(int intorduceNo) {
		return store.delete(intorduceNo);
	}


	@Override
	public List<Introduce> findAllSpec() {
		return store.readAllSpec();
	}

	@Override
	public Introduce findbyIntroduceNo(int introduceNo) {
		return store.readByIntroduceNo(introduceNo);
	}

}
