

ALTER TABLE ast_IssueAssignment_TP ADD CONSTRAINT fk_d4d5d84ea FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_IssueAssignment_TP ADD CONSTRAINT fk_7b3bbcfc2 FOREIGN KEY (issueId) REFERENCES ast_IssueWorkflow_T(issueId);



exit;