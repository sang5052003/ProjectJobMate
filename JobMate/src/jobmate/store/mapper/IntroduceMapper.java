package jobmate.store.mapper;

import java.util.List;

import jobmate.domain.Introduce;

public interface IntroduceMapper {
	
	boolean insert(Introduce introduce);
	List<Introduce> readAllByCustomerID(String customerID);
	List<Introduce> readByTitle(String customerID, String title);
	List<Introduce> readByContent(String customerID, String content);
	boolean update(Introduce introduce);
	boolean delete(int intorduceNo);
	List<Introduce> readAllSpec(String title);
}
