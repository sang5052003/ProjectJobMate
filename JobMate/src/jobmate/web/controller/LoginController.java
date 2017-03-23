package jobmate.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.common.exception.JMRuntimeException;
import jobmate.domain.Customer;
import jobmate.service.CustomerService;
import jobmate.service.logic.CustomerServiceLogic;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/views/index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerID = request.getParameter("customerID");
		String password = request.getParameter("password");
		
		System.out.println(customerID);

		CustomerService service = new CustomerServiceLogic();
		Customer customer = service.findByID(customerID);

		if (customer != null && customerID.equals(customer.getCustomerID())) {
			HttpSession session = request.getSession(); // 세션은 설정 해줄 수 있음 타이머
			session.setAttribute("loginUser", customerID);
			System.out.println(customerID);
			response.sendRedirect(request.getContextPath() + "/main.do"); // 메인화면으로

		} else {
			HttpSession session = request.getSession(false); //
			if (session != null) {
				session.invalidate();
			}
			throw new JMRuntimeException("로그인 정보를 확인하세요");

		}

	}

}
