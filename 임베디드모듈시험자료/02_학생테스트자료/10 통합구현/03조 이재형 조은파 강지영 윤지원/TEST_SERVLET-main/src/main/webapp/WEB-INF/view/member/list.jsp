<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>회원 목록 페이지</div>
	<form action="${pageContext.request.contextPath}/member/selectAll" method="post">      
            <section class="show-block">
            	<table class=table>
            		<tr>
            			<td>REALNAME</td>
            			<td>USERNAME</td>
            			<td>PHONE</td>
            			<td>EMAIL</td>
            			<td>DETAIL</td>
            		</tr>
            		
            		<c:forEach var="memberDto"	items="${list}" varStatus="status">    		
		            	<tr>	
							<td>${memberDto.realname}</td>
							<td>${memberDto.username}</td>
							<td>${memberDto.phone}</td>
							<td>${memberDto.email}</td>
							<td><a href="/WEB-INF/views/member/read.jsp">상세</a></td>
						</tr>          		
            		</c:forEach>

									
            	</table>      
            </section>
    </form>
</body>
</html>