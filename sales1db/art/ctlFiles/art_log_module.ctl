load data infile '/tmp/applifire/db/WD0JFHO6YIBEWUERIEJNDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_log_module.csv' "str '#appfirenewline#'" into table art_log_module FIELDS TERMINATED BY '#appfire#' (id,log_module_name,connector_order_id,severity,id_range_starts_with,system_defined,version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',active_status)

