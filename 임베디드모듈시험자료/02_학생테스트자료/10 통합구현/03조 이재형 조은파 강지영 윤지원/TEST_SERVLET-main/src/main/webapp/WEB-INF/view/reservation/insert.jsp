
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/reservation/insert" method="post">
		<div><input type="text" name="room_info_id" placeholder="room_info_id"  /></div>
		<div><input type="text" name="user_id" placeholder="user_id"  /></div>
		<div><input type="text" name="reservation_type" placeholder="reservation_type" /></div>
		<div><input type="datetime-local" name="checkIn" placeholder="체크인"  /></div>
		<div><input type="datetime-local" name="checkOut" placeholder="체크아웃"/></div>
		<button>예약하기</button>
	</form>
</body>
</html>