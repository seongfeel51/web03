package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;

@WebServlet("/EditBoardCtrl")
public class EditBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditBoardCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setName(name);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.editBoard(vo);
		if(cnt>0) {  //글 수정 성공
			response.sendRedirect("GetBoardListCtrl");
		} else {  //글 수정 실패
			response.sendRedirect("GetBoardCtrl?num="+no);
		}	
	}

}
