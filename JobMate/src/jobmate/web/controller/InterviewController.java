package jobmate.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.domain.Question;
import jobmate.service.InterviewService;
import jobmate.service.logic.InterviewServiceLogic;

@WebServlet("/interview.do")
public class InterviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InterviewService service = new InterviewServiceLogic();

		String category = request.getParameter("category");
		int count = Integer.parseInt(request.getParameter("count"));
		
		System.out.println(category);

		System.out.println(count);

		HttpSession session = request.getSession();

		List<Question> list = null;

		if (category.equals("myQuestion")) {
			list = service.findMyQuestionByCustomerID((String) session.getAttribute("loginedUser"));
		} else {
			list = service.findByInterview(category);
		}

		
		Random random = new Random();
		List<Question> randomQuestion = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			randomQuestion.add(list.get(random.nextInt(list.size() - 1)));
		}

		request.setAttribute("randomQuestion", randomQuestion);
		request.getRequestDispatcher("/views/interview.jsp").forward(request, response);

	}

}
