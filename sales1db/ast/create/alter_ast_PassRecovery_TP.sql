

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_60ef5bc2f FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_7bec21d9d FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;