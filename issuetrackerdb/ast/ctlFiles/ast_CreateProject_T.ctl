load data infile '/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/CreateProject.csv' into table ast_CreateProject_T FIELDS TERMINATED BY '#appfire#' (projectId,projectName,projectShortName,projectDescription,projectURL CHAR(1000) "decode(:projectURL, '\\N', null, :projectURL)",projectAccessCode,version CHAR(1000) "decode(:version, '\\N', null, :version)",build CHAR(1000) "decode(:build, '\\N', null, :build)",dateOfCreation TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:dateOfCreation, '\\N', null, :dateOfCreation)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")
