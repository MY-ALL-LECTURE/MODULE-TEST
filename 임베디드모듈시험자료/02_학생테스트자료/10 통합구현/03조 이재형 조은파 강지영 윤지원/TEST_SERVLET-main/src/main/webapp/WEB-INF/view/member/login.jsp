<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
    <form action="${pageContext.request.contextPath}/member/login" method="post"> <!-- 'register'는 이 폼 데이터를 처리할 서블릿의 URL로 설정하세요 -->

        <label for="username">사용자 이름:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>

        <button type="submit">등록</button>
    </form>
</body>
</html>