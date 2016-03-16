load data infile '/tmp/applifire/db/WD0JFHO6YIBEWUERIEJNDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/AddressType.csv' into table ast_AddressType_M FIELDS TERMINATED BY '#appfire#' (addressTypeId,addressType,addressTypeDesc CHAR(1000) "decode(:addressTypeDesc, '\\N', null, :addressTypeDesc)",addressTypeIcon CHAR(1000) "decode(:addressTypeIcon, '\\N', null, :addressTypeIcon)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")
