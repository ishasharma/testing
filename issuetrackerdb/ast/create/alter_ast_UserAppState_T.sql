

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_91b43f775 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;