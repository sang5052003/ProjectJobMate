package jobmate.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobmate.service.ReplyService;
import jobmate.service.logic.ReplyServiceLogic;

@WebServlet("/reply/delete.do")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReplyService service = new ReplyServiceLogic();

		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));

		if (service.remove(replyNo)) {
			response.sendRedirect(request.getContextPath() + "/question/detail.do?questionNo=" + questionNo);
		} else {
			System.out.println("삭제 실패하였습니다.");
		}
	}

}
