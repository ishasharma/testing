load data infile '/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_log_events_t.csv' "str '#appfirenewline#'" into table art_log_events_t FIELDS TERMINATED BY '#appfire#' ( event_id,customer_id,app_name,time_stamp TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',alarm_id,severity,user_id,ip_address,module,class_name,method_name,message,throwable_message CHAR(50000) NULLIF throwable_message = '\\N')
