package kh.s14.wanted.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s14.wanted.member.model.MemberService;
import kh.s14.wanted.member.model.MemberVo;

/**
 * Servlet implementation class LoginDoController
 */
@WebServlet("/login.do")
public class LoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginDoController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");

		System.out.println(mid);
		System.out.println(mpw);

		MemberService service = new MemberService();
		MemberVo loginInfo = service.login(mid, mpw);

		if (loginInfo != null) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("loginSsInfo", loginInfo);
			response.sendRedirect(request.getContextPath() + "/main");
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
			System.out.println("로그인 실패");
		}

	}
}
