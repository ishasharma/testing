

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_57a6b43c3 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_dfcb6c676 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;