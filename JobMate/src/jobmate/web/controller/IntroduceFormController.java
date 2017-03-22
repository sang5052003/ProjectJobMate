package jobmate.web.controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.domain.Customer;
import jobmate.domain.Introduce;
import jobmate.domain.IntroduceCategory;
import jobmate.service.CustomerService;
import jobmate.service.IntroduceService;
import jobmate.service.logic.CustomerServiceLogic;
import jobmate.service.logic.IntroduceServiceLogic;

@WebServlet("/introduce/form.do")
public class IntroduceFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntroduceService service = new IntroduceServiceLogic();
		CustomerService cusService = new CustomerServiceLogic();
		String customerID=null;
		HttpSession session = request.getSession();
		session.getAttribute(customerID);
		Customer customer= cusService.findByID("choi");
		String title=null;
		String category = request.getParameter("select");
		String content = request.getParameter("content");
		if(category.equals("custom")){
			title = request.getParameter("title");
		}else{
			title = category;
		}
		IntroduceCategory cate=null;
		
		Introduce introduce = new Introduce();
		introduce.setCategory(cate.valueOf(category));
		introduce.setTitle(title);
		introduce.setContent(content);
		introduce.setCustomer(customer);
		
		service.create(introduce);
		
		response.sendRedirect(request.getContextPath()+"/introduce/list.do");
	}
	
}
