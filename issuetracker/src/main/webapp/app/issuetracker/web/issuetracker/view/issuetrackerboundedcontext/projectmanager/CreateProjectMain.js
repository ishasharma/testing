Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.projectmanager.CreateProjectMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CreateProjectMainController",
     "restURL": "/CreateProject",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.projectmanager.CreateProjectMainController", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsModel", "Issuetracker.view.fw.component.Grids", "Issuetracker.issuetracker.shared.issuetracker.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.projectmanager.CreateProjectViewModel"],
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
               "displayName": "Create Project",
               "name": "CreateProjectTreeContainer",
               "itemId": "CreateProjectTreeContainer",
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
                    "itemId": "CreateProjectTree",
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
                    "displayName": "Create Project",
                    "name": "CreateProject",
                    "itemId": "CreateProjectForm",
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
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "projectId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "projectId<font color='red'> *<\/font>",
                                   "fieldId": "2C1C4539-DE26-49E0-983C-19A13C01984B",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "projectId"
                              }, {
                                   "name": "projectName",
                                   "itemId": "projectName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D56E8395-AAD9-44F8-959C-08C644E358C2",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "errorMessage": "Please enter valid Project",
                                   "bindable": "projectName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectShortName",
                                   "itemId": "projectShortName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Short Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Short Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "594298A5-3F2B-40F0-8C3D-22B38B4CB4AE",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "projectShortName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectDescription",
                                   "itemId": "projectDescription",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Project Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Description<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E72DB824-DC35-4CB1-B194-4D0A82F24CBE",
                                   "bindable": "projectDescription",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectURL",
                                   "itemId": "projectURL",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project URL",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project URL",
                                   "fieldId": "E9D9B07C-4679-451E-9FF7-C3EF54FA004E",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "projectURL",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectAccessCode",
                                   "itemId": "projectAccessCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Access Code",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Access Code<font color='red'> *<\/font>",
                                   "fieldId": "2540CB7C-0F16-46A7-ABDC-76FE99EC8C75",
                                   "restURL": "ProjectAccessRights",
                                   "bindable": "projectAccessCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "version",
                                   "itemId": "version",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Version",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Version",
                                   "fieldId": "97B845F6-E455-4381-A9F6-51F64D889D47",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "version",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "build",
                                   "itemId": "build",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Build",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Build",
                                   "fieldId": "8446C2BE-8C8F-45ED-8AF1-A7485C34A4FA",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "build",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateOfCreation",
                                   "itemId": "dateOfCreation",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Project Creation Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Project Creation Date",
                                   "fieldId": "67284551-582A-4596-BB44-4BCCD95720A4",
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
                                   "fieldId": "94808E34-85FB-41C9-AF8B-F9334B0C84E4",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Project User Mapping",
                         "title": "Project User Mapping",
                         "name": "ProjectUserMapping",
                         "itemId": "ProjectUserMappingForm",
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
                                        "fieldId": "DA9A8B2B-48B9-4AF4-A2B3-1702F1E0B457",
                                        "restURL": "CoreContacts",
                                        "bindable": "projectUserMapping.contactId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "isAdmin",
                                        "itemId": "isAdmin",
                                        "xtype": "checkbox",
                                        "customWidgetType": "vdCheckbox",
                                        "displayName": "Is Project Admin",
                                        "margin": "5 5 5 5",
                                        "value": "0",
                                        "inputValue": true,
                                        "fieldLabel": "Is Project Admin",
                                        "fieldId": "CD393A94-8FF0-42BD-B576-22593BAAC12E",
                                        "bindable": "projectUserMapping.isAdmin",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 253,
                              "text": "Add ProjectUserMapping",
                              "handler": "addProjectUserMapping"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "ProjectUserMapping",
                              "columnWidth": 1,
                              "itemId": "ProjectUserMappingGrid",
                              "fieldLabel": "List",
                              "bindLevel": "projectUserMapping",
                              "bindable": "projectUserMapping",
                              "listeners": {
                                   "select": "onProjectUserMappingGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Project Pk",
                                   "text": "Project Pk",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "prjUserId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "User",
                                   "text": "User",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "contactId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Is Project Admin",
                                   "text": "Is Project Admin",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "isAdmin",
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
                    "displayName": "Create Project",
                    "title": "Details Grid",
                    "name": "CreateProjectGrid",
                    "itemId": "CreateProjectGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "projectId",
                         "dataIndex": "projectId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Project Name",
                         "dataIndex": "projectName",
                         "flex": 1
                    }, {
                         "header": "Project Short Name",
                         "dataIndex": "projectShortName",
                         "flex": 1
                    }, {
                         "header": "Project Description",
                         "dataIndex": "projectDescription",
                         "flex": 1
                    }, {
                         "header": "Project URL",
                         "dataIndex": "projectURL",
                         "flex": 1
                    }, {
                         "header": "Access Code",
                         "dataIndex": "projectAccessCode",
                         "flex": 1
                    }, {
                         "header": "Project Version",
                         "dataIndex": "version",
                         "flex": 1
                    }, {
                         "header": "Project Build",
                         "dataIndex": "build",
                         "flex": 1
                    }, {
                         "header": "Project Creation Date",
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
               "displayName": "Create Project",
               "name": "CreateProject",
               "itemId": "CreateProjectForm",
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
                              "name": "projectId",
                              "itemId": "projectId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "projectId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "projectId<font color='red'> *<\/font>",
                              "fieldId": "2C1C4539-DE26-49E0-983C-19A13C01984B",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "projectId"
                         }, {
                              "name": "projectName",
                              "itemId": "projectName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "D56E8395-AAD9-44F8-959C-08C644E358C2",
                              "minLength": "0",
                              "maxLength": "128",
                              "errorMessage": "Please enter valid Project",
                              "bindable": "projectName",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectShortName",
                              "itemId": "projectShortName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Short Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Short Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "594298A5-3F2B-40F0-8C3D-22B38B4CB4AE",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "projectShortName",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectDescription",
                              "itemId": "projectDescription",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Project Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Description<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E72DB824-DC35-4CB1-B194-4D0A82F24CBE",
                              "bindable": "projectDescription",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectURL",
                              "itemId": "projectURL",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project URL",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project URL",
                              "fieldId": "E9D9B07C-4679-451E-9FF7-C3EF54FA004E",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "projectURL",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectAccessCode",
                              "itemId": "projectAccessCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Access Code",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Access Code<font color='red'> *<\/font>",
                              "fieldId": "2540CB7C-0F16-46A7-ABDC-76FE99EC8C75",
                              "restURL": "ProjectAccessRights",
                              "bindable": "projectAccessCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "version",
                              "itemId": "version",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Version",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Version",
                              "fieldId": "97B845F6-E455-4381-A9F6-51F64D889D47",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "version",
                              "columnWidth": 0.5
                         }, {
                              "name": "build",
                              "itemId": "build",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Build",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Build",
                              "fieldId": "8446C2BE-8C8F-45ED-8AF1-A7485C34A4FA",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "build",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateOfCreation",
                              "itemId": "dateOfCreation",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Project Creation Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Project Creation Date",
                              "fieldId": "67284551-582A-4596-BB44-4BCCD95720A4",
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
                              "fieldId": "94808E34-85FB-41C9-AF8B-F9334B0C84E4",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Project User Mapping",
                    "title": "Project User Mapping",
                    "name": "ProjectUserMapping",
                    "itemId": "ProjectUserMappingForm",
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
                                   "fieldId": "DA9A8B2B-48B9-4AF4-A2B3-1702F1E0B457",
                                   "restURL": "CoreContacts",
                                   "bindable": "projectUserMapping.contactId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "isAdmin",
                                   "itemId": "isAdmin",
                                   "xtype": "checkbox",
                                   "customWidgetType": "vdCheckbox",
                                   "displayName": "Is Project Admin",
                                   "margin": "5 5 5 5",
                                   "value": "0",
                                   "inputValue": true,
                                   "fieldLabel": "Is Project Admin",
                                   "fieldId": "CD393A94-8FF0-42BD-B576-22593BAAC12E",
                                   "bindable": "projectUserMapping.isAdmin",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 253,
                         "text": "Add ProjectUserMapping",
                         "handler": "addProjectUserMapping"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "ProjectUserMapping",
                         "columnWidth": 1,
                         "itemId": "ProjectUserMappingGrid",
                         "fieldLabel": "List",
                         "bindLevel": "projectUserMapping",
                         "bindable": "projectUserMapping",
                         "listeners": {
                              "select": "onProjectUserMappingGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Project Pk",
                              "text": "Project Pk",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "prjUserId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "User",
                              "text": "User",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "contactId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Is Project Admin",
                              "text": "Is Project Admin",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "isAdmin",
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