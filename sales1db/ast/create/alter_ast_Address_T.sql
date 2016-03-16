

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_42499baf9 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_b71182fa0 FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_7b6c15c6a FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_871816195 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;