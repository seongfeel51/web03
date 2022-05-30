package com.shop.controller.goods;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String gcategory = request.getParameter("gcategory");
		String gname = request.getParameter("gname");
		int gprice = Integer.parseInt(request.getParameter("gprice"));
		String gcolor = request.getParameter("gcolor");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String gsize = request.getParameter("gsize");
		String gcontent = request.getParameter("gcontent");
		String gimage = request.getParameter("gimage");
		int best = Integer.parseInt(request.getParameter("best"));
		
		GoodsVO vo = new GoodsVO();
		vo.setGcategory(gcategory);
		vo.setGname(gname);
		vo.setGprice(gprice);
		vo.setGcolor(gcolor);
		vo.setAmount(amount);
		vo.setGcontent(gcontent);
		vo.setGimage(gimage);
		
		GoodsDAO dao = new GoodsDAO();
		int cnt = dao.addGoods(vo);
		if(cnt>0) {  //제품 등록 성공
			response.sendRedirect("GetGoodsListCtrl");
		} else {  //제품 등록 실패
			response.sendRedirect("./goods/addGoodsForm.jsp");
		}		
	}
}