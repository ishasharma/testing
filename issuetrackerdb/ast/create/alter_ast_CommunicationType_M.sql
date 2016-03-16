

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_9ba9488b0 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;