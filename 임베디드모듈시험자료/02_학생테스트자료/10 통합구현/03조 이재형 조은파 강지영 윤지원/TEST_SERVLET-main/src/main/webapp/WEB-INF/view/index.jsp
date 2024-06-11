<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>INDEX</h1>
	<h2>MEMBER</h2>
	<div><a href="${pageContext.request.contextPath}/member/register">회원가입</a>구현</div>
	<div><a href="${pageContext.request.contextPath}/member/selectAll">회원목록조회</a> 구현</div>
	<div><a href="${pageContext.request.contextPath}/member/select">회원상세정보</a> 미구현</div>
	<div><a href="${pageContext.request.contextPath}/member/update">회원정보수정</a> 미구현</div>
	<div><a href="${pageContext.request.contextPath}/member/login">로그인</a> 구현</div>
	<div><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a> 미구현</div>
	<h2>RSERVATION</h2>
	<div><a href="${pageContext.request.contextPath}/reservation/select">예약조회</a> 미구현</div>
	<div><a href="${pageContext.request.contextPath}/reservation/selectAll">전체예약조회</a> 미구현</div>
	<div><a href="${pageContext.request.contextPath}/reservation/update">예약수정</a> 미구현</div>
	<div><a href="${pageContext.request.contextPath}/reservation/delete">예약삭제</a> 미구현</div>
	<div><a href="${pageContext.request.contextPath}/reservation/insert">예약추가</a> 구현</div>
</body>
</html>