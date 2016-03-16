

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_c767154b4 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_4ea24c797 FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;