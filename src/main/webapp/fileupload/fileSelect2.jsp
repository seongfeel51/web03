<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE>
<html>
<body>
	<h2>FileSelect2.jsp</h2>
	<form name="frmName" method="post" enctype="multipart/form-data"
		action="viewPage2.jsp">
		user<br /> <input type="text" name="user"><br /> title<br /> <input
			type="text" name="title"><br /> file<br /> <input type="file"
			name="uploadFile"><br /> <input type="submit" value="UPLOAD"><br />
	</form>
	<a href="fileList.jsp">LIST</a>
</body>
</html>