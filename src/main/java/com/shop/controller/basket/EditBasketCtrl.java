package com.shop.controller.basket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditBasketCtrl")
public class EditBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditBasketCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getGoods.jsp에서 보내온 bno, gno, gcolor, amount, gsize 를 getParameter로 가져와 해당 변수에 저장
		
		//BasketVO의 객체 vo를 생성하여 bno, gno, gcolor, amount, gsize를 vo에 저장
		
		//BasketDAO의 객체 dao를 생성하여 addBasket()을 호출하면서 vo를 전달한 후 cnt를 결과로 받음 
		//int cnt = dao.editBasket(vo)
		
		//이동할 주소 지정 -> response.sendRedirect("");
	}

}
