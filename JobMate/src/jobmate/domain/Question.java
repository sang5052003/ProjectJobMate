package jobmate.domain;

import java.util.List;

public class Question {
	private int questionNo;
	private String customerID;
	private QuestionCategory category;
	private String question;
	private int scrapCount;
	private List<Reply> replys;
	
	public Question() {}
	
	//questionNo는 seq라 불필요
	public Question(String customerID, QuestionCategory category, String question, int scrapCount) {
		this.customerID = customerID;
		this.category = category;
		this.question = question;
		this.scrapCount = scrapCount;
	}

	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public QuestionCategory getCategory() {
		return category;
	}
	public void setCategory(QuestionCategory category) {
		this.category = category;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getScrapCount() {
		return scrapCount;
	}
	public void setScrapCount(int scrapCount) {
		this.scrapCount = scrapCount;
	}
	public List<Reply> getReplys() {
		return replys;
	}
	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}
	
	

}
