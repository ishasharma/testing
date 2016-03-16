

ALTER TABLE ast_City_M ADD CONSTRAINT fk_1875bf0c0 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_bb40196c5 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;