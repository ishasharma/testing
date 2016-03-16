

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_e0d3d5f4c FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;