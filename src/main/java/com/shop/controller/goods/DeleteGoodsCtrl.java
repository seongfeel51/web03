package com.shop.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteGoodsCtrl")
public class DeleteGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteGoodsCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
