









ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ORACLE_SID=XE
PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_SID
export ORACLE_HOME
export ORACLE_SID
export PATH
DB_PATH=/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C
ART_CREATE_PATH=/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/create
AST_CREATE_PATH=/tmp/applifire/db/IMYOEI4KXMNPRVKXSFOAA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/create
MYSQL=/usr/bin
APPLFIREUSER=root
APPLFIREPASSWORD=root
APPLFIREHOST=localhost



DB_NAME=issuetracker
USER=issuetracker
PASSWORD=issuetracker
PORT=1521
HOST=localhost


sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Timezone_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Language_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Country_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_State_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_City_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_AddressType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Address_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ContactType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationGroup_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Gender_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Title_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CoreContacts_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_AddressMap_B.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationData_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationMap_B.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_PasswordAlgo_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_PasswordPolicy_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Question_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserAccessLevel_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserAccessDomain_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_User_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Login_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_LoginSession_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserAppState_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_PassRecovery_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserData_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_SessionData_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Roles_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_AppMenus_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_RoleMenuBridge_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserRoleBridge_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueCategory_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ProjectAccessRights_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueVisibility_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CreateProject_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ProjectModule_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ProjectFeature_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ProjectUserMapping_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ModuleUserMapping_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_FeatureUserMapping_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ProjectRoles_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_RoleUserMapping_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Workflow_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_WorkflowUserRole_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_FeatureCategory_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueStage_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueStatus_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueActivity_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueSeverity_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssuePriority_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueFlag_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueWorkflow_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueHeaders_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueAssignment_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueHistory_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueRelationType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_AddWatchers_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_IssueRelation_M.sql; 

