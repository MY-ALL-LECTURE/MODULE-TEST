<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 등록</h2>
    <form action="${pageContext.request.contextPath}/member/register" method="post"> <!-- 'register'는 이 폼 데이터를 처리할 서블릿의 URL로 설정하세요 -->
        <label for="realname">실명:</label>
        <input type="text" id="realname" name="realname" required><br>

        <label for="birth">생년월일:</label>
        <input type="date" id="birth" name="birth" required><br>

        <label for="gender">성별:</label>
        <input type="radio" id="male" name="gender" value="true">남성
        <input type="radio" id="female" name="gender" value="false">여성<br>

        <label for="phone">전화번호:</label>
        <input type="text" id="phone" name="phone" required><br>

        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="username">사용자 이름:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="confrimPassword">비밀번호 확인:</label>
        <input type="password" id="confrimPassword" name="confrimPassword" required><br>

        <button type="submit">등록</button>
    </form>
</body>
</html>