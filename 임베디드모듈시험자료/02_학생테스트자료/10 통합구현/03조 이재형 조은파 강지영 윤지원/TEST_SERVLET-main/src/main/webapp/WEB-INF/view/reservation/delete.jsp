<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <h1>DELETE</h1>
    <div class="main-block">
        <aside class="left"></aside>
        <div class="right">
            ${reservationDto}<br>
            <section>
                <form action="${pageContext.request.contextPath}/reserv/delete" method="post" class="w-100 m-3">
                    <div>
                        <input type="hidden" name="room_info_id" value="${reservationDto.room_info_id}" /> <!-- 예약 ID를 숨겨 전달 -->
                        <input type="hidden" name="user_id" value="${reservationDto.user_id}" />
                        <p>예약을 삭제하시겠습니까?</p>
                    </div>              
                    <div>
                        <button class="btn btn-danger m-3" id="deleteButton">예약 삭제</button>         
                        <a class="btn btn-secondary m-3" href="${pageContext.request.contextPath}/reserv/list">이전으로</a>
                    </div>                              
                </form>
            </section>

        </div>            
    </div>
    
    <script>
        document.getElementById("deleteButton").addEventListener("click", function() {
            // 예약 삭제 버튼을 클릭했을 때 실행될 코드
            var confirmation = confirm("정말로 삭제하시겠습니까?");

            if (confirmation) { 
                
                var reservationId = "${reservationDto.user_id}";
                
                var deletePath = "${pageContext.request.contextPath}/reserv/list?user_id=" + reservationId;
 
                window.location.href = deletePath;
            } else {
      
            }
        });
    </script>
</body>
</html>