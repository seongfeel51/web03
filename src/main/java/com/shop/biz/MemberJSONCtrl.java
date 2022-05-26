package com.shop.biz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

import net.sf.json.JSONObject;

@WebServlet("/MemberJSONCtrl")
public class MemberJSONCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberJSONCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> memberList = null;
		memberList = dao.JSONMemberList();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberList);
		JSONObject json = new JSONObject();
		json.putAll(map);
		out.println(json);
		//	dao			ctrl		jsp
		//vo -> list -> map -> json -> view
	}
}