package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String content = request.getParameter("name");
		System.out.println("aa");
		Reply reply = new Reply();
		reply.setContent(content);
		reply.setCustomerID("갓기"); //세션에서 아이디를 가져옴
		Question question = new Question();
		question.setQuestionNo(1);
		reply.setQuestion(question); // 질문을 파라미터로 받아서 넣어줌

		service.create(reply);
//		if(service.create(reply)){ // 성공하면 실패하면 
			response.sendRedirect(request.getContextPath() +"/question/detail.do");
//		}
		

	}

}
