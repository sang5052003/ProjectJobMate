package jobmate.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobmate.domain.Reply;
import jobmate.service.ReplyService;
import jobmate.service.logic.ReplyServiceLogic;

@WebServlet("/reply/update.do")
public class ReplyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService service;

	public ReplyUpdateController() {
		service = new ReplyServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));

		Reply reply = service.findReply(replyNo);

		request.setAttribute("reply", reply);

		request.getRequestDispatcher("/views/replyModify.jsp").forward(request, response);
		// service.modify(reply);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String content = request.getParameter("content");

		System.out.println(replyNo);
		System.out.println(content);

		Reply reply = service.findReply(replyNo);
		reply.setContent(content);

		boolean result = service.modify(reply);

		PrintWriter out = response.getWriter();

		// 정상적으로 댓글을 수정했을경우 1을 전달한다.
		if (result)
			out.println("1");

		out.close();

		// response.sendRedirect(
		// request.getContextPath() + "/question/detail.do?questionNo=" +
		// reply.getQuestion().getQuestionNo());

	}

}
