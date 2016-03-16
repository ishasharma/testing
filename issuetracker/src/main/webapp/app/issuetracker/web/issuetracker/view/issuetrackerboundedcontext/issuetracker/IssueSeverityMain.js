Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.issuetracker.IssueSeverityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueSeverityMainController",
     "restURL": "/IssueSeverity",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.issuetracker.IssueSeverityMainController", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.issuetracker.IssueSeverityViewModel"],
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
               "displayName": "Issue Severity",
               "name": "IssueSeverityTreeContainer",
               "itemId": "IssueSeverityTreeContainer",
               "restURL": "/IssueSeverity",
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
                    "itemId": "IssueSeverityTree",
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
                         "name": "issueSeverityName",
                         "itemId": "issueSeverityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Severity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Severity",
                         "fieldId": "56702B20-C7D4-4872-9436-7558546F8B75",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Severity",
                         "bindable": "issueSeverityName"
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
                    "displayName": "Issue Severity",
                    "title": "Issue Severity",
                    "name": "IssueSeverity",
                    "itemId": "IssueSeverityForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueSeverityCode",
                         "itemId": "issueSeverityCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Severity Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Severity Code<font color='red'> *<\/font>",
                         "fieldId": "ACF5DE45-5D1C-47ED-AAC0-87F59E3A699C",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueSeverityCode"
                    }, {
                         "name": "issueSeverityName",
                         "itemId": "issueSeverityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Severity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Severity<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "56702B20-C7D4-4872-9436-7558546F8B75",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Severity",
                         "bindable": "issueSeverityName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueSeverityDesc",
                         "itemId": "issueSeverityDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Issue Severity Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Severity Description",
                         "fieldId": "F42D3A45-532E-49E7-8B54-FCF55A88BD17",
                         "bindable": "issueSeverityDesc",
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
                         "fieldId": "D163DE9B-82B2-4A65-86F9-2AA44CC5056C",
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
                         "customId": 768,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 768,
                              "customId": 419
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 768,
                              "customId": 420,
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
                              "parentId": 768,
                              "customId": 421,
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
                    "displayName": "Issue Severity",
                    "title": "Details Grid",
                    "name": "IssueSeverityGrid",
                    "itemId": "IssueSeverityGrid",
                    "restURL": "/IssueSeverity",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Issue Severity Code",
                         "dataIndex": "issueSeverityCode",
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
                         "header": "Issue Severity",
                         "dataIndex": "issueSeverityName",
                         "flex": 1
                    }, {
                         "header": "Issue Severity Description",
                         "dataIndex": "issueSeverityDesc",
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
               "displayName": "Issue Severity",
               "title": "Issue Severity",
               "name": "IssueSeverity",
               "itemId": "IssueSeverityForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueSeverityCode",
                    "itemId": "issueSeverityCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Severity Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Severity Code<font color='red'> *<\/font>",
                    "fieldId": "ACF5DE45-5D1C-47ED-AAC0-87F59E3A699C",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueSeverityCode"
               }, {
                    "name": "issueSeverityName",
                    "itemId": "issueSeverityName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Severity",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Severity<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "56702B20-C7D4-4872-9436-7558546F8B75",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid Severity",
                    "bindable": "issueSeverityName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueSeverityDesc",
                    "itemId": "issueSeverityDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Issue Severity Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Severity Description",
                    "fieldId": "F42D3A45-532E-49E7-8B54-FCF55A88BD17",
                    "bindable": "issueSeverityDesc",
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
                    "fieldId": "D163DE9B-82B2-4A65-86F9-2AA44CC5056C",
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
                    "customId": 768,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 768,
                         "customId": 419
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 768,
                         "customId": 420,
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
                         "parentId": 768,
                         "customId": 421,
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