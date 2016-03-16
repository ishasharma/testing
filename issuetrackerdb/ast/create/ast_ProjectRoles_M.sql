CREATE TABLE ast_ProjectRoles_M ( prjRoleId VARCHAR2(64)  NOT NULL, roleName VARCHAR2(256)  NOT NULL, issueVisibilityCode VARCHAR2(64)  NOT NULL, canAssignRole CHAR CHECK (canAssignRole in (0,1)), createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '11-nov-01', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '11-nov-01', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (prjRoleId));

exit;