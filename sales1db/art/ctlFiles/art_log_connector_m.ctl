load data infile '/tmp/applifire/db/WD0JFHO6YIBEWUERIEJNDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_log_connector_m.csv' "str '#appfirenewline#'" into table art_log_connector_m FIELDS TERMINATED BY '#appfire#' (connector_id,log_config_id,connector_log_level,cid,id,enabled,connector_name,class_name,system_defined,version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',active_status)

