load data infile '/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_app_alarm.csv' "str '#appfirenewline#'" into table art_app_alarm FIELDS TERMINATED BY '#appfire#' (id,alarm_id,severity,connector_order_id,message,diagnose,solution,log_module_id,version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',active_status)

