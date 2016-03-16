
connect sys/oracle as sysdba
create tablespace issuetracker DATAFILE '/u01/app/oracle/oradata/issuetracker.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='ISSUETRACKER';
if (userexist = 0) then
execute immediate 'create user issuetracker identified by issuetracker default tablespace issuetracker';
end if;
end;
/
ALTER USER "ISSUETRACKER" DEFAULT TABLESPACE "ISSUETRACKER" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;