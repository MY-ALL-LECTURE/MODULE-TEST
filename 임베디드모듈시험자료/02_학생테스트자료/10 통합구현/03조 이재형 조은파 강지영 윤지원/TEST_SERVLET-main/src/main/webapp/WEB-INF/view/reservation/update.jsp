<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>UPDATE</h1>
	<div class="main-block">
				<aside class="left"></aside>
				<div class="right">
				           ${reservationDto}<br>
		            <section>
		            	<form action="${pageContext.request.contextPath}/reserv/update" method="post" class="w-100 m-3">
		            		<div>
		            			<input type="text" name="room_info_id"  value="${reservationDto.room_info_id}" placeholder="객실정보"  class="form-control m-3"  readonly />
		            		</div>  		
		            		<div>
		            			<input type="text" name="user_id" value="${reservationDto.user_id}" placeholder="예약자" class="form-control m-3" />
		            		</div>
		            		<div>
		            			<input type="text" name="room_type" value="${reservationDto.room_type}" placeholder="대실/숙박" class="form-control m-3" />
		            		</div>
		             		<div>
		            			<input type="text" name="check_in" value="${reservationDto.check_in}" placeholder="체크인" class="form-control m-3" />
		            		</div>           		
		             		<div>
		            			<input type="text" name="check_out" value="${reservationDto.check_out}" placeholder="체크아웃" class="form-control m-3" />
		            		</div>    
		             		<div>
		            			<button class="btn btn-secondary m-3">예약수정</button>			
		            			<a class="btn btn-secondary m-3" href="${pageContext.request.contextPath}/reserv/list?room_info_id=${reservationDto.room_info_id}&user_id=${reservationDto.user_id}">이전으로</a>
		            		</div>            				
		            	</form>
		            </section>

				</div>            
            </div>
</body>
</html>