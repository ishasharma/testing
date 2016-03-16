

ALTER TABLE ast_City_M ADD CONSTRAINT fk_81ac933b6 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_f2a619b6d FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;