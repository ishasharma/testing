Ext.define('Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueHeadersModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "issuePk",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "issuecategorycode",
          "reference": "IssueCategory",
          "defaultValue": ""
     }, {
          "name": "featurecategorycode",
          "reference": "FeatureCategory",
          "defaultValue": ""
     }, {
          "name": "issueseveritycode",
          "reference": "IssueSeverity",
          "defaultValue": ""
     }, {
          "name": "issueprioritycode",
          "reference": "IssuePriority",
          "defaultValue": ""
     }, {
          "name": "effortEstimate",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "issueflagcode",
          "reference": "IssueFlag",
          "defaultValue": ""
     }, {
          "name": "issuestagecode",
          "reference": "IssueStage",
          "defaultValue": ""
     }, {
          "name": "issuestatuscode",
          "reference": "IssueStatus",
          "defaultValue": ""
     }, {
          "name": "issueactivitycode",
          "reference": "IssueActivity",
          "defaultValue": ""
     }, {
          "name": "comments",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "lastUpdated",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "IssueWorkflow",
          "reference": "IssueWorkflowModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});