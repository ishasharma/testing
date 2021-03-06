Ext.define('Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "issuestagecode",
          "reference": "IssueStage",
          "defaultValue": ""
     }, {
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "issueStatusCode",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "issueStatusId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "issueStatusName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "issueStatusDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});