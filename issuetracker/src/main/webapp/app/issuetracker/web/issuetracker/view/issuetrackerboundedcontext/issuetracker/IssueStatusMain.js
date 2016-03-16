Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.issuetracker.IssueStatusMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueStatusMainController",
     "restURL": "/IssueStatus",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.issuetracker.IssueStatusMainController", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.issuetracker.IssueStatusViewModel"],
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
               "displayName": "Issue Status",
               "name": "IssueStatusTreeContainer",
               "itemId": "IssueStatusTreeContainer",
               "restURL": "/IssueStatus",
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
                    "itemId": "IssueStatusTree",
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
                         "name": "issueStageCode",
                         "itemId": "issueStageCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Stage Code",
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
                         "fieldLabel": "Issue Stage Code",
                         "fieldId": "F40538F2-5CDD-4674-BB1F-D06EAD5BB11F",
                         "restURL": "IssueStage",
                         "bindable": "issueStageCode"
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
                    "displayName": "Issue Status",
                    "title": "Issue Status",
                    "name": "IssueStatus",
                    "itemId": "IssueStatusForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueStageCode",
                         "itemId": "issueStageCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Stage Code",
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
                         "fieldLabel": "Issue Stage Code<font color='red'> *<\/font>",
                         "fieldId": "F40538F2-5CDD-4674-BB1F-D06EAD5BB11F",
                         "restURL": "IssueStage",
                         "bindable": "issueStageCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStatusCode",
                         "itemId": "issueStatusCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Status Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status Code<font color='red'> *<\/font>",
                         "fieldId": "00CF7FA8-40C1-4230-BE3C-CE7CFF6E6560",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueStatusCode"
                    }, {
                         "name": "issueStatusId",
                         "itemId": "issueStatusId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Status Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status Id<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "1E52EA01-77A3-46A5-80CC-A7155DACE471",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "issueStatusId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStatusName",
                         "itemId": "issueStatusName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Status",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "58859F55-6A81-40F8-A94D-BCC594C932EE",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Issue Status",
                         "bindable": "issueStatusName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStatusDesc",
                         "itemId": "issueStatusDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Issue Status Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status Description",
                         "fieldId": "119F7CD8-3FDF-42F2-B2BC-CBE580904205",
                         "bindable": "issueStatusDesc",
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
                         "fieldId": "292A9CD7-A30F-42AA-A506-C7A44ED2FD14",
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
                         "customId": 428,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 428,
                              "customId": 233
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 428,
                              "customId": 234,
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
                              "parentId": 428,
                              "customId": 235,
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
                    "displayName": "Issue Status",
                    "title": "Details Grid",
                    "name": "IssueStatusGrid",
                    "itemId": "IssueStatusGrid",
                    "restURL": "/IssueStatus",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Issue Stage Code",
                         "dataIndex": "issueStageCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Status Code",
                         "dataIndex": "issueStatusCode",
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
                         "header": "Issue Status Id",
                         "dataIndex": "issueStatusId",
                         "flex": 1
                    }, {
                         "header": "Issue Status",
                         "dataIndex": "issueStatusName",
                         "flex": 1
                    }, {
                         "header": "Issue Status Description",
                         "dataIndex": "issueStatusDesc",
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
               "displayName": "Issue Status",
               "title": "Issue Status",
               "name": "IssueStatus",
               "itemId": "IssueStatusForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueStageCode",
                    "itemId": "issueStageCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Stage Code",
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
                    "fieldLabel": "Issue Stage Code<font color='red'> *<\/font>",
                    "fieldId": "F40538F2-5CDD-4674-BB1F-D06EAD5BB11F",
                    "restURL": "IssueStage",
                    "bindable": "issueStageCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStatusCode",
                    "itemId": "issueStatusCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Status Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status Code<font color='red'> *<\/font>",
                    "fieldId": "00CF7FA8-40C1-4230-BE3C-CE7CFF6E6560",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueStatusCode"
               }, {
                    "name": "issueStatusId",
                    "itemId": "issueStatusId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Status Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status Id<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "1E52EA01-77A3-46A5-80CC-A7155DACE471",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "issueStatusId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStatusName",
                    "itemId": "issueStatusName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Status",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "58859F55-6A81-40F8-A94D-BCC594C932EE",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid Issue Status",
                    "bindable": "issueStatusName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStatusDesc",
                    "itemId": "issueStatusDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Issue Status Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status Description",
                    "fieldId": "119F7CD8-3FDF-42F2-B2BC-CBE580904205",
                    "bindable": "issueStatusDesc",
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
                    "fieldId": "292A9CD7-A30F-42AA-A506-C7A44ED2FD14",
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
                    "customId": 428,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 428,
                         "customId": 233
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 428,
                         "customId": 234,
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
                         "parentId": 428,
                         "customId": 235,
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