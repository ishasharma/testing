

ALTER TABLE ast_AddWatchers_TP ADD CONSTRAINT fk_00cd48b2d FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddWatchers_TP ADD CONSTRAINT fk_d2c3ab99e FOREIGN KEY (issueId) REFERENCES ast_IssueWorkflow_T(issueId);



exit;