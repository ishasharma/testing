

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_fb50811c0 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_a815ecef2 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_2bfe3a627 FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_d51a3ba0c FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;