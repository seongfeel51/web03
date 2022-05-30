package com.shop.controller.basket;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BasketVO;
import com.shop.model.BasketDAO;

@WebServlet("/GetBasketListCtrl")
public class GetBasketListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBasketListCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당 페이지로 부터 userid를 매개변수로 받아 변수에 저장
		//String userid = request.getParameter("userid");
		
		//BasketDAO 객체 dao를 생성하여 getBasketList()에 userid를 매개변수로 전달하여 해당 회원의 장바구니 목록을 반환 받음
		//BasketDAO dao = new BasketDAO();
		//ArrayList<BasketVO> basketList = dao.getBasketList(userid);
		
		//결과로 반환받은 장바구니 목록을 getBasketList.jsp로 전달	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userid = request.getParameter("userid");
		BasketDAO dao = new BasketDAO();
		ArrayList<BasketVO> list = dao.getBasketList(userid);
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("./basket/getBasketList.jsp");
		view.forward(request, response);

	}	
}