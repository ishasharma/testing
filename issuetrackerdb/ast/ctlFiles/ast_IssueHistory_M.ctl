load data infile '/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/IssueHistory.csv' into table ast_IssueHistory_M FIELDS TERMINATED BY '#appfire#' (issueHistId,issueId CHAR(1000) "decode(:issueId, '\\N', null, :issueId)",issueCategoryCode CHAR(1000) "decode(:issueCategoryCode, '\\N', null, :issueCategoryCode)",featureCategoryCode CHAR(1000) "decode(:featureCategoryCode, '\\N', null, :featureCategoryCode)",issueSeverityCode CHAR(1000) "decode(:issueSeverityCode, '\\N', null, :issueSeverityCode)",issuePriorityCode CHAR(1000) "decode(:issuePriorityCode, '\\N', null, :issuePriorityCode)",effortEstimate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:effortEstimate, '\\N', null, :effortEstimate)",issueFlagCode CHAR(1000) "decode(:issueFlagCode, '\\N', null, :issueFlagCode)",issueStageCode CHAR(1000) "decode(:issueStageCode, '\\N', null, :issueStageCode)",issueStatusCode CHAR(1000) "decode(:issueStatusCode, '\\N', null, :issueStatusCode)",issueActivityCode CHAR(1000) "decode(:issueActivityCode, '\\N', null, :issueActivityCode)",lastUpdated TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:lastUpdated, '\\N', null, :lastUpdated)",contactId CHAR(1000) "decode(:contactId, '\\N', null, :contactId)",issueDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:issueDate, '\\N', null, :issueDate)",startTime TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:startTime, '\\N', null, :startTime)",endTime TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:endTime, '\\N', null, :endTime)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",comments CHAR(1000) "decode(:comments, '\\N', null, :comments)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")

