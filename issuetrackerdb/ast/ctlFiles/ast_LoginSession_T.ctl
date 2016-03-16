load data infile '/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/LoginSession.csv' into table ast_LoginSession_T FIELDS TERMINATED BY '#appfire#' (AppSessionId,userId,AppServerSessionId,loginTime TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',lastAccessTime TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:lastAccessTime, '\\N', null, :lastAccessTime)",logoutTime TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',clientIPAddress,clientIPAddressInt,clientNetworkAddress CHAR(1000) "decode(:clientNetworkAddress, '\\N', null, :clientNetworkAddress)",clientBrowser,sessionData CHAR(50000) NULLIF sessionData = '\\N',createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")

