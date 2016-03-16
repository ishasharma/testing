

ALTER TABLE ast_ModuleUserMapping_TP ADD CONSTRAINT fk_2ad77ab79 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_ModuleUserMapping_TP ADD CONSTRAINT fk_0628e1e5a FOREIGN KEY (moduleId) REFERENCES ast_ProjectModule_T(moduleId);



ALTER TABLE ast_ModuleUserMapping_TP ADD CONSTRAINT fk_4e306e251 FOREIGN KEY (projectId) REFERENCES ast_CreateProject_T(projectId);



exit;