Ext.define('Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "projectId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "projectName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "projectShortName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "projectDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "projectURL",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "projectaccesscode",
          "reference": "ProjectAccessRights",
          "defaultValue": ""
     }, {
          "name": "version",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "build",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "dateOfCreation",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "ProjectUserMapping",
          "reference": "ProjectUserMappingModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});