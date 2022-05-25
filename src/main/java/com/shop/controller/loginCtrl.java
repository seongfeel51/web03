package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/loginCtrl")
public class loginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		int cnt = dao.login(vo);
		HttpSession session = request.getSession();
		if(cnt>0) {
			session.setAttribute("sid", id);
			session.setAttribute("name", "사용자");
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("./member/login.jsp");
		}
	}
}