Ext.define('Issuetracker.issuetracker.web.issuetracker.view.issuetrackerboundedcontext.issuetracker.FeatureCategoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "FeatureCategoryMainController",
     "restURL": "/FeatureCategory",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.issuetracker.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel", "Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.issuetracker.FeatureCategoryMainController", "Issuetracker.issuetracker.shared.issuetracker.viewmodel.issuetrackerboundedcontext.issuetracker.FeatureCategoryViewModel"],
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
               "displayName": "Feature Category",
               "name": "FeatureCategoryTreeContainer",
               "itemId": "FeatureCategoryTreeContainer",
               "restURL": "/FeatureCategory",
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
                    "itemId": "FeatureCategoryTree",
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
                         "name": "featureCategoryName",
                         "itemId": "featureCategoryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Feature Category Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Feature Category Name",
                         "fieldId": "4CCED164-CBAE-44F4-AB64-C1AB8307AD30",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Feature Category",
                         "bindable": "featureCategoryName"
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
                    "displayName": "Feature Category",
                    "title": "Feature Category",
                    "name": "FeatureCategory",
                    "itemId": "FeatureCategoryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "featureCategoryCode",
                         "itemId": "featureCategoryCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Feature Category Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Feature Category Code<font color='red'> *<\/font>",
                         "fieldId": "36984C08-EDB1-4951-9AE6-83DF04DCC26F",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "featureCategoryCode"
                    }, {
                         "name": "featureCategoryName",
                         "itemId": "featureCategoryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Feature Category Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Feature Category Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4CCED164-CBAE-44F4-AB64-C1AB8307AD30",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Feature Category",
                         "bindable": "featureCategoryName",
                         "columnWidth": 0.5
                    }, {
                         "name": "featureCategoryDesc",
                         "itemId": "featureCategoryDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Feature Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Feature Description",
                         "fieldId": "5CA2E099-3E5E-4CD7-9760-1497F6E3D5B6",
                         "bindable": "featureCategoryDesc",
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
                         "fieldId": "E81FDF31-3728-4754-9FB2-9DFA392FBEDF",
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
                         "customId": 286,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 286,
                              "customId": 469
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 286,
                              "customId": 470,
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
                              "parentId": 286,
                              "customId": 471,
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
                    "displayName": "Feature Category",
                    "title": "Details Grid",
                    "name": "FeatureCategoryGrid",
                    "itemId": "FeatureCategoryGrid",
                    "restURL": "/FeatureCategory",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Feature Category Code",
                         "dataIndex": "featureCategoryCode",
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
                         "header": "Feature Category Name",
                         "dataIndex": "featureCategoryName",
                         "flex": 1
                    }, {
                         "header": "Feature Description",
                         "dataIndex": "featureCategoryDesc",
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
               "displayName": "Feature Category",
               "title": "Feature Category",
               "name": "FeatureCategory",
               "itemId": "FeatureCategoryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "featureCategoryCode",
                    "itemId": "featureCategoryCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Feature Category Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Feature Category Code<font color='red'> *<\/font>",
                    "fieldId": "36984C08-EDB1-4951-9AE6-83DF04DCC26F",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "featureCategoryCode"
               }, {
                    "name": "featureCategoryName",
                    "itemId": "featureCategoryName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Feature Category Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Feature Category Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4CCED164-CBAE-44F4-AB64-C1AB8307AD30",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid Feature Category",
                    "bindable": "featureCategoryName",
                    "columnWidth": 0.5
               }, {
                    "name": "featureCategoryDesc",
                    "itemId": "featureCategoryDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Feature Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Feature Description",
                    "fieldId": "5CA2E099-3E5E-4CD7-9760-1497F6E3D5B6",
                    "bindable": "featureCategoryDesc",
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
                    "fieldId": "E81FDF31-3728-4754-9FB2-9DFA392FBEDF",
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
                    "customId": 286,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 286,
                         "customId": 469
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 286,
                         "customId": 470,
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
                         "parentId": 286,
                         "customId": 471,
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