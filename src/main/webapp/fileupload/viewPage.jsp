<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	request.setCharacterEncoding("UTF-8");
	String saveFolder = "D:/kim3/jsp1/web03/src/main/webapp/upload";
	String encType = "UTF-8";
	int maxSize = 10 * 1024 * 1024;	// 10MB
	try {
		MultipartRequest multi = new MultipartRequest(request,
				saveFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		out.println("user:" + multi.getParameter("user")+"<br/>");
		out.println("title: " + multi.getParameter("title")+"<br/>");
		if (multi.getFilesystemName("uploadFile") != null) {
			String name = multi.getFilesystemName("uploadFile");
			out.println("파일명:");
			out.println(name + "<br>");
			File f = multi.getFile(name);
			out.println("파일크기:");
			out.println(multi.getFile("uploadFile").length()+"바이트<br/>");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>