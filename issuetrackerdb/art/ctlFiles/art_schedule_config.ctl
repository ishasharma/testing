load data infile '/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_schedule_config.csv' "str '#appfirenewline#'" into table art_schedule_config FIELDS TERMINATED BY '#appfire#' (schedule_id,schedule_name,schedule_job,scheduler_expression,schedule_strategy,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)

