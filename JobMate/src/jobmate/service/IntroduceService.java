package jobmate.service;

import java.util.List;

import jobmate.domain.Introduce;

public interface IntroduceService {
	
	boolean create(Introduce introduce);
	List<Introduce> findAllByCustomerID(String customerID);
	List<Introduce> findByTitle(String customerID, String title);
	List<Introduce> findByContent(String customerID, String content);
	boolean modify(Introduce introduce);
	boolean remove(int intorduceNo);
	Introduce findbyIntroduceNo(int intorduceNo); 
	List<Introduce> findAllSpec(String title);

}
