package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.domain.Question;
import jobmate.domain.Reply;
import jobmate.service.QuestionService;
import jobmate.service.ReplyService;
import jobmate.service.logic.QuestionServiceLogic;
import jobmate.service.logic.ReplyServiceLogic;

@WebServlet("/reply/register.do")
public class ReplyRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReplyService service = new ReplyServiceLogic();
		QuestionService questionService = new QuestionServiceLogic();

		int questionNo = Integer.parseInt(request.getParameter("questionNo"));

		String content = request.getParameter("name");

		if (content != "") {
			System.out.println(questionNo);
			System.out.println(content);
			Reply reply = new Reply();
			reply.setContent(content);
			
			
			HttpSession session = request.getSession();

			reply.setCustomerID(session.getAttribute("loginUser").toString()); // 세션에서
																				// 아이디를
																				// 가져옴

			Question question = questionService.findByQuestionNo(questionNo); // 넘버로

			reply.setQuestion(question); // 질문을 파라미터로 받아서 넣어줌
			service.create(reply);

		}
		response.sendRedirect(request.getContextPath() + "/question/detail.do?questionNo=" + questionNo); // 디테일

	}

}
