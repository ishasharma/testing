

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_1d25e9345 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_dd5b106b8 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;