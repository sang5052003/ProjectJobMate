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

		// 페이지만들어서 뿌리기(밑에 번호..)
		int size = listAll.size();

		// 뽑아온 질문중 한페이지에 몇개 씩 보여줄지 리스트에서 뽑는다
		List<Question> list = new ArrayList<>();

		//
		// 넘겨준 페이지번호, 넘겨줄때-- 해서 옴
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int pagePerCount = 5; // 기본 5페이지씩 보여준다 라고 치고
		int startPage = pageNum * pagePerCount; // 몇페이지를 선택했는가..
		for (int i = startPage; i < pagePerCount + startPage; i++) {
			
			//outofbounds처리
			if(listAll.size() == 0){
				break;
			}
			
			list.add(listAll.get(i));
			
			//outofbounds처리
			listAll.remove(listAll.get(i));
		}

		////페이지만들어서 뿌리기(밑에 번호..)
		size /= pagePerCount;
		// if(size % 5 != 0){ //한페이지 더
		// size++;
		// }
		List<Integer> sizeList = new ArrayList<>(size); // 비효율 지리네
		for (int i = 0; i < size; i++) {
			sizeList.add(i);
		}
		request.setAttribute("sizeList", sizeList); // 몇개의 숫자를 보여줄지(몇페이지까지..)

		// 실제 한페이지에 뿌려질 리스트
		request.setAttribute("list", list);

		// 자기질문 삭제 표시
		// 즐겨찾기 표시
		HttpSession session = request.getSession(false); // false세션정보 없으면 만들지 않음
		if (session != null) {
			request.setAttribute("loginUser", session.getAttribute("loginUser"));
		}
		// 테스트
		Customer loginUser = new Customer();
		loginUser.setCustomerID("kim");
		request.setAttribute("loginUser", loginUser);

		//
		request.getRequestDispatcher("/views/questionList.jsp").forward(request, response);
	}

	// 면접질문 검색
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
