

ALTER TABLE ast_ProjectFeature_T ADD CONSTRAINT fk_b61a19de6 FOREIGN KEY (moduleId) REFERENCES ast_ProjectModule_T(moduleId);



ALTER TABLE ast_ProjectFeature_T ADD CONSTRAINT fk_35e024955 FOREIGN KEY (projectId) REFERENCES ast_CreateProject_T(projectId);



exit;