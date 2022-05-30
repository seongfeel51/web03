<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="fMgr" class="com.shop.biz.FileUploadMgr" />
<%
	request.setCharacterEncoding("UTF-8");
	String[] lists = fMgr.fileList();
%>
<h2>fileList.jsp</h2>
<table width="300" border="1">
	<tr>
		<td>순번</td>
		<td>파일명</td>
	</tr>
	<%
		for(int i =0; i<lists.length; i++) {
	%>
	<tr>
		<td width="20"><%=i+1%></td>
		<td><b><%=lists[i]%><b/></td>
	</tr>	
	<%		
		}
	%>
</table><p/>
<a href="fileSelect2.jsp">POST</a>