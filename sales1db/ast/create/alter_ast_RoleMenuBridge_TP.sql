

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_84f4efae5 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_81674f69a FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;