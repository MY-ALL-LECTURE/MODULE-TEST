use lmsdb;

select * from tbl_teacher;
select * from tbl_current_lecture;
select * from tbl_lecture;

-- 01
select CL.no, CL.lec_duration, CL.lec_time, T.t_name, L.lec_name, CR.class_no
from tbl_current_lecture CL
inner join tbl_classroom CR
inner join tbl_lecture L
inner join tbl_teacher T
on T.t_id = CL.t_id and L.lec_code = CL.lec_code;

-- 02
create or replace view view_current_lecture
as
select CL.no, CL.lec_duration, CL.lec_time, T.t_name, L.lec_name, CR.class_no
from tbl_current_lecture CL
inner join tbl_classroom CR
inner join tbl_lecture L
inner join tbl_teacher T
on L.lec_code = CL.lec_code;
select * from view_current_lecture;
desc view_current_lecture;

-- 03
use lmsdb;
select lec_name,
cast(sum(if(lec_time='09:00 - 12:00', 1, 0))/36 as signed integer) as '09:00 - 12:00',
cast(sum(if(lec_time='13:00 - 15:00', 1, 0))/36 as signed integer) as '13:00 - 15:00',
cast(sum(if(lec_time='15:00 - 17:00', 1, 0))/36 as signed integer) as '15:00 - 17:00'
from view_current_lecture group by lec_name with rollup;

-- 04
select * from tbl_errlog;
select * from tbl_registration;
drop procedure proc_insert_tbl_registration;
delimiter $$
create procedure proc_insert_tbl_registration(in sid varchar(45), in lcode int, in lduration varchar(100))
begin
		DECLARE error_code VARCHAR(5);
    DECLARE error_message VARCHAR(255);
	-- PK 중복 예외 처리
    declare continue handler for 1062 
    begin
		show errors;
		get DIAGNOSTICS CONDITION 1
			error_code = MYSQL_ERRNO,
            error_message = MESSAGE_TEXT;
		-- select error_code,error_message;
        insert into tbl_errlog(error_code, error_date, error_msg) values(error_code, curdate(),error_message);
    end;
    -- 잘못된 FK value
    declare continue handler for 1452
    begin
		show errors;
		get DIAGNOSTICS CONDITION 1
			error_code = MYSQL_ERRNO,
            error_message = MESSAGE_TEXT;
		-- select error_code,error_message;
        insert into tbl_errlog(error_code, error_date, error_msg) values(error_code, curdate(),error_message);
    end;
	insert into tbl_registration values(sid, lcode, lduration);
end $$
delimiter ;
-- 정상
call proc_insert_tbl_registration('20190001', 1001, '2023-05-22 - 2023-06-21');
-- [오류] PK 중복 (tbl_error에 오류 코드 삽입되어야 함)
call proc_insert_tbl_registration('20190001', 1001, '2023-05-22 - 2023-06-21');
-- [오류] 잘못된 lec_code (tbl_error에 오류 코드 삽입)
call proc_insert_tbl_registration('20190001', 7001, '2023-05-22 - 2023-06-21');
-- [오류] 잘못된 s_id (tbl_error에 오류 코드 삽입)
call proc_insert_tbl_registration('70190001', 1001, '2023-05-22 - 2023-06-21');
select * from tbl_errlog;

-- 05
desc tbl_student_bak;
drop trigger tbl_student_update_trg;
delimiter $$
create trigger tbl_student_update_trg
after update
on tbl_student
for each row
begin
	insert into tbl_student_bak values(
    old.s_id,old.s_name,old.s_phone, now(), null
    );
end $$
delimiter ;
insert into tbl_student values('20191234', '나나나','010-1234-1234');
update tbl_student set s_name='우우우' where s_id='20191234';
select * from tbl_student;
select * from tbl_student_bak;

-- 06
desc tbl_teacher_bak;
drop trigger tbl_teacher_update_trg;
delimiter $$
create trigger tbl_teacher_update_trg
after update
on tbl_teacher
for each row
begin
	insert into tbl_teacher_bak values(
    old.t_id,old.t_name,old.t_phone,old.t_addr, now(), null
    );
end $$
delimiter ;
insert into tbl_teacher values(7, '아무개', '010-222-333','대구광역시 달서구');
update tbl_teacher set t_name='아무무' where t_id=7;
update tbl_teacher set t_phone='010-777-7777' where t_id=7;
select * from tbl_teacher;
select * from tbl_teacher_bak;

-- 07
drop trigger tbl_student_delete_trg;
delimiter $$
create trigger tbl_student_delete_trg
after delete
on tbl_student
for each row
begin
	insert into tbl_student_bak values(
    old.s_id,old.s_name,old.s_phone, null, now()
    );
end $$
delimiter ;
delete from tbl_student where s_id='20191234';
select * from tbl_student;
select * from tbl_student_bak;

-- 08
drop trigger tbl_teacher_delete_trg;
delimiter $$
create trigger tbl_teacher_delete_trg
after delete
on tbl_teacher
for each row
begin
	insert into tbl_teacher_bak values(
    old.t_id,old.t_name,old.t_phone,old.t_addr, null, now()
    );
end $$
delimiter ;
delete from tbl_teacher where t_id=7;
select * from tbl_teacher;
select * from tbl_teacher_bak;