package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.domain.Customer;
import jobmate.service.CustomerService;
import jobmate.service.IntroduceService;
import jobmate.service.logic.CustomerServiceLogic;
import jobmate.service.logic.IntroduceServiceLogic;

@WebServlet("/introduce/delete.do")
public class IntroduceDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntroduceService service = new IntroduceServiceLogic();
		CustomerService cusService = new CustomerServiceLogic();
		 
		HttpSession session = request.getSession();
		String customerID = (String)session.getAttribute("customerID");
		Customer customer = cusService.findByID("choi");  //세션없어서 테스트를 위함
		
		int introduceNo = Integer.parseInt(request.getParameter("introduceNo"));
		
		service.remove(introduceNo);
		
		response.sendRedirect(request.getContextPath() + "/introduce/list.do?customerID="+customer.getCustomerID());
	}

}
