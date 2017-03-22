package jobmate.common.utill;

//면접질문 게시판의 현재 페이지 기억
public class QuestionPageManager {

	private static QuestionPageManager instance;
	
	private int curPageNo; //면접질문 게시판의 현재 페이지
	
	private QuestionPageManager() {}
	
	public static QuestionPageManager getInstance(){
		if(instance == null){
			instance = new QuestionPageManager();
		}
		return instance;
	}
	
	public void setCurPageNo(int curPageNo){
		this.curPageNo = curPageNo;
	}
	
	public int getCurPageNo(){
		return this.curPageNo;
	}
}
