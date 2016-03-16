Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.issuetracker.IssueHistoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueHistoryMainController",
     "restURL": "/IssueHistory",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueHistoryModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.issuetracker.IssueHistoryMainController", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel", "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.issuetracker.IssueHistoryViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Issue History",
               "name": "IssueHistoryTreeContainer",
               "itemId": "IssueHistoryTreeContainer",
               "restURL": "/IssueHistory",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "IssueHistoryTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "issueHistId",
                         "itemId": "issueHistId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Hist Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Hist Id",
                         "fieldId": "3C068B43-2FC1-4747-BA03-1E92E1782AA8",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueHistId"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Issue History",
                    "title": "Issue History",
                    "name": "IssueHistory",
                    "itemId": "IssueHistoryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueHistId",
                         "itemId": "issueHistId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Hist Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Hist Id<font color='red'> *<\/font>",
                         "fieldId": "3C068B43-2FC1-4747-BA03-1E92E1782AA8",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueHistId"
                    }, {
                         "name": "issueId",
                         "itemId": "issueId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Id",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel"
                         },
                         "fieldLabel": "Issue Id",
                         "fieldId": "EF523A64-9EB7-4987-856F-95C600929772",
                         "restURL": "IssueWorkflow",
                         "bindable": "issueId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueCategoryCode",
                         "itemId": "issueCategoryCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel"
                         },
                         "fieldLabel": "Issue Category",
                         "fieldId": "CA8C1FA7-3CE1-4CBC-B4FA-B20209228D33",
                         "restURL": "IssueCategory",
                         "bindable": "issueCategoryCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "featureCategoryCode",
                         "itemId": "featureCategoryCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Feature Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel"
                         },
                         "fieldLabel": "Feature Category",
                         "fieldId": "F4B4DC38-5A11-4A0A-978C-2E0C81C6CD3A",
                         "restURL": "FeatureCategory",
                         "bindable": "featureCategoryCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueSeverityCode",
                         "itemId": "issueSeverityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Severity",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel"
                         },
                         "fieldLabel": "Issue Severity",
                         "fieldId": "83D85896-741A-493D-A04B-C693988FA1E9",
                         "restURL": "IssueSeverity",
                         "bindable": "issueSeverityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issuePriorityCode",
                         "itemId": "issuePriorityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Priority",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel"
                         },
                         "fieldLabel": "Issue Priority",
                         "fieldId": "554800EF-F8CD-4608-8927-39A10C6490C4",
                         "restURL": "IssuePriority",
                         "bindable": "issuePriorityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "effortEstimate",
                         "itemId": "effortEstimate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Effort Estimate",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Effort Estimate",
                         "fieldId": "03D455D6-DB04-4090-ABE7-3C0A776C3C35",
                         "bindable": "effortEstimate",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueFlagCode",
                         "itemId": "issueFlagCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Flag",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel"
                         },
                         "fieldLabel": "Issue Flag",
                         "fieldId": "E3B9D2CC-BCBC-4FA4-88FB-96ECC7CCD022",
                         "restURL": "IssueFlag",
                         "bindable": "issueFlagCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStageCode",
                         "itemId": "issueStageCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Stage",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStageModel"
                         },
                         "fieldLabel": "Issue Stage",
                         "fieldId": "331BB3B7-DE90-4594-AD40-60D1634F30DA",
                         "restURL": "IssueStage",
                         "bindable": "issueStageCode",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onIssueStageCodeChange"
                         }
                    }, {
                         "name": "issueStatusCode",
                         "itemId": "issueStatusCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Status",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel"
                         },
                         "fieldLabel": "Issue Status",
                         "fieldId": "88445F85-179E-4781-B836-E4FBED88F2ED",
                         "restURL": "IssueStatus",
                         "bindable": "issueStatusCode",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onIssueStatusCodeChange"
                         }
                    }, {
                         "name": "issueActivityCode",
                         "itemId": "issueActivityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Activity",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel"
                         },
                         "fieldLabel": "Issue Activity",
                         "fieldId": "EC4712A6-CFB7-49B6-99BD-09471D4C3F5D",
                         "restURL": "IssueActivity",
                         "bindable": "issueActivityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "lastUpdated",
                         "itemId": "lastUpdated",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Last Updated On",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Last Updated On",
                         "fieldId": "7E704EE7-153F-4F46-B958-3D6DCB3732D3",
                         "bindable": "lastUpdated",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactId",
                         "itemId": "contactId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "User",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel"
                         },
                         "fieldLabel": "User",
                         "fieldId": "29FE5927-1794-43F4-8271-7178B8BED25C",
                         "restURL": "CoreContacts",
                         "bindable": "contactId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueDate",
                         "itemId": "issueDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Date Of Issue",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Date Of Issue",
                         "fieldId": "C3E1D47B-0A26-457D-95BF-7DB5FDC1F564",
                         "bindable": "issueDate",
                         "columnWidth": 0.5
                    }, {
                         "name": "startTime",
                         "itemId": "startTime",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Start Time",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Start Time",
                         "fieldId": "F2BE51B0-7270-43EF-9AB2-9D88A16EFCF1",
                         "bindable": "startTime",
                         "columnWidth": 0.5
                    }, {
                         "name": "endTime",
                         "itemId": "endTime",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "End Time",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "End Time",
                         "fieldId": "B8950C5B-E3E2-4966-8294-85E86B6E232B",
                         "bindable": "endTime",
                         "columnWidth": 0.5
                    }, {
                         "name": "comments",
                         "itemId": "comments",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Comments",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Comments",
                         "fieldId": "43A249A1-0180-4E22-900F-B7D356FB0865",
                         "bindable": "comments",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "5486905D-DDE6-4169-9309-FD17BFBF7904",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 367,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 367,
                              "customId": 214
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 367,
                              "customId": 215,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 367,
                              "customId": 216,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Issue History",
                    "title": "Details Grid",
                    "name": "IssueHistoryGrid",
                    "itemId": "IssueHistoryGrid",
                    "restURL": "/IssueHistory",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Issue Hist Id",
                         "dataIndex": "issueHistId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Issue Id",
                         "dataIndex": "issueId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Category",
                         "dataIndex": "issueCategoryCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Feature Category",
                         "dataIndex": "featureCategoryCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Severity",
                         "dataIndex": "issueSeverityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Priority",
                         "dataIndex": "issuePriorityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Effort Estimate",
                         "dataIndex": "effortEstimate",
                         "flex": 1
                    }, {
                         "header": "Issue Flag",
                         "dataIndex": "issueFlagCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Stage",
                         "dataIndex": "issueStageCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Status",
                         "dataIndex": "issueStatusCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Activity",
                         "dataIndex": "issueActivityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Last Updated On",
                         "dataIndex": "lastUpdated",
                         "flex": 1
                    }, {
                         "header": "User",
                         "dataIndex": "contactId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Date Of Issue",
                         "dataIndex": "issueDate",
                         "flex": 1
                    }, {
                         "header": "Start Time",
                         "dataIndex": "startTime",
                         "flex": 1
                    }, {
                         "header": "End Time",
                         "dataIndex": "endTime",
                         "flex": 1
                    }, {
                         "header": "Comments",
                         "dataIndex": "comments",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Issue History",
               "title": "Issue History",
               "name": "IssueHistory",
               "itemId": "IssueHistoryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueHistId",
                    "itemId": "issueHistId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Hist Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Hist Id<font color='red'> *<\/font>",
                    "fieldId": "3C068B43-2FC1-4747-BA03-1E92E1782AA8",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueHistId"
               }, {
                    "name": "issueId",
                    "itemId": "issueId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Id",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel"
                    },
                    "fieldLabel": "Issue Id",
                    "fieldId": "EF523A64-9EB7-4987-856F-95C600929772",
                    "restURL": "IssueWorkflow",
                    "bindable": "issueId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueCategoryCode",
                    "itemId": "issueCategoryCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel"
                    },
                    "fieldLabel": "Issue Category",
                    "fieldId": "CA8C1FA7-3CE1-4CBC-B4FA-B20209228D33",
                    "restURL": "IssueCategory",
                    "bindable": "issueCategoryCode",
                    "columnWidth": 0.5
               }, {
                    "name": "featureCategoryCode",
                    "itemId": "featureCategoryCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Feature Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel"
                    },
                    "fieldLabel": "Feature Category",
                    "fieldId": "F4B4DC38-5A11-4A0A-978C-2E0C81C6CD3A",
                    "restURL": "FeatureCategory",
                    "bindable": "featureCategoryCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issueSeverityCode",
                    "itemId": "issueSeverityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Severity",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel"
                    },
                    "fieldLabel": "Issue Severity",
                    "fieldId": "83D85896-741A-493D-A04B-C693988FA1E9",
                    "restURL": "IssueSeverity",
                    "bindable": "issueSeverityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issuePriorityCode",
                    "itemId": "issuePriorityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Priority",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel"
                    },
                    "fieldLabel": "Issue Priority",
                    "fieldId": "554800EF-F8CD-4608-8927-39A10C6490C4",
                    "restURL": "IssuePriority",
                    "bindable": "issuePriorityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "effortEstimate",
                    "itemId": "effortEstimate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Effort Estimate",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Effort Estimate",
                    "fieldId": "03D455D6-DB04-4090-ABE7-3C0A776C3C35",
                    "bindable": "effortEstimate",
                    "columnWidth": 0.5
               }, {
                    "name": "issueFlagCode",
                    "itemId": "issueFlagCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Flag",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel"
                    },
                    "fieldLabel": "Issue Flag",
                    "fieldId": "E3B9D2CC-BCBC-4FA4-88FB-96ECC7CCD022",
                    "restURL": "IssueFlag",
                    "bindable": "issueFlagCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStageCode",
                    "itemId": "issueStageCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Stage",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStageModel"
                    },
                    "fieldLabel": "Issue Stage",
                    "fieldId": "331BB3B7-DE90-4594-AD40-60D1634F30DA",
                    "restURL": "IssueStage",
                    "bindable": "issueStageCode",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onIssueStageCodeChange"
                    }
               }, {
                    "name": "issueStatusCode",
                    "itemId": "issueStatusCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Status",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel"
                    },
                    "fieldLabel": "Issue Status",
                    "fieldId": "88445F85-179E-4781-B836-E4FBED88F2ED",
                    "restURL": "IssueStatus",
                    "bindable": "issueStatusCode",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onIssueStatusCodeChange"
                    }
               }, {
                    "name": "issueActivityCode",
                    "itemId": "issueActivityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Activity",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel"
                    },
                    "fieldLabel": "Issue Activity",
                    "fieldId": "EC4712A6-CFB7-49B6-99BD-09471D4C3F5D",
                    "restURL": "IssueActivity",
                    "bindable": "issueActivityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "lastUpdated",
                    "itemId": "lastUpdated",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Last Updated On",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Last Updated On",
                    "fieldId": "7E704EE7-153F-4F46-B958-3D6DCB3732D3",
                    "bindable": "lastUpdated",
                    "columnWidth": 0.5
               }, {
                    "name": "contactId",
                    "itemId": "contactId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "User",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel"
                    },
                    "fieldLabel": "User",
                    "fieldId": "29FE5927-1794-43F4-8271-7178B8BED25C",
                    "restURL": "CoreContacts",
                    "bindable": "contactId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueDate",
                    "itemId": "issueDate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Date Of Issue",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Date Of Issue",
                    "fieldId": "C3E1D47B-0A26-457D-95BF-7DB5FDC1F564",
                    "bindable": "issueDate",
                    "columnWidth": 0.5
               }, {
                    "name": "startTime",
                    "itemId": "startTime",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Start Time",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Start Time",
                    "fieldId": "F2BE51B0-7270-43EF-9AB2-9D88A16EFCF1",
                    "bindable": "startTime",
                    "columnWidth": 0.5
               }, {
                    "name": "endTime",
                    "itemId": "endTime",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "End Time",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "End Time",
                    "fieldId": "B8950C5B-E3E2-4966-8294-85E86B6E232B",
                    "bindable": "endTime",
                    "columnWidth": 0.5
               }, {
                    "name": "comments",
                    "itemId": "comments",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Comments",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Comments",
                    "fieldId": "43A249A1-0180-4E22-900F-B7D356FB0865",
                    "bindable": "comments",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "5486905D-DDE6-4169-9309-FD17BFBF7904",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 367,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 367,
                         "customId": 214
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 367,
                         "customId": 215,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 367,
                         "customId": 216,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});