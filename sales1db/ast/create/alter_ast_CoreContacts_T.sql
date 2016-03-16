

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_523dc0be5 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_78baac330 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_f546daafc FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_25bf313f3 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;