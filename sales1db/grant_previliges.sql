
connect sys/oracle as sysdba
GRANT "DBA" TO "SALES1" ;
GRANT "CONNECT" TO "SALES1" WITH ADMIN OPTION;
ALTER USER "SALES1" DEFAULT ROLE "DBA","CONNECT";
exit;