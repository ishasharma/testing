

ALTER TABLE ast_ProjectRoles_M ADD CONSTRAINT fk_1684e4ad3 FOREIGN KEY (issueVisibilityCode) REFERENCES ast_IssueVisibility_M(issueVisibilityCode);



exit;