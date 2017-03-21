package jobmate.domain;

public class Introduce {
	private int introduceNo;
	private String title;
	private IntroduceCategory category;
	private String content;
	private Customer customer;
	
	public int getIntroduceNo() {
		return introduceNo;
	}
	public void setIntroduceNo(int introduceNo) {
		this.introduceNo = introduceNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public IntroduceCategory getCategory() {
		return category;
	}
	public void setCategory(IntroduceCategory category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	
	

}
