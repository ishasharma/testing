CREATE TABLE ast_IssueFlag_M ( issueFlagCode VARCHAR2(64)  NOT NULL, issueFlagName VARCHAR2(256)  NOT NULL, issueFlagDesc VARCHAR2(1024)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '11-nov-01', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '11-nov-01', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (issueFlagCode));

exit;