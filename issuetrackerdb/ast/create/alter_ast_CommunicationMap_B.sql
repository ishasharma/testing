

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_d4f958565 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_e4c50432b FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;