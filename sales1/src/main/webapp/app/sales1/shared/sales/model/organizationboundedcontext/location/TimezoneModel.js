Ext.define('Sales1.sales1.shared.sales.model.organizationboundedcontext.location.TimezoneModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "timeZoneId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "utcdifference",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "gmtLabel",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "timeZoneLabel",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "country",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "cities",
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