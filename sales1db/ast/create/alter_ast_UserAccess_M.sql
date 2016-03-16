

ALTER TABLE ast_UserAccess_M ADD CONSTRAINT fk_835ca7ed3 FOREIGN KEY (region) REFERENCES ast_SalesRegion_M(regioncode);



ALTER TABLE ast_UserAccess_M ADD CONSTRAINT fk_568443a1e FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;