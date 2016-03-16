

ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_d3eca29d8 FOREIGN KEY (issueActivityCode) REFERENCES ast_IssueActivity_M(issueActivityCode);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_34643c2e2 FOREIGN KEY (issueId) REFERENCES ast_IssueWorkflow_T(issueId);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_8014cd089 FOREIGN KEY (issueFlagCode) REFERENCES ast_IssueFlag_M(issueFlagCode);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_b4e01df80 FOREIGN KEY (issueStageCode) REFERENCES ast_IssueStage_M(issueStageCode);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_3c5784d72 FOREIGN KEY (issuePriorityCode) REFERENCES ast_IssuePriority_M(issuePriorityCode);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_95a8d00e0 FOREIGN KEY (issueStatusCode) REFERENCES ast_IssueStatus_M(issueStatusCode);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_f86063e08 FOREIGN KEY (issueSeverityCode) REFERENCES ast_IssueSeverity_M(issueSeverityCode);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_0feafc2af FOREIGN KEY (featureCategoryCode) REFERENCES ast_FeatureCategory_M(featureCategoryCode);



ALTER TABLE ast_IssueHeaders_TP ADD CONSTRAINT fk_a7990e440 FOREIGN KEY (issueCategoryCode) REFERENCES ast_IssueCategory_M(issueCategoryCode);



exit;