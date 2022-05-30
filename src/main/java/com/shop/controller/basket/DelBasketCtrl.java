package com.shop.controller.basket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DelBasketCtrl")
public class DelBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelBasketCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getBasket.jsp 에서 보내온 bno를 매개값으로 받아 변수에 저장
		//int bno = Integer.parseInt(request.getParameter("bno"));
		
		//BasketDAO 객체인 dao를 생성하여 delBasket() 메서드로 호출하여 매개값 bno를 전달한 후 cnt를 결과를 반환 받음
		//BasketDAO dao = new BasketDAO();
		//int cnt = dao.delBasket(bno);
	
		//cnt처리건수를 파악하여 제대로 처리되었는지 판단하여 해당 페이지로 이동
		//if(cnt > 0) {
			//response.sendRedirect("이동할 주소");
		//} else {
			//response.sendRedirect("이동할 주소");
		//}
		
	}
}