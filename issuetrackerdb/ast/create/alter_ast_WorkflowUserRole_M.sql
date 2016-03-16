

ALTER TABLE ast_WorkflowUserRole_M ADD CONSTRAINT fk_fe69ee229 FOREIGN KEY (prjRoleId) REFERENCES ast_ProjectRoles_M(prjRoleId);



ALTER TABLE ast_WorkflowUserRole_M ADD CONSTRAINT fk_ead41e079 FOREIGN KEY (workflowId) REFERENCES ast_Workflow_M(workflowId);



exit;