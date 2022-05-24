<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
#lst_tb { width:700px; margin:0 auto; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<%-- <c:if test="${empty name }"><c:redirect url="../member/login.jsp" /></c:if> --%>
<div id="content" class="panel-body">
	<div>
		<%-- <h3>${name }님 &nbsp; &nbsp; <a href="../LogoutCtrl">로그아웃</a></h3> --%>
	</div>
	<h2>글 목록</h2>
	<form method="post" action="../GetBoardSearchCtrl">
		<table class="table" id="search_tb">
			<tr>
				<td>
					<select name="searchCondtion">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchKeyword" />
					<input type="submit" value="검색" />
				</td>
			</tr>
		</table>
	</form>
	<table class="table" id="lst_tb">
		<thead>
			<tr>
				<th class="item1">번호</th>
				<th class="item2">제목</th>
				<th class="item3">작성자</th>
				<th class="item4">작성일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="vo" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="../GetBoardCtrl?num=${vo.no }">${vo.title }</a></td>
				<td>${vo.name }</td>
				<td>${vo.regdate }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4"><a href="addBoardForm.jsp">글 등록</a></td>
			</tr>	
		</tbody>
	</table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>