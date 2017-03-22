package jobmate.store;

import java.util.List;

import jobmate.domain.Introduce;

public interface IntroduceStore {
	
	boolean insert(Introduce introduce);
	List<Introduce> readAllByCustomerID(String customerID);
	List<Introduce> readByTitle(String customerID, String title);
	List<Introduce> readByIntroduceContent(String customerID, String content);
	boolean update(Introduce introduce);
	boolean delete(int intorduceNo);
	List<Introduce> readAllSpec();
	Introduce readByIntroduceNo(int IntroduceNo);
}

