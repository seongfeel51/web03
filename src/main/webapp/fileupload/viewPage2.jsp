<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="fMgr" class="com.shop.biz.FileUploadMgr" />
<%
	request.setCharacterEncoding("UTF-8");
	boolean result = fMgr.fileUpload(request);
	String url = "fileSelect2.jsp";
	String msg = "파일 업로더 실패.";
	if(result) {
		url="fileList.jsp";
		msg = "파일 업로더 성공";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
