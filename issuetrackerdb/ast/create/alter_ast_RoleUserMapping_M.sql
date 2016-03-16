

ALTER TABLE ast_RoleUserMapping_M ADD CONSTRAINT fk_e5f0925ca FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_RoleUserMapping_M ADD CONSTRAINT fk_81c34fc2f FOREIGN KEY (prjRoleId) REFERENCES ast_ProjectRoles_M(prjRoleId);



exit;