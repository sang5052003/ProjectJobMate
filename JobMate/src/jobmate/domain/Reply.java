package jobmate.domain;

public class Reply {
	private int replyNo;
	private String content;
	private String customerID;
	private int questionNo;
	
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	

}
