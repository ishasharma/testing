

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_b32ddbdaf FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_916b77df2 FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;