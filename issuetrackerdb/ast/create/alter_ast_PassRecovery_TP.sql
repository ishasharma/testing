

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_b8e39a341 FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_4a6762592 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;