

ALTER TABLE ast_IssueStatus_M ADD CONSTRAINT fk_cbf97e2f0 FOREIGN KEY (issueStageCode) REFERENCES ast_IssueStage_M(issueStageCode);



exit;