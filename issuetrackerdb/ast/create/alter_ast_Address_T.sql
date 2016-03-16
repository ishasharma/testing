

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_e6662e5c3 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_505a0db72 FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_f8689f2e2 FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_af1e7cff2 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;