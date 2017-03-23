package jobmate.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.service.ScrapService;
import jobmate.service.logic.ScrapServiceLogic;


@WebServlet("/myScrap/register.do")
public class MyRecruitRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScrapService service = new ScrapServiceLogic();
		HttpSession session = request.getSession();
		
		
		String recruitID =request.getParameter("recruitID");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		
		System.out.println(recruitID);
		String customerID = "박막내";
		service.createMyRecruit(recruitID, name, title, customerID);
		
		
		String url = request.getHeader("referer");
		
		
		response.sendRedirect(url);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
