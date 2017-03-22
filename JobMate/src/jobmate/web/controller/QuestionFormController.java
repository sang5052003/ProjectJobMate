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
import jobmate.domain.Question;
import jobmate.domain.QuestionCategory;
import jobmate.service.QuestionService;
import jobmate.service.logic.QuestionServiceLogic;

@WebServlet("/question/register.do")
public class QuestionFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//question
		String question = request.getParameter("question");
		
		//유효성 검사
		if(question.equals("")){
			
			//out.println("<script>alert('sName" + sName + "');</script>");
			response.sendRedirect(request.getContextPath() + "/question/list.do");
			return;
//			//현재 보던 페이지 기억
//			String pageNo = request.getParameter("curPageNum");
//			QuestionPageManager.getInstance().setCurPageNo(Integer.parseInt(pageNo));
//			
//			//
//			response.sendRedirect(request.getContextPath() + "/question/list.do");
		}
		
		//
		QuestionService service = new QuestionServiceLogic();
		
		
		// 
		Customer loginUser = null;
		HttpSession session = request.getSession(false); // false세션정보 없으면 만들지 않음
		if (session != null) {
			loginUser = (Customer)session.getAttribute("loginUser");
			request.setAttribute("loginUser", loginUser);
		}
		else{
			//로그인 페이지로 ㄱ
			//response.sendRedirect(request.getContextPath() + "/login.do");
		}
		// 테스트 삭제 요망, 나중에는 로그인한 세션정보로 할 것이므로..
		loginUser = new Customer();
		loginUser.setCustomerID("갓기");
		request.setAttribute("loginUser", loginUser);
		
		//
		Question q = new Question();
		
		String category = request.getParameter("selCategory");
		for(int i = 0; i < QuestionCategory.values().length; i++){
			if(category.equals(QuestionCategory.values()[i].toString())){
				q.setCategory(QuestionCategory.values()[i]);
				break;
			}
		}
		
		q.setCustomerID(loginUser.getCustomerID());
		q.setQuestion(question);
		
		service.create(q);
		
		//현재 보던 페이지 기억
		String pageNo = request.getParameter("curPageNum");
		QuestionPageManager.getInstance().setCurPageNo(Integer.parseInt(pageNo));
		
		//
		response.sendRedirect(request.getContextPath() + "/question/list.do");
	}

}
