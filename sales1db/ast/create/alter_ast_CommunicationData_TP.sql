

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_7c86ce9cc FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_55270ff90 FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;