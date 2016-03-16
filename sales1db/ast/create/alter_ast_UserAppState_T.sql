

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_3dc8ea808 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;