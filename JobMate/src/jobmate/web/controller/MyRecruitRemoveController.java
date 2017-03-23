package jobmate.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobmate.domain.Recruit;
import jobmate.service.ScrapService;
import jobmate.service.logic.ScrapServiceLogic;

/**
 * Servlet implementation class MyRecruitRemoveController
 */
@WebServlet("/myScrap/remove.do")
public class MyRecruitRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScrapService service = new ScrapServiceLogic();
		String customerID= "박막내";
		
		String recruitID =request.getParameter("recruitID");
		service.removeMyRecruit(recruitID, customerID);
		
		List<Recruit> list = service.findMyRecruitByCustomerID(customerID);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/myScrap.jsp").forward(request, response);
	}

}
