
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- link  -->
	<%@ include file="/resources/static/jsp/link.jsp" %>
	
	<!-- common.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/common.css" />
	
	<!-- common.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/common.js" defer></script>
	
	<!-- book/list.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/book/list.css" />

</head>
<body>
 <div class="wrapper">
 	<header>
 		<div class="top-header"></div>
 		<nav></nav>
 	</header>
 	<main>
 	<section class="show-block">
		<table class=table>
			<tr>
				<td>ROOMID</td>
				<td>USERID</td>
				<td>reservation_type</td>
				<td>CHECKIN</td>
				<td>CHECKOUT</td>
			</tr>
		<c:forEach  var="ReservationDto" items="${list}" varStatus="status">    		
			<tr>	
				<td>${ReservationDto.room_info_id}</td>
				<td>${ReservationDto.user_id}</td>
				<td>${ReservationDto.reservation_type}</td>
				<td>${ReservationDto.checkIn}</td>
				<td>${ReservationDto.checkOut}</td>
			</tr>          		
		</c:forEach>		
		</table>      
	</section>
	</main>
 	<footer></footer>
 </div>
</body>
</html>