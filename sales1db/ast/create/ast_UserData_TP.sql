CREATE TABLE ast_UserData_TP ( userDataId VARCHAR2(64)  NOT NULL, userId VARCHAR2(64)  NOT NULL, password VARCHAR2(512)  NOT NULL, oneTimePassword VARCHAR2(32)  DEFAULT NULL, oneTimePasswordExpiry NUMBER(11)  DEFAULT NULL, oneTimePasswordGenDate TIMESTAMP  DEFAULT NULL, last5Passwords VARCHAR2(500)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '11-nov-01', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '11-nov-01', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (userDataId));

exit;