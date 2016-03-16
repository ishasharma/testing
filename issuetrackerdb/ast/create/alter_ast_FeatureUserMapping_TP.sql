

ALTER TABLE ast_FeatureUserMapping_TP ADD CONSTRAINT fk_93b3a3ff5 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_FeatureUserMapping_TP ADD CONSTRAINT fk_322fba035 FOREIGN KEY (moduleId) REFERENCES ast_ProjectModule_T(moduleId);



ALTER TABLE ast_FeatureUserMapping_TP ADD CONSTRAINT fk_48268e597 FOREIGN KEY (featureId) REFERENCES ast_ProjectFeature_T(featureId);



ALTER TABLE ast_FeatureUserMapping_TP ADD CONSTRAINT fk_7b641e017 FOREIGN KEY (projectId) REFERENCES ast_CreateProject_T(projectId);



exit;