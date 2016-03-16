

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_875b7082f FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_16fff9480 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;