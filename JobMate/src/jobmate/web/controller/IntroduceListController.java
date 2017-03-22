package jobmate.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobmate.domain.Customer;
import jobmate.domain.Introduce;
import jobmate.service.CustomerService;
import jobmate.service.IntroduceService;
import jobmate.service.logic.CustomerServiceLogic;
import jobmate.service.logic.IntroduceServiceLogic;

@WebServlet("/introduce/list.do")
public class IntroduceListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntroduceService introduceService = new IntroduceServiceLogic();
		
		//HttpSession session = request.getSession();
		
		String customerID =request.getParameter("customerID");
		
		//System.out.println(customerID);
		List<Introduce> list = introduceService.findAllByCustomerID(customerID);
		//System.out.println(list.size());
		request.setAttribute("introduces", list);
		request.getRequestDispatcher("/views/introduceList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntroduceService service = new IntroduceServiceLogic();
		
//		HttpSession session = request.getSession();
//		String customerID = (String)session.getAttribute("customerID");
		String customerID =request.getParameter("customerID");//임시로 설정 로그인 이후  세션사용
		
		String title = request.getParameter("search");//search로 받아온거 타이틀 내용에 저장
		String content = request.getParameter("search");
		String searchBy = request.getParameter("select");
		
		if(searchBy.equals("제목")){
			List<Introduce> tList = service.findByTitle(customerID, title);
			request.setAttribute("tIntroduces", tList);  //타이틀 검색 리스트
		}else{
			List<Introduce> cList = service.findByContent(customerID, content);
			request.setAttribute("cIntroduces", cList);  //내용 검색 리스트
		}
		
		
		
		
		request.getRequestDispatcher("/views/introduceList.jsp").forward(request, response);
		
	}

}
