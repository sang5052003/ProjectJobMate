package jobmate.web.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/question/detail.do")
public class QuestionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService service;
	private QuestionService questionService;

	public QuestionDetailController() {
		questionService = new QuestionServiceLogic();
		service = new ReplyServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int questionNo = 1;// Integer.parseInt(request.getParameter("")); // 여기서
							// 질문번호 받아와서 뿌려주기

		Question question = questionService.findByQuestionNo(questionNo);

		request.setAttribute("question", question);

		request.getRequestDispatcher("/views/questionDetail.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}

}
