

ALTER TABLE ast_IssueRelation_M ADD CONSTRAINT fk_3bf5105fc FOREIGN KEY (issueRelationId) REFERENCES ast_IssueWorkflow_T(issueId);



ALTER TABLE ast_IssueRelation_M ADD CONSTRAINT fk_3aa7c234e FOREIGN KEY (issueId) REFERENCES ast_IssueWorkflow_T(issueId);



ALTER TABLE ast_IssueRelation_M ADD CONSTRAINT fk_6070469d3 FOREIGN KEY (relationCode) REFERENCES ast_IssueRelationType_M(relationCode);



exit;