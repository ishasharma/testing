

ALTER TABLE ast_IssueActivity_M ADD CONSTRAINT fk_3f78918b2 FOREIGN KEY (issueStageCode) REFERENCES ast_IssueStage_M(issueStageCode);



ALTER TABLE ast_IssueActivity_M ADD CONSTRAINT fk_5b3d694c3 FOREIGN KEY (issueStatusCode) REFERENCES ast_IssueStatus_M(issueStatusCode);



exit;