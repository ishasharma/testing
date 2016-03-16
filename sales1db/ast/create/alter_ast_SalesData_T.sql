

ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_3796880d0 FOREIGN KEY (reatilercode) REFERENCES ast_Retailer_M(retailercode);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_714d18b28 FOREIGN KEY (materialcode) REFERENCES ast_Material_M(materialcode);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_82f252337 FOREIGN KEY (category) REFERENCES ast_Category_M(categoryId);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_bcd8d9d69 FOREIGN KEY (channelId) REFERENCES ast_Channel_M(channelId);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_5533fbccc FOREIGN KEY (brandcode) REFERENCES ast_Brand_M(brandcode);



exit;