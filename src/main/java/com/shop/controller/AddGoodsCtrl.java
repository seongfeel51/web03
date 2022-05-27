package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;

@WebServlet("/AddGoodsCtrl")
public class AddGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddGoodsCtrl() {
        super();
    }

	protected void Service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String gname = request.getParameter("gname");
		String gcategory = request.getParameter("gacategory");
		String gcontent = request.getParameter("gcontent");
		String gprice = request.getParameter("gprice");
		String gcolor = request.getParameter("gcolor");
		
		GoodsVO vo = new GoodsVO();
		vo.setGname(gname);
		vo.setGcategory(gcategory);
		vo.setGcontent(gcontent);
		vo.setGprice(0);
		vo.setGcolor(gcolor);
		
		GoodsDAO dao = new GoodsDAO();
		int cnt = dao.addGoods(vo);
		if(cnt>0) {  //글 등록 성공
			response.sendRedirect("GetGoodsListCtrl");
		} else {  //글 등록 실패
			response.sendRedirect("./board/addGoodsForm.jsp");
		}
	}
}
