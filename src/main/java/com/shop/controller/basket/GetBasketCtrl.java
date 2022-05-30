package com.shop.controller.basket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetBasketCtrl")
public class GetBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBasketCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getBasketList.jsp에서 해당 상품의 장바구니번호를 전달받아 변수에 저장
		//int bno = Integer.parseInt(request.getParameter("bno"));
		
		//BasketDAO 객체인 dao를 생성한 후 해당 메서드인 getBasket()를 호출하여 매개값 bno를 전달한 BasketVO를 받음
		//BasketDAO dao = new BasketDAO();
		//BasketVO basket = dao.getBasket(bno);
		
		//전달받은 basket을 getBasket.jsp로 전달
		
	}

}
