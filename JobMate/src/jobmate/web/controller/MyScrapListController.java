package jobmate.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobmate.domain.Question;
import jobmate.domain.Recruit;
import jobmate.service.ScrapService;
import jobmate.service.logic.ScrapServiceLogic;

/**
 * Servlet implementation class MyRecruitListController
 */
@WebServlet("/myScrap/myList.do")
public class MyScrapListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String customerID = request.getParameter("");
		
		ScrapService service = new ScrapServiceLogic();
		
		String customerID="박막내";
		
		List<Recruit> list = service.findMyRecruitByCustomerID(customerID);
		List<Question> qlist = service.findMyQuestionByCustomerID(customerID);
		
		request.setAttribute("list", list);
		request.setAttribute("qlist", qlist);
		request.getRequestDispatcher("/views/myScrap.jsp").forward(request, response);
		
		
	}

}
