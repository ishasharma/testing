CREATE TABLE ast_ModuleUserMapping_TP ( modUserId VARCHAR2(64)  NOT NULL, projectId VARCHAR2(64)  NOT NULL, moduleId VARCHAR2(64)  NOT NULL, contactId VARCHAR2(64)  NOT NULL, isAdmin CHAR CHECK (isAdmin in (0,1)), createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '11-nov-01', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '11-nov-01', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (modUserId));

exit;