package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobmate.domain.Introduce;
import jobmate.service.IntroduceService;
import jobmate.service.logic.IntroduceServiceLogic;

@WebServlet("/introduce/detail.do")
public class IntroduceDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntroduceService introduceService = new IntroduceServiceLogic();
		Introduce introduce = null;
		int introduceNo = Integer.parseInt(request.getParameter("introduceNo"));
		
		introduce = introduceService.findbyIntroduceNo(introduceNo);
		
		request.setAttribute("introduce", introduce);
		request.getRequestDispatcher("/views/introduceDetail.jsp").forward(request, response);
	}

}
