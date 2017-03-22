package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobmate.domain.Customer;
import jobmate.domain.Introduce;
import jobmate.domain.IntroduceCategory;
import jobmate.service.CustomerService;
import jobmate.service.IntroduceService;
import jobmate.service.logic.CustomerServiceLogic;
import jobmate.service.logic.IntroduceServiceLogic;

@WebServlet("/introduce/update.do")
public class IntroduceUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntroduceService service = new IntroduceServiceLogic();
		Introduce introduce = null;
		int introduceNo = Integer.parseInt(request.getParameter("introduceNo"));
		introduce = service.findbyIntroduceNo(introduceNo);
		
		request.setAttribute("introduce", introduce);
		
		request.getRequestDispatcher("/views/introduceUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntroduceService service = new IntroduceServiceLogic();
		CustomerService cusService = new CustomerServiceLogic();
		
		int introduceNo = Integer.parseInt(request.getParameter("introduceNo"));
		
//		HttpSession session = request.getSession();
//		session.getAttribute(customerID);
		Customer customer = cusService.findByID("choi");
		
		String category = request.getParameter("select");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		if (category.equals("custom")) {
			title = request.getParameter("title");
		}
		IntroduceCategory cate = null;

		Introduce introduce = service.findbyIntroduceNo(introduceNo);//수정할 자기소개서 찾음
		introduce.setCategory(cate.valueOf(category));//자기소개서 세팅
		introduce.setTitle(title);
		introduce.setContent(content);
		introduce.setCustomer(customer);
		service.modify(introduce);//자기소개서 수정

		
		
//		request.getRequestDispatcher("/introduce/list.do").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/introduce/list.do?customerID="+customer.getCustomerID());
	}

}
