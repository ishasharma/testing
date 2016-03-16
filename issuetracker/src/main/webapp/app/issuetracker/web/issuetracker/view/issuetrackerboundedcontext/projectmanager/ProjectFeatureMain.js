Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.projectmanager.ProjectFeatureMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProjectFeatureMainController",
     "restURL": "/ProjectFeature",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.projectmanager.ProjectFeatureMainController", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.view.fw.component.Grids", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel", "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.projectmanager.ProjectFeatureViewModel"],
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
               "displayName": "Project Feature",
               "name": "ProjectFeatureTreeContainer",
               "itemId": "ProjectFeatureTreeContainer",
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
                    "itemId": "ProjectFeatureTree",
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
                    "displayName": "Project Feature",
                    "name": "ProjectFeature",
                    "itemId": "ProjectFeatureForm",
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
                                   "name": "featureId",
                                   "itemId": "featureId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Feature Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Id<font color='red'> *<\/font>",
                                   "fieldId": "425FB538-329F-42C1-9A6E-248295C09812",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "featureId"
                              }, {
                                   "name": "moduleId",
                                   "itemId": "moduleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Module Id",
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
                                   "fieldLabel": "Module Id<font color='red'> *<\/font>",
                                   "fieldId": "3A320BCC-1978-4CCE-A9D6-A82D5B8D06EA",
                                   "restURL": "ProjectModule",
                                   "bindable": "moduleId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Project Id",
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
                                   "fieldLabel": "Project Id<font color='red'> *<\/font>",
                                   "fieldId": "E29DE90E-FA94-48DD-8E91-FD81B859A777",
                                   "restURL": "CreateProject",
                                   "bindable": "projectId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onProjectIdChange"
                                   }
                              }, {
                                   "name": "featureName",
                                   "itemId": "featureName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Feature Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C6A29DDC-9C58-4FAF-B65A-29054F475F02",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "errorMessage": "Please enter valid project feature",
                                   "bindable": "featureName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "featureShortName",
                                   "itemId": "featureShortName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Feature Short Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Short Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "62BD54AC-0415-4477-8E30-45C6E6EBCBD0",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "featureShortName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "featureDescription",
                                   "itemId": "featureDescription",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Feature Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Description<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C157915E-9250-49E3-AE9D-B5314C6845CC",
                                   "bindable": "featureDescription",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "version",
                                   "itemId": "version",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Feature Version",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Version<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "410636F1-A4FE-4AFA-9531-286713BEFCFC",
                                   "minValue": "0",
                                   "maxValue": "11",
                                   "bindable": "version",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "build",
                                   "itemId": "build",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Feature Build",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Build<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "47C28864-3926-405C-A246-0AFE2F5DC885",
                                   "minValue": "0",
                                   "maxValue": "11",
                                   "bindable": "build",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateOfCreation",
                                   "itemId": "dateOfCreation",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Feature Creation Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Feature Creation Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "84F0A44A-1AA4-4504-A2C8-57A396456B82",
                                   "bindable": "dateOfCreation",
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
                                   "fieldId": "D34146F6-BFF1-4B23-A012-F821724F1543",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Feature User Mapping",
                         "title": "Feature User Mapping",
                         "name": "FeatureUserMapping",
                         "itemId": "FeatureUserMappingForm",
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
                                        "name": "isAdmin",
                                        "itemId": "isAdmin",
                                        "xtype": "checkbox",
                                        "customWidgetType": "vdCheckbox",
                                        "displayName": "Is Feature Admin",
                                        "margin": "5 5 5 5",
                                        "value": "0",
                                        "inputValue": true,
                                        "fieldLabel": "Is Feature Admin",
                                        "fieldId": "FD2C2FEA-A24B-42CA-868B-E36B7AC2BEE5",
                                        "bindable": "featureUserMapping.isAdmin",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "projectId",
                                        "itemId": "projectId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Project Id",
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
                                        "fieldLabel": "Project Id<font color='red'> *<\/font>",
                                        "fieldId": "F622148A-1ADA-4019-9A7B-A7E13A8FCD1F",
                                        "restURL": "CreateProject",
                                        "bindable": "featureUserMapping.projectId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onProjectIdChange"
                                        }
                                   }, {
                                        "name": "moduleId",
                                        "itemId": "moduleId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Module Id",
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
                                        "fieldLabel": "Module Id<font color='red'> *<\/font>",
                                        "fieldId": "AABDD140-A3B6-416C-9CFF-F84D2CD129E4",
                                        "restURL": "ProjectModule",
                                        "bindable": "featureUserMapping.moduleId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onModuleIdChange"
                                        }
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
                                        "allowBlank": false,
                                        "fieldLabel": "User<font color='red'> *<\/font>",
                                        "fieldId": "48189494-10E3-4889-B7C5-8CE293A19BDE",
                                        "restURL": "CoreContacts",
                                        "bindable": "featureUserMapping.contactId",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 253,
                              "text": "Add FeatureUserMapping",
                              "handler": "addFeatureUserMapping"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "FeatureUserMapping",
                              "columnWidth": 1,
                              "itemId": "FeatureUserMappingGrid",
                              "fieldLabel": "List",
                              "bindLevel": "featureUserMapping",
                              "bindable": "featureUserMapping",
                              "listeners": {
                                   "select": "onFeatureUserMappingGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Is Feature Admin",
                                   "text": "Is Feature Admin",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "isAdmin",
                                   "flex": 1
                              }, {
                                   "header": "Feature Pk",
                                   "text": "Feature Pk",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "feaUserId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Project Id",
                                   "text": "Project Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "projectId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Module Id",
                                   "text": "Module Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "moduleId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "User",
                                   "text": "User",
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
                    "displayName": "Project Feature",
                    "title": "Details Grid",
                    "name": "ProjectFeatureGrid",
                    "itemId": "ProjectFeatureGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Feature Id",
                         "dataIndex": "featureId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Module Id",
                         "dataIndex": "moduleId",
                         "flex": 1
                    }, {
                         "header": "Project Id",
                         "dataIndex": "projectId",
                         "flex": 1
                    }, {
                         "header": "Feature Name",
                         "dataIndex": "featureName",
                         "flex": 1
                    }, {
                         "header": "Feature Short Name",
                         "dataIndex": "featureShortName",
                         "flex": 1
                    }, {
                         "header": "Feature Description",
                         "dataIndex": "featureDescription",
                         "flex": 1
                    }, {
                         "header": "Feature Version",
                         "dataIndex": "version",
                         "flex": 1
                    }, {
                         "header": "Feature Build",
                         "dataIndex": "build",
                         "flex": 1
                    }, {
                         "header": "Feature Creation Date",
                         "dataIndex": "dateOfCreation",
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
               "displayName": "Project Feature",
               "name": "ProjectFeature",
               "itemId": "ProjectFeatureForm",
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
                              "name": "featureId",
                              "itemId": "featureId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Feature Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Id<font color='red'> *<\/font>",
                              "fieldId": "425FB538-329F-42C1-9A6E-248295C09812",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "featureId"
                         }, {
                              "name": "moduleId",
                              "itemId": "moduleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Module Id",
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
                              "fieldLabel": "Module Id<font color='red'> *<\/font>",
                              "fieldId": "3A320BCC-1978-4CCE-A9D6-A82D5B8D06EA",
                              "restURL": "ProjectModule",
                              "bindable": "moduleId",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectId",
                              "itemId": "projectId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Project Id",
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
                              "fieldLabel": "Project Id<font color='red'> *<\/font>",
                              "fieldId": "E29DE90E-FA94-48DD-8E91-FD81B859A777",
                              "restURL": "CreateProject",
                              "bindable": "projectId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onProjectIdChange"
                              }
                         }, {
                              "name": "featureName",
                              "itemId": "featureName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Feature Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C6A29DDC-9C58-4FAF-B65A-29054F475F02",
                              "minLength": "0",
                              "maxLength": "128",
                              "errorMessage": "Please enter valid project feature",
                              "bindable": "featureName",
                              "columnWidth": 0.5
                         }, {
                              "name": "featureShortName",
                              "itemId": "featureShortName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Feature Short Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Short Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "62BD54AC-0415-4477-8E30-45C6E6EBCBD0",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "featureShortName",
                              "columnWidth": 0.5
                         }, {
                              "name": "featureDescription",
                              "itemId": "featureDescription",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Feature Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Description<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C157915E-9250-49E3-AE9D-B5314C6845CC",
                              "bindable": "featureDescription",
                              "columnWidth": 0.5
                         }, {
                              "name": "version",
                              "itemId": "version",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Feature Version",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Version<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "410636F1-A4FE-4AFA-9531-286713BEFCFC",
                              "minValue": "0",
                              "maxValue": "11",
                              "bindable": "version",
                              "columnWidth": 0.5
                         }, {
                              "name": "build",
                              "itemId": "build",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Feature Build",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Build<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "47C28864-3926-405C-A246-0AFE2F5DC885",
                              "minValue": "0",
                              "maxValue": "11",
                              "bindable": "build",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateOfCreation",
                              "itemId": "dateOfCreation",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Feature Creation Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Feature Creation Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "84F0A44A-1AA4-4504-A2C8-57A396456B82",
                              "bindable": "dateOfCreation",
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
                              "fieldId": "D34146F6-BFF1-4B23-A012-F821724F1543",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Feature User Mapping",
                    "title": "Feature User Mapping",
                    "name": "FeatureUserMapping",
                    "itemId": "FeatureUserMappingForm",
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
                                   "name": "isAdmin",
                                   "itemId": "isAdmin",
                                   "xtype": "checkbox",
                                   "customWidgetType": "vdCheckbox",
                                   "displayName": "Is Feature Admin",
                                   "margin": "5 5 5 5",
                                   "value": "0",
                                   "inputValue": true,
                                   "fieldLabel": "Is Feature Admin",
                                   "fieldId": "FD2C2FEA-A24B-42CA-868B-E36B7AC2BEE5",
                                   "bindable": "featureUserMapping.isAdmin",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Project Id",
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
                                   "fieldLabel": "Project Id<font color='red'> *<\/font>",
                                   "fieldId": "F622148A-1ADA-4019-9A7B-A7E13A8FCD1F",
                                   "restURL": "CreateProject",
                                   "bindable": "featureUserMapping.projectId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onProjectIdChange"
                                   }
                              }, {
                                   "name": "moduleId",
                                   "itemId": "moduleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Module Id",
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
                                   "fieldLabel": "Module Id<font color='red'> *<\/font>",
                                   "fieldId": "AABDD140-A3B6-416C-9CFF-F84D2CD129E4",
                                   "restURL": "ProjectModule",
                                   "bindable": "featureUserMapping.moduleId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onModuleIdChange"
                                   }
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
                                   "allowBlank": false,
                                   "fieldLabel": "User<font color='red'> *<\/font>",
                                   "fieldId": "48189494-10E3-4889-B7C5-8CE293A19BDE",
                                   "restURL": "CoreContacts",
                                   "bindable": "featureUserMapping.contactId",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 253,
                         "text": "Add FeatureUserMapping",
                         "handler": "addFeatureUserMapping"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "FeatureUserMapping",
                         "columnWidth": 1,
                         "itemId": "FeatureUserMappingGrid",
                         "fieldLabel": "List",
                         "bindLevel": "featureUserMapping",
                         "bindable": "featureUserMapping",
                         "listeners": {
                              "select": "onFeatureUserMappingGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Is Feature Admin",
                              "text": "Is Feature Admin",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "isAdmin",
                              "flex": 1
                         }, {
                              "header": "Feature Pk",
                              "text": "Feature Pk",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "feaUserId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Project Id",
                              "text": "Project Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "projectId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Module Id",
                              "text": "Module Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "moduleId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "User",
                              "text": "User",
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