<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>delete member</h2>
	<form action="${pageContext.request.contextPath}/member/logout" method="post">
    	<input type="submit" value="로그아웃" />
	</form>
	<form action="${pageContext.request.contextPath}/member/delete" method="post">
    	<input type="submit" value="회원 탈퇴" onclick="return confirm('정말로 계정을 삭제하시겠습니까?');" />
	</form>
</body>
</html>