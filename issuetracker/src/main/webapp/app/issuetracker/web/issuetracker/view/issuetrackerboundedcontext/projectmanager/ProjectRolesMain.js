Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.projectmanager.ProjectRolesMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProjectRolesMainController",
     "restURL": "/ProjectRoles",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.ProjectRolesModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.projectmanager.ProjectRolesMainController", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.IssueVisibilityModel", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.projectmanager.ProjectRolesViewModel"],
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
               "displayName": "Project Roles",
               "name": "ProjectRolesTreeContainer",
               "itemId": "ProjectRolesTreeContainer",
               "restURL": "/ProjectRoles",
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
                    "itemId": "ProjectRolesTree",
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
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Project Roles",
                    "title": "Project Roles",
                    "name": "ProjectRoles",
                    "itemId": "ProjectRolesForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "prjRoleId",
                         "itemId": "prjRoleId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Role Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Role Id<font color='red'> *<\/font>",
                         "fieldId": "E5FF0A8C-07F7-452D-9325-6A827602B5C1",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "prjRoleId"
                    }, {
                         "name": "roleName",
                         "itemId": "roleName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Role Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Role Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "71F19686-60B5-4464-A7B2-90693F450066",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "roleName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueVisibilityCode",
                         "itemId": "issueVisibilityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Visiblity Code",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.IssueVisibilityModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Issue Visiblity Code<font color='red'> *<\/font>",
                         "fieldId": "3443F2F0-C23A-4634-A4D0-89B1261A8F53",
                         "restURL": "IssueVisibility",
                         "bindable": "issueVisibilityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "canAssignRole",
                         "itemId": "canAssignRole",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "Can Assign Role",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "Can Assign Role",
                         "fieldId": "561EEF78-503C-4733-8CF9-963F61F18117",
                         "bindable": "canAssignRole",
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
                         "fieldId": "AF3C47AE-F2F0-4DA6-BD5D-63F063637E3B",
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
                         "customId": 182,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 182,
                              "customId": 145
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 182,
                              "customId": 146,
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
                              "parentId": 182,
                              "customId": 147,
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
                    "displayName": "Project Roles",
                    "title": "Details Grid",
                    "name": "ProjectRolesGrid",
                    "itemId": "ProjectRolesGrid",
                    "restURL": "/ProjectRoles",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Role Id",
                         "dataIndex": "prjRoleId",
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
                         "header": "Role Name",
                         "dataIndex": "roleName",
                         "flex": 1
                    }, {
                         "header": "Issue Visiblity Code",
                         "dataIndex": "issueVisibilityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Can Assign Role",
                         "dataIndex": "canAssignRole",
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
               "displayName": "Project Roles",
               "title": "Project Roles",
               "name": "ProjectRoles",
               "itemId": "ProjectRolesForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "prjRoleId",
                    "itemId": "prjRoleId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Role Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Role Id<font color='red'> *<\/font>",
                    "fieldId": "E5FF0A8C-07F7-452D-9325-6A827602B5C1",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "prjRoleId"
               }, {
                    "name": "roleName",
                    "itemId": "roleName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Role Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Role Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "71F19686-60B5-4464-A7B2-90693F450066",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "roleName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueVisibilityCode",
                    "itemId": "issueVisibilityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Visiblity Code",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.projectmanager.IssueVisibilityModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Issue Visiblity Code<font color='red'> *<\/font>",
                    "fieldId": "3443F2F0-C23A-4634-A4D0-89B1261A8F53",
                    "restURL": "IssueVisibility",
                    "bindable": "issueVisibilityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "canAssignRole",
                    "itemId": "canAssignRole",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "Can Assign Role",
                    "margin": "5 5 5 5",
                    "value": "0",
                    "inputValue": true,
                    "fieldLabel": "Can Assign Role",
                    "fieldId": "561EEF78-503C-4733-8CF9-963F61F18117",
                    "bindable": "canAssignRole",
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
                    "fieldId": "AF3C47AE-F2F0-4DA6-BD5D-63F063637E3B",
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
                    "customId": 182,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 182,
                         "customId": 145
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 182,
                         "customId": 146,
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
                         "parentId": 182,
                         "customId": 147,
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