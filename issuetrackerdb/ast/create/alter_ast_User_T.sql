

ALTER TABLE ast_User_T ADD CONSTRAINT fk_118f00773 FOREIGN KEY (userAccessLevelId) REFERENCES ast_UserAccessLevel_M(userAccessLevelId);



ALTER TABLE ast_User_T ADD CONSTRAINT fk_eddf46c18 FOREIGN KEY (userAccessDomainId) REFERENCES ast_UserAccessDomain_M(userAccessDomainId);



exit;