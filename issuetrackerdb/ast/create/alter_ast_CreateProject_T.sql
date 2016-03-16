

ALTER TABLE ast_CreateProject_T ADD CONSTRAINT fk_a56a701c3 FOREIGN KEY (projectAccessCode) REFERENCES ast_ProjectAccessRights_M(projectAccessCode);



exit;