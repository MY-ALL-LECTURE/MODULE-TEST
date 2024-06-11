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
                        <input type="hidden" name="room_info_id" value="${reservationDto.room_info_id}" /> <!-- ���� ID�� ���� ���� -->
                        <input type="hidden" name="user_id" value="${reservationDto.user_id}" />
                        <p>������ �����Ͻðڽ��ϱ�?</p>
                    </div>              
                    <div>
                        <button class="btn btn-danger m-3" id="deleteButton">���� ����</button>         
                        <a class="btn btn-secondary m-3" href="${pageContext.request.contextPath}/reserv/list">��������</a>
                    </div>                              
                </form>
            </section>

        </div>            
    </div>
    
    <script>
        document.getElementById("deleteButton").addEventListener("click", function() {
            // ���� ���� ��ư�� Ŭ������ �� ����� �ڵ�
            var confirmation = confirm("������ �����Ͻðڽ��ϱ�?");

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