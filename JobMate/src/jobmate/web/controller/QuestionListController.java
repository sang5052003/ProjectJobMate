package jobmate.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.common.utill.QuestionPageManager;
import jobmate.domain.Customer;
import jobmate.domain.Question;
import jobmate.service.QuestionService;
import jobmate.service.logic.QuestionServiceLogic;

@WebServlet("/question/list.do")
public class QuestionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 리스트 뿌리기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 일단 모든 질문을 뽑아오고
		QuestionService service = new QuestionServiceLogic();
		List<Question> listAll = service.findAll();
		
		this.setList(listAll, request, response);
	}

	// 면접질문 검색
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//
		QuestionService service = new QuestionServiceLogic();
		
		//search
		String search = request.getParameter("search");
		List<Question>listAll = service.findByContent(search);
		
		//카테고리별 검색 추가?
		//selCategory
		String category = request.getParameter("selCategory");
		
		//성능개구림
		if(category.equals("both")){ //전체
			this.setList(listAll, request, response);
		}else{ //기술, 인성
			List<Question>list = new ArrayList<>();
			for(Question q : listAll){
				if(q.getCategory().toString().equals(category)){
					list.add(q);
				}
			}
			
			this.setList(list, request, response);
		}
	}
	
	private void setList(List<Question> listAll, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		

		// 페이지만들어서 뿌리기(밑에 번호..)
		int size = listAll.size();

		// 뽑아온 질문중 한페이지에 몇개 씩 보여줄지 리스트에서 뽑는다
		List<Question> list = new ArrayList<>();

		//페이지만들어서 뿌리기(밑에 번호..)
		int pagePerCount = 5; // 기본 5개씩 페이지당 보여준다 라고 치고
		size /= pagePerCount;
		List<Integer> sizeList = new ArrayList<>(size); // 비효율 지리네
		for (int i = 0; i < size; i++) {
			sizeList.add(i);
		}
		
		//
		// 넘겨준 페이지번호, 넘겨줄때-- 해서 옴
		String pageNumStr = request.getParameter("pageNum"); //목록아래의 숫자나 화살표 클릭 시
		int pageNum = QuestionPageManager.getInstance().getCurPageNo(); //작성, 삭제 시 들어온다
		if(pageNumStr != null){ //검색, 아래숫자, 최초뿌리기
			pageNum = Integer.parseInt(pageNumStr);
			QuestionPageManager.getInstance().setCurPageNo(pageNum);
			if(pageNum < 0){
				pageNum = 0;
			}else if(pageNum > size){
				pageNum = size;
			}
		}
		
		request.setAttribute("curPageNum", pageNum); //넘겨줄 현재 페이지 번호
		
		
		int startPage = pageNum * pagePerCount; // 몇페이지를 선택했는가..
		for (int i = startPage; i < pagePerCount + startPage; i++) {
			
			//outofbounds처리
			if(listAll.size() == i){
				break;
			}
			
			list.add(listAll.get(i));
		}

		
		request.setAttribute("sizeList", sizeList); // 몇개의 숫자를 보여줄지(몇페이지까지..)

		// 실제 한페이지에 뿌려질 리스트
		request.setAttribute("list", list);

		// 자기질문 삭제 표시
		// 즐겨찾기 표시
//		HttpSession session = request.getSession(false); // false세션정보 없으면 만들지 않음
//		if (session != null) {
//			request.setAttribute("loginUser", session.getAttribute("loginUser"));
//		}
//		// 테스트 삭제 요망, 나중에는 로그인한 세션정보로 할 것이므로..
//		Customer loginUser = new Customer();
//		loginUser.setCustomerID("갓기");
//		request.setAttribute("loginUser", loginUser);

		//
		request.getRequestDispatcher("/views/questionList.jsp").forward(request, response);
	}

}
