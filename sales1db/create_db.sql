
connect sys/oracle as sysdba
create tablespace sales1 DATAFILE '/u01/app/oracle/oradata/sales1.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='SALES1';
if (userexist = 0) then
execute immediate 'create user sales1 identified by sales default tablespace sales1';
end if;
end;
/
ALTER USER "SALES1" DEFAULT TABLESPACE "SALES1" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;