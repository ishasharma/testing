

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_72f38b5e7 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_07e2ddad2 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;