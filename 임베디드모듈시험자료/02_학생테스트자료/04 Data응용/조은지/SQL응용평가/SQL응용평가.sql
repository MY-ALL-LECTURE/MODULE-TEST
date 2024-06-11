-- 1 [문제] 다음과 같은 결과물이 나오는 SQL쿼리문을 완성하세요
-- - inner join을 사용합니다.
-- - tbl_current_lecture , tbl_classroom , tbl_lecture, tbl_teacher을 조인하세요
use lmsdb;
select no, lec_duration, lec_time, t_name, lec_name, CR.class_no
from tbl_current_lecture CL
 inner join tbl_classroom CR
 on CL.class_no=CR.class_no
 inner join tbl_teacher T
 on CL.t_id=T.t_id
 inner join tbl_lecture L
 on CL.lec_code=L.lec_code;
 
 
--  2 [문제] 위 join 결과를 완성하는 view table을 만드세요
-- - view명은 반드시 view_current_lecture 로 지정합니다.
create or replace view view_current_lecture
as
select no, lec_duration, lec_time, t_name, lec_name, CR.class_no
from tbl_current_lecture CL
 inner join tbl_classroom CR
 on CL.class_no=CR.class_no
 inner join tbl_teacher T
 on CL.t_id=T.t_id
 inner join tbl_lecture L
 on CL.lec_code=L.lec_code;
 
select * from view_current_lecture;


-- 3 [문제] 다음을 만족하는 피벗SQL문을 완성하세요
-- - 맨 하단에 총합계도 구합니다(with rollup)
select lec_name,
sum(if(lec_time='09:00 - 12:00', 1, 0)) as '09:00 - 12:00',
sum(if(lec_time='13:00 - 15:00', 1, 0)) as '13:00 - 15:00',
sum(if(lec_time='15:00 - 17:00', 1, 0)) as '15:00 - 17:00'
from view_current_lecture group by lec_name with rollup;


-- 4 [문제] tbl_registration에 에러가 발생하면 다음과 같에 tbl_errlog에 저장될 수 있도록 하는
-- 프로시저를 만드세요.
-- - 프로시저명은 반드시 
-- - proc_insert_tbl_registration(in sid varchar(45), in lcode int, lduration varchar(100)) 로합니다.
delimiter $$
create procedure proc_insert_tbl_registration(in sid varchar(45), in lcode int, lduration varchar(100))
begin
	declare error_code varchar(5);
    declare error_message varchar(255);
	
    declare continue handler for SQLEXCEPTION
    begin
		show errors;
        get diagnostics condition 1
			error_code = mysql_errno,
			error_message = message_text;
        insert into tbl_errlog values (no, error_code, now(), error_message);
	end;
	
	insert into tbl_registration values(sid,lcode,lduration);
    select * from tbl_errlog;
end $$
delimiter ;

call proc_insert_tbl_registration('20190001',1001,'2023-05-22 - 2023-06-21');
call proc_insert_tbl_registration('20190001',1001,'2023-05-22 - 2023-06-21');
call proc_insert_tbl_registration('20190001',7001,'2023-05-22 - 2023-06-21');
call proc_insert_tbl_registration('70190001',1001,'2023-05-22 - 2023-06-21');

select * from tbl_registration;
select * from tbl_student;
select * from tbl_errlog;	



-- 5 [문제] tbl_student update시 tbl_student_bak에 이전데이터 삽입 트리거를 만드세요
-- 트리거명 : tbl_student_update_trg (이름 다르면 감점처리)
delimiter $$
create trigger tbl_student_update_trg
after update
on tbl_student
for each row
begin
	insert into tbl_student_bak values(
    old.s_id,old.s_name,old.s_phone,now(), null);
end $$
delimiter ;

insert into tbl_student values('20191234', '나나나', '010-1234-1234');
update tbl_student set s_name = '우우우' where s_id = '20191234';
select * from tbl_student;
select * from tbl_student_bak;


-- 6 [문제] tbl_teacher update시 tbl_teacher_bak에 이전데이터 삽입 트리거를 만드세요
-- 트리거명 : tbl_teacher_update_trg (이름 다르면 감점처리)
delimiter $$
create trigger tbl_teacher_update_trg
after update
on tbl_teacher
for each row
begin
	insert into tbl_teacher_bak values(
    old.t_id,old.t_name,old.t_phone,old.t_addr,now(), null);
end $$
delimiter ;

insert into tbl_teacher values(7, '아무개', '010-222-333', '대구광역시 달서구');
update tbl_teacher set t_name = '아무무' where t_id = 7;
update tbl_teacher set t_phone = '010-777-7777' where t_id = 7;
select * from tbl_teacher;
select * from tbl_teacher_bak;




-- 7 [문제] tbl_student delete시 tbl_student_bak에 이전데이터 삽입 트리거를 만드세요
-- 트리거명 : tbl_student_delete_trg (이름 다르면 감점처리)
delimiter $$
create trigger tbl_student_delete_trg 
after delete
on tbl_student
for each row
begin
	insert into tbl_student_bak values(
    old.s_id,old.s_name,old.s_phone, null, now());
end $$
delimiter ;

delete from tbl_student  where s_id = '20191234';
select * from tbl_student_bak;


-- 8 [문제] tbl_teacher delete시 tbl_teacher_bak에 이전데이터 삽입 트리거를 만드세요
-- 트리거명 : tbl_teacher_delete_trg (이름 다르면 감점처리)
delimiter $$
create trigger tbl_teacher_delete_trg
after delete
on tbl_teacher
for each row
begin
	insert into tbl_teacher_bak values(
    old.t_id,old.t_name,old.t_phone,old.t_addr,null, now());
end $$
delimiter ;

delete from tbl_teacher where t_id=7;
select * from tbl_teacher;
select * from tbl_teacher_bak;