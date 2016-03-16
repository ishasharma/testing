

ALTER TABLE ast_ProjectUserMapping_TP ADD CONSTRAINT fk_582f140a5 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_ProjectUserMapping_TP ADD CONSTRAINT fk_72f523b95 FOREIGN KEY (projectId) REFERENCES ast_CreateProject_T(projectId);



exit;