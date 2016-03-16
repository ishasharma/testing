CREATE TABLE ast_PasswordPolicy_M ( policyId VARCHAR2(64)  NOT NULL, policyName VARCHAR2(256)  NOT NULL, policyDescription VARCHAR2(512)  DEFAULT NULL, maxPwdLength NUMBER(11)  DEFAULT NULL, minPwdLength NUMBER(11)  NOT NULL, minCapitalLetters NUMBER(11)  DEFAULT NULL, minSmallLetters NUMBER(11)  DEFAULT NULL, minNumericValues NUMBER(11)  DEFAULT NULL, minSpecialLetters NUMBER(11)  DEFAULT NULL, allowedSpecialLetters VARCHAR2(256)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '11-nov-01', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '11-nov-01', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (policyId));

exit;