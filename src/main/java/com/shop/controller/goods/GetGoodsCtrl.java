package com.shop.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/GetGoodsCtrl")
public class GetGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetGoodsCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int gno = Integer.parseInt(request.getParameter("gno"));
		GoodsDAO dao = new GoodsDAO();
		GoodsVO goods = new GoodsVO();
		goods = dao.getGoods(gno);
		if(goods != null) {
			request.setAttribute("goods", goods);
			RequestDispatcher view = request.getRequestDispatcher("./goods/getGoods.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetGoodsListCtrl");
		}
	}
}