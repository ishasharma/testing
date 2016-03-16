Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.issuetracker.IssueWorkflowMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueWorkflowMainController",
     "restURL": "/IssueWorkflow",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.issuetracker.IssueWorkflowMainController", "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel", "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.view.fw.component.Grids", "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.issuetracker.IssueWorkflowViewModel"],
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
               "displayName": "Issue Workflow",
               "name": "IssueWorkflowTreeContainer",
               "itemId": "IssueWorkflowTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "IssueWorkflowTree",
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
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
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
                    "xtype": "form",
                    "displayName": "Issue Workflow",
                    "name": "IssueWorkflow",
                    "itemId": "IssueWorkflowForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "issueId",
                                   "itemId": "issueId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Issue Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Issue Id<font color='red'> *<\/font>",
                                   "fieldId": "94A2423E-6327-47CE-8166-FC0FD2862040",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "issueId"
                              }, {
                                   "name": "issueTitle",
                                   "itemId": "issueTitle",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Issue Title",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Issue Title<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "8CA63E4E-42B2-4601-8099-4FEB7C51688E",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "issueTitle",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "issueDescription",
                                   "itemId": "issueDescription",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Issue Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Issue Description<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "45790931-A298-4B9C-8D39-E0BE09AF3F7F",
                                   "bindable": "issueDescription",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "stepsToReproduce",
                                   "itemId": "stepsToReproduce",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Steps To Reproduce",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Steps To Reproduce",
                                   "fieldId": "3FDDF272-DC1D-445D-8C71-3B2743D62502",
                                   "bindable": "stepsToReproduce",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "creatorContactId",
                                   "itemId": "creatorContactId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Issue Created By",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Created By<font color='red'> *<\/font>",
                                   "fieldId": "236CAEE8-CDAB-490A-9044-791384BDFFC4",
                                   "restURL": "CoreContacts",
                                   "bindable": "creatorContactId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateCreated",
                                   "itemId": "dateCreated",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Created Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Created Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "3AB2C821-41A8-40A7-9D34-AD18190394A6",
                                   "bindable": "dateCreated",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Project Name",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Project Name<font color='red'> *<\/font>",
                                   "fieldId": "56D42737-FDDD-4FB9-9D39-6B3C6AE3097B",
                                   "restURL": "CreateProject",
                                   "bindable": "projectId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onProjectIdChange"
                                   }
                              }, {
                                   "name": "moduleId",
                                   "itemId": "moduleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Module Name",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Module Name<font color='red'> *<\/font>",
                                   "fieldId": "44EEB146-969D-4384-A2DD-AA21EC114610",
                                   "restURL": "ProjectModule",
                                   "bindable": "moduleId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onModuleIdChange"
                                   }
                              }, {
                                   "name": "featureId",
                                   "itemId": "featureId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Feature Name",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                                   "fieldId": "419FFC5E-B5F9-4613-8031-3E7CA18C73D4",
                                   "restURL": "ProjectFeature",
                                   "bindable": "featureId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "browser",
                                   "itemId": "browser",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Browser",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Browser",
                                   "fieldId": "5DEB76B3-BE18-431D-9E8E-BCACB8DA32BF",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "browser",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "oS",
                                   "itemId": "oS",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "OS",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "OS",
                                   "fieldId": "3C1F54B4-7932-4A30-B045-7ADE164B4CAA",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "oS",
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
                                   "fieldId": "C9CE176D-C3EB-4FEF-BD6A-FF784AEF8D04",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Issue Assignment",
                         "title": "Issue Assignment",
                         "name": "IssueAssignment",
                         "itemId": "IssueAssignmentForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
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
                                        "allowBlank": false,
                                        "fieldLabel": "User<font color='red'> *<\/font>",
                                        "fieldId": "848673AB-AC91-472A-AAD2-0C2DCA9F24C9",
                                        "restURL": "CoreContacts",
                                        "bindable": "issueAssignment.contactId",
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
                                        "fieldLabel": "Date Of Issue<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "BE74CE2E-33A0-45A7-9A4A-DAD34EAA651B",
                                        "bindable": "issueAssignment.issueDate",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "startTime",
                                        "itemId": "startTime",
                                        "xtype": "datefield",
                                        "customWidgetType": "vdDatefield",
                                        "displayName": "Start Date",
                                        "margin": "5 5 5 5",
                                        "format": "d-m-Y",
                                        "submitFormat": "d-m-Y",
                                        "fieldLabel": "Start Date<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "4ECAAD74-3EB0-482E-84E2-1729E766A439",
                                        "bindable": "issueAssignment.startTime",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "endTime",
                                        "itemId": "endTime",
                                        "xtype": "datefield",
                                        "customWidgetType": "vdDatefield",
                                        "displayName": "End Date",
                                        "margin": "5 5 5 5",
                                        "format": "d-m-Y",
                                        "submitFormat": "d-m-Y",
                                        "fieldLabel": "End Date",
                                        "fieldId": "9465C8EA-02EF-46C0-9E73-AB52FD031B63",
                                        "bindable": "issueAssignment.endTime",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "comments",
                                        "itemId": "comments",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Comments",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Comments<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "C7A2A68A-2B6C-42E8-A43C-AEBB1CDFC694",
                                        "bindable": "issueAssignment.comments",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Add Watchers",
                         "title": "Add Watchers",
                         "name": "AddWatchers",
                         "itemId": "AddWatchersForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "contactId",
                                        "itemId": "contactId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Contact Id",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                        "fieldId": "0BCC8365-9B28-4A8C-A1E7-B2BCA52244A9",
                                        "restURL": "CoreContacts",
                                        "bindable": "addWatchers.contactId",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 176,
                              "text": "Add AddWatchers",
                              "handler": "addAddWatchers"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "AddWatchers",
                              "columnWidth": 1,
                              "itemId": "AddWatchersGrid",
                              "fieldLabel": "List",
                              "bindLevel": "addWatchers",
                              "bindable": "addWatchers",
                              "listeners": {
                                   "select": "onAddWatchersGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Watch Id",
                                   "text": "Watch Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "watchId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Contact Id",
                                   "text": "Contact Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "contactId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Issue Headers",
                         "title": "Issue Headers",
                         "name": "IssueHeaders",
                         "itemId": "IssueHeadersForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Category<font color='red'> *<\/font>",
                                        "fieldId": "5140F3A0-0275-48C8-A1C0-9767E7527A7B",
                                        "restURL": "IssueCategory",
                                        "bindable": "issueHeaders.issueCategoryCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Feature Category<font color='red'> *<\/font>",
                                        "fieldId": "B2807955-77AF-4841-9ED4-61F7A0C97535",
                                        "restURL": "FeatureCategory",
                                        "bindable": "issueHeaders.featureCategoryCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Severity<font color='red'> *<\/font>",
                                        "fieldId": "011F2C52-B689-428A-B81B-32A7F418D55D",
                                        "restURL": "IssueSeverity",
                                        "bindable": "issueHeaders.issueSeverityCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Priority<font color='red'> *<\/font>",
                                        "fieldId": "B0864FDA-24BB-4315-966C-8977068C9448",
                                        "restURL": "IssuePriority",
                                        "bindable": "issueHeaders.issuePriorityCode",
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
                                        "fieldLabel": "Effort Estimate<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "1F426880-A77D-4524-9951-EA6A9AD68F02",
                                        "bindable": "issueHeaders.effortEstimate",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Flag<font color='red'> *<\/font>",
                                        "fieldId": "315908AA-6C9D-4B52-B5CF-FF6F82D4087F",
                                        "restURL": "IssueFlag",
                                        "bindable": "issueHeaders.issueFlagCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Stage<font color='red'> *<\/font>",
                                        "fieldId": "A06EC61E-5AEA-4098-AE58-600981981CC6",
                                        "restURL": "IssueStage",
                                        "bindable": "issueHeaders.issueStageCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                                        "fieldId": "AC44D9C7-E9A8-47D9-9208-749180CA6219",
                                        "restURL": "IssueStatus",
                                        "bindable": "issueHeaders.issueStatusCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Activity<font color='red'> *<\/font>",
                                        "fieldId": "AAFC559C-075A-4C56-8A43-D95F1A4F17A0",
                                        "restURL": "IssueActivity",
                                        "bindable": "issueHeaders.issueActivityCode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "comments",
                                        "itemId": "comments",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Comments",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Comments<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "C8FCF759-ECDB-4AAA-AA42-82D35FAAAF84",
                                        "bindable": "issueHeaders.comments",
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
                                        "fieldLabel": "Last Updated On<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "FAF653CB-A964-47D6-B69E-282B11232039",
                                        "bindable": "issueHeaders.lastUpdated",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Issue Workflow",
                    "title": "Details Grid",
                    "name": "IssueWorkflowGrid",
                    "itemId": "IssueWorkflowGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Issue Id",
                         "dataIndex": "issueId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Issue Title",
                         "dataIndex": "issueTitle",
                         "flex": 1
                    }, {
                         "header": "Issue Description",
                         "dataIndex": "issueDescription",
                         "flex": 1
                    }, {
                         "header": "Steps To Reproduce",
                         "dataIndex": "stepsToReproduce",
                         "flex": 1
                    }, {
                         "header": "Issue Created By",
                         "dataIndex": "creatorContactId",
                         "flex": 1
                    }, {
                         "header": "Created Date",
                         "dataIndex": "dateCreated",
                         "flex": 1
                    }, {
                         "header": "Project Name",
                         "dataIndex": "projectId",
                         "flex": 1
                    }, {
                         "header": "Module Name",
                         "dataIndex": "moduleId",
                         "flex": 1
                    }, {
                         "header": "Feature Name",
                         "dataIndex": "featureId",
                         "flex": 1
                    }, {
                         "header": "Browser",
                         "dataIndex": "browser",
                         "flex": 1
                    }, {
                         "header": "OS",
                         "dataIndex": "oS",
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
               "xtype": "form",
               "displayName": "Issue Workflow",
               "name": "IssueWorkflow",
               "itemId": "IssueWorkflowForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "issueId",
                              "itemId": "issueId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Issue Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Issue Id<font color='red'> *<\/font>",
                              "fieldId": "94A2423E-6327-47CE-8166-FC0FD2862040",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "issueId"
                         }, {
                              "name": "issueTitle",
                              "itemId": "issueTitle",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Issue Title",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Issue Title<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "8CA63E4E-42B2-4601-8099-4FEB7C51688E",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "issueTitle",
                              "columnWidth": 0.5
                         }, {
                              "name": "issueDescription",
                              "itemId": "issueDescription",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Issue Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Issue Description<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "45790931-A298-4B9C-8D39-E0BE09AF3F7F",
                              "bindable": "issueDescription",
                              "columnWidth": 0.5
                         }, {
                              "name": "stepsToReproduce",
                              "itemId": "stepsToReproduce",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Steps To Reproduce",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Steps To Reproduce",
                              "fieldId": "3FDDF272-DC1D-445D-8C71-3B2743D62502",
                              "bindable": "stepsToReproduce",
                              "columnWidth": 0.5
                         }, {
                              "name": "creatorContactId",
                              "itemId": "creatorContactId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Issue Created By",
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
                              "allowBlank": false,
                              "fieldLabel": "Issue Created By<font color='red'> *<\/font>",
                              "fieldId": "236CAEE8-CDAB-490A-9044-791384BDFFC4",
                              "restURL": "CoreContacts",
                              "bindable": "creatorContactId",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateCreated",
                              "itemId": "dateCreated",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Created Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Created Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "3AB2C821-41A8-40A7-9D34-AD18190394A6",
                              "bindable": "dateCreated",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectId",
                              "itemId": "projectId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Project Name",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Project Name<font color='red'> *<\/font>",
                              "fieldId": "56D42737-FDDD-4FB9-9D39-6B3C6AE3097B",
                              "restURL": "CreateProject",
                              "bindable": "projectId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onProjectIdChange"
                              }
                         }, {
                              "name": "moduleId",
                              "itemId": "moduleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Module Name",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Module Name<font color='red'> *<\/font>",
                              "fieldId": "44EEB146-969D-4384-A2DD-AA21EC114610",
                              "restURL": "ProjectModule",
                              "bindable": "moduleId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onModuleIdChange"
                              }
                         }, {
                              "name": "featureId",
                              "itemId": "featureId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Feature Name",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                              "fieldId": "419FFC5E-B5F9-4613-8031-3E7CA18C73D4",
                              "restURL": "ProjectFeature",
                              "bindable": "featureId",
                              "columnWidth": 0.5
                         }, {
                              "name": "browser",
                              "itemId": "browser",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Browser",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Browser",
                              "fieldId": "5DEB76B3-BE18-431D-9E8E-BCACB8DA32BF",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "browser",
                              "columnWidth": 0.5
                         }, {
                              "name": "oS",
                              "itemId": "oS",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "OS",
                              "margin": "5 5 5 5",
                              "fieldLabel": "OS",
                              "fieldId": "3C1F54B4-7932-4A30-B045-7ADE164B4CAA",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "oS",
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
                              "fieldId": "C9CE176D-C3EB-4FEF-BD6A-FF784AEF8D04",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Issue Assignment",
                    "title": "Issue Assignment",
                    "name": "IssueAssignment",
                    "itemId": "IssueAssignmentForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
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
                                   "allowBlank": false,
                                   "fieldLabel": "User<font color='red'> *<\/font>",
                                   "fieldId": "848673AB-AC91-472A-AAD2-0C2DCA9F24C9",
                                   "restURL": "CoreContacts",
                                   "bindable": "issueAssignment.contactId",
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
                                   "fieldLabel": "Date Of Issue<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "BE74CE2E-33A0-45A7-9A4A-DAD34EAA651B",
                                   "bindable": "issueAssignment.issueDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "startTime",
                                   "itemId": "startTime",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Start Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Start Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "4ECAAD74-3EB0-482E-84E2-1729E766A439",
                                   "bindable": "issueAssignment.startTime",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "endTime",
                                   "itemId": "endTime",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "End Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "End Date",
                                   "fieldId": "9465C8EA-02EF-46C0-9E73-AB52FD031B63",
                                   "bindable": "issueAssignment.endTime",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "comments",
                                   "itemId": "comments",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Comments",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Comments<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C7A2A68A-2B6C-42E8-A43C-AEBB1CDFC694",
                                   "bindable": "issueAssignment.comments",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Add Watchers",
                    "title": "Add Watchers",
                    "name": "AddWatchers",
                    "itemId": "AddWatchersForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "contactId",
                                   "itemId": "contactId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Contact Id",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                   "fieldId": "0BCC8365-9B28-4A8C-A1E7-B2BCA52244A9",
                                   "restURL": "CoreContacts",
                                   "bindable": "addWatchers.contactId",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 176,
                         "text": "Add AddWatchers",
                         "handler": "addAddWatchers"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "AddWatchers",
                         "columnWidth": 1,
                         "itemId": "AddWatchersGrid",
                         "fieldLabel": "List",
                         "bindLevel": "addWatchers",
                         "bindable": "addWatchers",
                         "listeners": {
                              "select": "onAddWatchersGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Watch Id",
                              "text": "Watch Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "watchId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Contact Id",
                              "text": "Contact Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "contactId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Issue Headers",
                    "title": "Issue Headers",
                    "name": "IssueHeaders",
                    "itemId": "IssueHeadersForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Category<font color='red'> *<\/font>",
                                   "fieldId": "5140F3A0-0275-48C8-A1C0-9767E7527A7B",
                                   "restURL": "IssueCategory",
                                   "bindable": "issueHeaders.issueCategoryCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Feature Category<font color='red'> *<\/font>",
                                   "fieldId": "B2807955-77AF-4841-9ED4-61F7A0C97535",
                                   "restURL": "FeatureCategory",
                                   "bindable": "issueHeaders.featureCategoryCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Severity<font color='red'> *<\/font>",
                                   "fieldId": "011F2C52-B689-428A-B81B-32A7F418D55D",
                                   "restURL": "IssueSeverity",
                                   "bindable": "issueHeaders.issueSeverityCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Priority<font color='red'> *<\/font>",
                                   "fieldId": "B0864FDA-24BB-4315-966C-8977068C9448",
                                   "restURL": "IssuePriority",
                                   "bindable": "issueHeaders.issuePriorityCode",
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
                                   "fieldLabel": "Effort Estimate<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "1F426880-A77D-4524-9951-EA6A9AD68F02",
                                   "bindable": "issueHeaders.effortEstimate",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Flag<font color='red'> *<\/font>",
                                   "fieldId": "315908AA-6C9D-4B52-B5CF-FF6F82D4087F",
                                   "restURL": "IssueFlag",
                                   "bindable": "issueHeaders.issueFlagCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Stage<font color='red'> *<\/font>",
                                   "fieldId": "A06EC61E-5AEA-4098-AE58-600981981CC6",
                                   "restURL": "IssueStage",
                                   "bindable": "issueHeaders.issueStageCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                                   "fieldId": "AC44D9C7-E9A8-47D9-9208-749180CA6219",
                                   "restURL": "IssueStatus",
                                   "bindable": "issueHeaders.issueStatusCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Activity<font color='red'> *<\/font>",
                                   "fieldId": "AAFC559C-075A-4C56-8A43-D95F1A4F17A0",
                                   "restURL": "IssueActivity",
                                   "bindable": "issueHeaders.issueActivityCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "comments",
                                   "itemId": "comments",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Comments",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Comments<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C8FCF759-ECDB-4AAA-AA42-82D35FAAAF84",
                                   "bindable": "issueHeaders.comments",
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
                                   "fieldLabel": "Last Updated On<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "FAF653CB-A964-47D6-B69E-282B11232039",
                                   "bindable": "issueHeaders.lastUpdated",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});