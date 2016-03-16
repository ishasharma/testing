

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_4e37c4d2d FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_d68782877 FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;