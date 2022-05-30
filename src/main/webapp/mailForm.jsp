<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>메인</title>
<jsp:include page="common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="content" class="panel-body">
	<h2 class="page_tit">메일 보내기</h2>
	<form action="sendMail.jsp" method="post">
		<table class="table" id="form_table">
			<tr><th colspan="2">메일 보내기</th></tr>
			<tr><td>from</td><td><input type="text" name="from" /></td></tr>
			<tr><td>to</td><td><input type="text" name="to" /></td></tr>
			<tr><td>subject</td><td><input type="text" name="subject" /></td></tr>
			<tr><td>content</td><td><textarea name="content" style="width:170px; height:200px;"></textarea></td></tr>
			<tr><td colspan="2" style="text-align:right;"><input type="submit" value="메일 보내기"/ class="button is-info"></td></tr>
		</table>
	</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>