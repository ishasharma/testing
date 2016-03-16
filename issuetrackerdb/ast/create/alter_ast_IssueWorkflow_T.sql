

ALTER TABLE ast_IssueWorkflow_T ADD CONSTRAINT fk_34b9c768c FOREIGN KEY (creatorContactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_IssueWorkflow_T ADD CONSTRAINT fk_2f7709d76 FOREIGN KEY (moduleId) REFERENCES ast_ProjectModule_T(moduleId);



ALTER TABLE ast_IssueWorkflow_T ADD CONSTRAINT fk_6126f269f FOREIGN KEY (featureId) REFERENCES ast_ProjectFeature_T(featureId);



ALTER TABLE ast_IssueWorkflow_T ADD CONSTRAINT fk_a202885dc FOREIGN KEY (projectId) REFERENCES ast_CreateProject_T(projectId);



exit;