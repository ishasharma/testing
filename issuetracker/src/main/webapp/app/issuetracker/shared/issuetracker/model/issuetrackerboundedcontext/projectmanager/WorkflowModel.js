Ext.define('Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.WorkflowModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "workflowId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "workflowName",
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