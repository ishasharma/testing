

ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_97208af37 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_3c896bd9b FOREIGN KEY (issueActivityCode) REFERENCES ast_IssueActivity_M(issueActivityCode);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_bc99526f8 FOREIGN KEY (issueId) REFERENCES ast_IssueWorkflow_T(issueId);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_9df4b6456 FOREIGN KEY (issueFlagCode) REFERENCES ast_IssueFlag_M(issueFlagCode);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_3dad394fd FOREIGN KEY (issueStageCode) REFERENCES ast_IssueStage_M(issueStageCode);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_d0092eefa FOREIGN KEY (issuePriorityCode) REFERENCES ast_IssuePriority_M(issuePriorityCode);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_e3f06748d FOREIGN KEY (issueStatusCode) REFERENCES ast_IssueStatus_M(issueStatusCode);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_f3d387a3d FOREIGN KEY (issueSeverityCode) REFERENCES ast_IssueSeverity_M(issueSeverityCode);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_07cf22a01 FOREIGN KEY (featureCategoryCode) REFERENCES ast_FeatureCategory_M(featureCategoryCode);



ALTER TABLE ast_IssueHistory_M ADD CONSTRAINT fk_aa82e08b8 FOREIGN KEY (issueCategoryCode) REFERENCES ast_IssueCategory_M(issueCategoryCode);



exit;