package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.common.utill.QuestionPageManager;
import jobmate.domain.Customer;
import jobmate.service.QuestionService;
import jobmate.service.logic.QuestionServiceLogic;

@WebServlet("/question/delete.do")
public class QuestionDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		Customer loginUser = null;
		HttpSession session = request.getSession(false); // false세션정보 없으면 만들지 않음
		if (session != null) {
			loginUser = (Customer) session.getAttribute("loginUser");
		} else {
			// 로그인 페이지로 ㄱ
			// response.sendRedirect(request.getContextPath() + "/login.do");
		}
		
		//삭제할 질문의 아이디넘버
		String no = request.getParameter("questionNo");
		
		QuestionService service = new QuestionServiceLogic();
		service.remove(Integer.parseInt(no));
		
		//삭제시 몇페이지 였는지 기억
		String pageNo = request.getParameter("curPageNum");
		QuestionPageManager.getInstance().setCurPageNo(Integer.parseInt(pageNo));
		
		response.sendRedirect(request.getContextPath() + "/question/list.do");
		
		//request.getRequestDispatcher("/question/list.do").forward(request, response);
	}

}
