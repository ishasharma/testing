

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_65da66704 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_0147abf62 FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;