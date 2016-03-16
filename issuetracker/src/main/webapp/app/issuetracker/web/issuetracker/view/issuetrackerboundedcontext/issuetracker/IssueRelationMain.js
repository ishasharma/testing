Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.issuetracker.IssueRelationMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueRelationMainController",
     "restURL": "/IssueRelation",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueRelationModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.issuetracker.IssueRelationMainController", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel", "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueRelationTypeModel", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.issuetracker.IssueRelationViewModel"],
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
               "displayName": "Issue Relation",
               "name": "IssueRelationTreeContainer",
               "itemId": "IssueRelationTreeContainer",
               "restURL": "/IssueRelation",
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
                    "itemId": "IssueRelationTree",
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
                    "displayName": "Issue Relation",
                    "title": "Issue Relation",
                    "name": "IssueRelation",
                    "itemId": "IssueRelationForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "relationId",
                         "itemId": "relationId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Relation Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Relation Id<font color='red'> *<\/font>",
                         "fieldId": "9B9F782A-2387-48CB-8DC2-CC4230AE03C5",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "relationId"
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
                         "allowBlank": false,
                         "fieldLabel": "Issue Id<font color='red'> *<\/font>",
                         "fieldId": "A786E925-3245-4A8A-B994-5EDC9C81E55A",
                         "restURL": "IssueWorkflow",
                         "bindable": "issueId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueRelationId",
                         "itemId": "issueRelationId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Relation Id",
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
                         "allowBlank": false,
                         "fieldLabel": "Issue Relation Id<font color='red'> *<\/font>",
                         "fieldId": "7B4337D1-08FA-48C2-A4D0-07C3320318C6",
                         "restURL": "IssueWorkflow",
                         "bindable": "issueRelationId",
                         "columnWidth": 0.5
                    }, {
                         "name": "relationCode",
                         "itemId": "relationCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Relation Code",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueRelationTypeModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Relation Code<font color='red'> *<\/font>",
                         "fieldId": "F192C970-2F45-498A-8702-7001756CBEC0",
                         "restURL": "IssueRelationType",
                         "bindable": "relationCode",
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
                         "fieldId": "8578AFD3-28DB-4F38-A206-295F687AD13A",
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
                         "customId": 224,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 224,
                              "customId": 799
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 224,
                              "customId": 800,
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
                              "parentId": 224,
                              "customId": 801,
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
                    "displayName": "Issue Relation",
                    "title": "Details Grid",
                    "name": "IssueRelationGrid",
                    "itemId": "IssueRelationGrid",
                    "restURL": "/IssueRelation",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Relation Id",
                         "dataIndex": "relationId",
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
                         "header": "Issue Relation Id",
                         "dataIndex": "issueRelationId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Relation Code",
                         "dataIndex": "relationCode",
                         "renderer": "renderFormValue",
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
               "displayName": "Issue Relation",
               "title": "Issue Relation",
               "name": "IssueRelation",
               "itemId": "IssueRelationForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "relationId",
                    "itemId": "relationId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Relation Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Relation Id<font color='red'> *<\/font>",
                    "fieldId": "9B9F782A-2387-48CB-8DC2-CC4230AE03C5",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "relationId"
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
                    "allowBlank": false,
                    "fieldLabel": "Issue Id<font color='red'> *<\/font>",
                    "fieldId": "A786E925-3245-4A8A-B994-5EDC9C81E55A",
                    "restURL": "IssueWorkflow",
                    "bindable": "issueId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueRelationId",
                    "itemId": "issueRelationId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Relation Id",
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
                    "allowBlank": false,
                    "fieldLabel": "Issue Relation Id<font color='red'> *<\/font>",
                    "fieldId": "7B4337D1-08FA-48C2-A4D0-07C3320318C6",
                    "restURL": "IssueWorkflow",
                    "bindable": "issueRelationId",
                    "columnWidth": 0.5
               }, {
                    "name": "relationCode",
                    "itemId": "relationCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Relation Code",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueRelationTypeModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Relation Code<font color='red'> *<\/font>",
                    "fieldId": "F192C970-2F45-498A-8702-7001756CBEC0",
                    "restURL": "IssueRelationType",
                    "bindable": "relationCode",
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
                    "fieldId": "8578AFD3-28DB-4F38-A206-295F687AD13A",
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
                    "customId": 224,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 224,
                         "customId": 799
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 224,
                         "customId": 800,
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
                         "parentId": 224,
                         "customId": 801,
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