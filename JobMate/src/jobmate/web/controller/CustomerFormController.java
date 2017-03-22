package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobmate.domain.Customer;
import jobmate.service.CustomerService;
import jobmate.service.logic.CustomerServiceLogic;

@WebServlet("/customer/form.do")
public class CustomerFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService service = new CustomerServiceLogic();
		
		String customerID = request.getParameter("customerID");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		String name = request.getParameter("name");
		
		Customer customer = new Customer();
		customer.setPassword(password);
		customer.setCustomerID(customerID);
		customer.setName(name);
		service.create(customer);
		
		response.sendRedirect(request.getContextPath()+"/login.do");
	}

}
