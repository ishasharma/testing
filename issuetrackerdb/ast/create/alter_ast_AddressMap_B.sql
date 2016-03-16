

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_26b489fe5 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_183422c4b FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;