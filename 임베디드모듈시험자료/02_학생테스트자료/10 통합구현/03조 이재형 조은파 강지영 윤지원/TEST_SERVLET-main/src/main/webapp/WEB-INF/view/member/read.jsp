<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원상세</h2>
		<section class="show-block">
			<table class=table>
				<tr>
					<td>REALNAME</td>
					<td>USERNAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
				</tr>
				
				<c:forEach  var="memberDto"	items="${list}" varStatus="status">    		
			      	<tr>	
					<td>${memberDto.realname}</td>
					<td>${memberDto.username}</td>
					<td>${memberDto.phone}</td>
					<td>${memberDto.email}</td>
					</tr>          		
	      		</c:forEach>
					
	      	</table>    
      	   	<form action="${pageContext.request.contextPath}/member/update" method="post">     
		       <button type="submit">수정</button>
			</form>
		  	<form action="${pageContext.request.contextPath}/member/delete" method="post">     
		       <button type="submit">삭제</button>
			</form>  
        </section>


</body>
</html>