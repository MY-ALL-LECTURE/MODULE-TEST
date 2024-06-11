use lmsdb;

select no,lec_duration,lec_time,t_name,lec_name,tbl_current_lecture.class_no from tbl_current_lecture
inner join tbl_classroom
on tbl_current_lecture.class_no = tbl_classroom.class_no
inner join tbl_lecture
on tbl_current_lecture.lec_code = tbl_lecture.lec_code
inner join tbl_teacher
on tbl_current_lecture.t_id = tbl_teacher.t_id;

create or replace view view_current_lecture
as
select no,lec_duration,lec_time,t_name,lec_name,tbl_current_lecture.class_no from tbl_current_lecture
inner join tbl_classroom
on tbl_current_lecture.class_no = tbl_classroom.class_no
inner join tbl_lecture
on tbl_current_lecture.lec_code = tbl_lecture.lec_code
inner join tbl_teacher
on tbl_current_lecture.t_id = tbl_teacher.t_id;

select * from view_current_lecture;

select lec_name,
sum(if(lec_time='09:00 - 12:00', 1,0)) as '09:00 - 12:00',
sum(if(lec_time='13:00 - 15:00', 1,0)) as '13:00 - 15:00',
sum(if(lec_time='15:00 - 17:00', 1,0)) as '15:00 - 17:00'
from view_current_lecture group by lec_name with rollup;

drop procedure proc_insert_tbl_registration;

delimiter $$
create procedure proc_insert_tbl_registration (in sid varchar(45), in lcode int, in lduration varchar(100))
begin
    declare error_code int;
    declare error_msg text;
    declare continue handler for sqlexception
    begin
        get diagnostics condition 1 error_code = mysql_errno, error_msg = message_text;
        insert into tbl_errlog (error_code, error_date, error_msg) values (error_code, now(), error_msg);
    end;
    insert into tbl_registration (s_id, lec_code, lec_duration) values (sid, lcode, lduration);
end$$

delimiter ;
call proc_insert_tbl_registration('20190001',1001,'2023-05-22 - 2023-06-21');
call proc_insert_tbl_registration('20190001',1001,'2023-05-22 - 2023-06-21');
call proc_insert_tbl_registration('20190001',7001,'2023-05-22 - 2023-06-21');
call proc_insert_tbl_registration('70190001',1001,'2023-05-22 - 2023-06-21');
select * from tbl_errlog;

drop trigger tbl_student_update_trg;

delimiter $$
create trigger tbl_student_update_trg before update on tbl_student
for each row
begin
    insert into tbl_student_bak (s_id, s_name, s_phone, update_date)
    values (old.s_id, old.s_name, old.s_phone, now());
end $$
delimiter ;
insert into tbl_student values('20191234','나나나','010-1234-1234');
update tbl_student set s_name='우우우' where s_id='20191234';
select * from tbl_student;
select * from tbl_student_bak;


delimiter $$
create trigger tbl_teacher_update_trg before update on tbl_teacher
for each row
begin
    insert into tbl_teacher_bak (t_id, t_name, t_phone, t_addr, update_date)
    values (old.t_id, old.t_name, old.t_phone, old.t_addr, now());
end $$
delimiter ;
insert into tbl_teacher values(7,'아무개','010-222-333','대구광역시 달서구');
update tbl_teacher set t_name='아무무' where t_id=7;
update tbl_teacher set t_phone='010-777-7777' where t_id=7;
select * from tbl_teacher;
select * from tbl_teacher_bak;


drop trigger tbl_student_delete_trg;
delimiter $$
create trigger tbl_student_delete_trg after delete on tbl_student
for each row
begin
    insert into tbl_student_bak (s_id, s_name, s_phone, update_date, delete_date)
    values (old.s_id, old.s_name, old.s_phone, null, now());
end $$
delimiter ;

delete from tbl_student where s_id='20191234';
select * from tbl_student_bak;

delimiter $$
create trigger tbl_teacher_delete_trg after delete on tbl_teacher
for each row
begin
    insert into tbl_teacher_bak (t_id, t_name, t_phone, t_addr, update_date, delete_date)
    values (old.t_id, old.t_name, old.t_phone, old.t_addr, null, now());
end $$
delimiter ;

delete from tbl_teacher where t_id=7;
select * from tbl_teacher_bak;
