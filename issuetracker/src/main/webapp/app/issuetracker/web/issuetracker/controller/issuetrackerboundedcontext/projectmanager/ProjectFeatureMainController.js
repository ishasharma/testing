Ext.define('Issuetracker.issuetracker.web.issuetracker.controller.issuetrackerboundedcontext.projectmanager.ProjectFeatureMainController', {
     extend: 'Issuetracker.view.fw.frameworkController.AggregateViewController',
     alias: 'controller.ProjectFeatureMainController',
     init: function() {
          var form = this.view.down('#ProjectFeatureForm');
          this.updateFormUI(form, 'Save', true);
          form.reset();
          if (this.view.disableDB != null && this.view.disableDB) {
               this.hideDataBrowser();
          } else {
               this.renderTreeGridData();
          }
          this.contactIdLoad();
          this.projectIdLoad();
     },
     contactIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/CoreContacts/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#contactId');
                    scope.sender.controller.assignAllComboData(scope.sender, 'contactId', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#contactId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     projectIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/CreateProject/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#projectId');
                    scope.sender.controller.assignAllComboData(scope.sender, 'projectId', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#projectId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     onProjectIdChange: function(me, newValue, oldValue, eOpts) {
          this.onProjectIdChangeModuleId(me, newValue, oldValue, eOpts);
     },
     onProjectIdChange: function(me, newValue, oldValue, eOpts) {
          this.onProjectIdChangeModuleId(me, newValue, oldValue, eOpts);
          this.onProjectIdChangeFeatureId(me, newValue, oldValue, eOpts);
     },
     onModuleIdChange: function(me, newValue, oldValue, eOpts) {
          this.onModuleIdChangeFeatureId(me, newValue, oldValue, eOpts);
     },
     onProjectIdChangeModuleId: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/ProjectModule/findByProjectId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var moduleIdCombo = scope.element.up('form').down('#moduleId');
                    scope.sender.controller.assignComboData(moduleIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, moduleIdCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onProjectIdChangeModuleId: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/ProjectModule/findByProjectId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var moduleIdCombo = scope.element.up('form').down('#moduleId');
                    scope.sender.controller.assignComboData(moduleIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, moduleIdCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onProjectIdChangeFeatureId: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/ProjectFeature/findByProjectId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var featureIdCombo = scope.element.up('form').down('#featureId');
                    scope.sender.controller.assignComboData(featureIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, featureIdCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onModuleIdChangeFeatureId: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/ProjectFeature/findByModuleId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var featureIdCombo = scope.element.up('form').down('#featureId');
                    scope.sender.controller.assignComboData(featureIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, featureIdCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onProjectIdChange: function(me, newValue, oldValue, eOpts) {
          this.onProjectIdChangeModuleId(me, newValue, oldValue, eOpts);
          this.onProjectIdChangeFeatureId(me, newValue, oldValue, eOpts);
     },
     onModuleIdChange: function(me, newValue, oldValue, eOpts) {
          this.onModuleIdChangeFeatureId(me, newValue, oldValue, eOpts);
     },
     onProjectIdChangeModuleId: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/ProjectModule/findByProjectId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var moduleIdCombo = scope.element.up('form').down('#moduleId');
                    scope.sender.controller.assignComboData(moduleIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, moduleIdCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onProjectIdChangeFeatureId: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/ProjectFeature/findByProjectId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var featureIdCombo = scope.element.up('form').down('#featureId');
                    scope.sender.controller.assignComboData(featureIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, featureIdCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     onModuleIdChangeFeatureId: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/ProjectFeature/findByModuleId',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var featureIdCombo = scope.element.up('form').down('#featureId');
                    scope.sender.controller.assignComboData(featureIdCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, featureIdCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     updateFormUI: function(form, status, butText) {
          for (var index = 0; index < form.items.items.length; index++) {
               var item = form.items.items[index];
               if (item.xtype == 'form' || item.xtype == 'panel') {
                    this.updateFormUI(item, status);
               }
               if (item.isCompositeKey) {
                    if (status == 'Save') {
                         item.setDisabled(false);
                    } else if (status == 'Update') {
                         item.setDisabled(true);
                    }
               }
          }
          if (butText) {
               if (status == 'Save') {
                    form.down('#saveFormButton').setText('Save');
               } else if (status == 'Update') {
                    form.down('#saveFormButton').setText('Update');
               }
          }
     },
     renderTreeGridData: function(responseData) {
          if (responseData == null) {
               responseData = this.fetchDataAjaxCall();
          }
          if (responseData.response.success) {
               var data = responseData.response.data;
               var tree = this.view.down('#ProjectFeatureTree');
               var rootNode = tree.getRootNode();
               rootNode.removeAll();
               for (var index = 0; index < data.length; index++) {
                    var childNode = {
                         text: data[index].primaryDisplay,
                         bConfig: data[index],
                         leaf: true,
                         icon: 'images/table_icon.png'
                    };
                    rootNode.appendChild(childNode);
               }
               tree.getStore().sort('text', 'ASC');
               this.setGridData(data);
               var compRef = this.view.down('#ProjectFeatureTree');
          } else if (!sessionTimeOutFlag) {
               Ext.Msg.alert('Server Response', responseData.response.message);
          }
     },
     /*********************Main Controller Functions*********************************/
     onDeleteActionColumnClickMainGrid: function(grid, rowIndex) {
          var recordId = grid.store.data.items[rowIndex].data.primaryKey;
          me = this;
          Ext.MessageBox.confirm({
               title: 'Confirm',
               msg: 'Delete Record',
               buttons: Ext.MessageBox.YESNO,
               fn: function(clickedButtonId) {
                    if (clickedButtonId == 'yes') {
                         me.deleteRecord(recordId);
                    }
               },
               animateTarget: this,
               icon: Ext.MessageBox.QUESTION
          })
     },
     deleteRecord: function(recordId) {
          var restURL = this.view.restURL;
          var url = 'secure' + restURL + '/' + recordId;
          var jsonData = {};
          Ext.Ajax.request({
               url: url,
               method: 'DELETE',
               jsonData: jsonData,
               success: function(response, opts) {
                    if (response.status == 204) {
                         Ext.Msg.alert('Server Response', 'Record Deleted Successfully');
                         me.refreshMainForm(but, responseData.response.data, opts.method);
                    } else {
                         responseData = Ext.JSON.decode(response.responseText);
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
     resetForm: function(but) {
          var form = but.up('form');
          form.down('#saveFormButton').setText('Save');
          form.reset();
          var grid = this.view.down('#ProjectFeatureGrid');
          var tree = this.view.down('#ProjectFeatureTree');
          tree.setSelection();
          grid.setSelection();
          var gridFeatureUserMapping = but.up('form').down('#FeatureUserMappingGrid');
          gridFeatureUserMapping.getStore().removeAll();
          gridFeatureUserMapping.reconfigure();
     },
     hideDataBrowser: function() {
          var form = this.view.down('#ProjectFeature');
          var grid = this.view.down('#ProjectFeatureGrid');
          var tree = this.view.down('#ProjectFeatureTreeContainer');
          this.view.down('#addNewForm').destroy();
          grid.setHidden(true);
          tree.setHidden(true);
          if (this.view.primaryKey != null) {
               this.findById(this.view.primaryKey);
          }
     },
     fetchDataAjaxCall: function() {
          var url = this.getView().restURL;
          var me = this;
          var data = null;
          Ext.Ajax.request({
               url: 'secure' + url + '/findAll',
               method: 'GET',
               maskEnable: true,
               async: false,
               jsonData: {},
               success: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    data = responseData;
                    me.addCommunicationLog(response, true);
               },
               failure: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
                    me.addCommunicationLog(response, false);
               }
          }, this);
          return data;
     },
     onTreeRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          var tree = this.view.down('#ProjectFeatureTree');
          var rootNode = tree.getRootNode();
          rootNode.removeAll();
          for (var index = 0; index < data.length; index++) {
               var childNode = {
                    text: data[index].primaryDisplay,
                    bConfig: data[index],
                    leaf: true,
                    icon: 'images/table_icon.png'
               };
               rootNode.appendChild(childNode);
          }
          tree.getStore().sort('text', 'ASC');
     },
     onGridRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          this.setGridData(data);
     },
     refreshMainForm: function(but, data, method) {
          var formPanel = this.view.down('#ProjectFeatureForm');
          this.updateFormUI(formPanel, 'Save', true); /** Adding data to tree and grid */
          if (data != null) {
               var grid = this.view.down('#ProjectFeatureGrid');
               var tree = this.view.down('#ProjectFeatureTree');
               if (method == 'PUT') {
                    if (!(data instanceof Object)) {
                         var data = {
                              'findKey': data
                         };
                    }
                    data = this.findRecordById(this.view.restURL, data);
                    grid.getSelectionModel().selected.items[0].data = data;
                    grid.reconfigure();
                    var node = this.findChild(tree.getRootNode(), 'primaryKey', data.primaryKey);
                    if (node) {
                         node.set('text', data.primaryDisplay);
                         node.bConfig = data;
                         tree.reconfigure();
                    }
               } else {
                    grid.store.add(data);
                    var rootNode = tree.getRootNode();
                    var childNode = {
                         text: data.primaryDisplay,
                         bConfig: data,
                         leaf: true,
                         icon: 'images/table_icon.png'
                    };
                    rootNode.appendChild(childNode);
               }
          }
          if (but != null) {
               this.resetForm(but);
          } else {
               var but = this.view.down('#resetFormButton');
               this.resetForm(but);
          }
     },
     /********************************Tree Controller Functions**********************************/
     onFilterClick: function(but, evt) {
          var currentObject = this.getView();
          var form = but.up('form');
          if (!form.isValid()) {
               return;
          }
          var searchData = this.getData(form);
          Ext.Ajax.request({
               url: 'secure' + currentObject.restURL + '/search',
               method: 'POST',
               maskEnable: true,
               maskEle: currentObject,
               view: currentObject,
               jsonData: Ext.JSON.encode(searchData),
               success: function(response, currentObject) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    currentObject.view.controller.renderTreeGridData(responseData);
               },
               failure: function(response, currentObject) {
                    Ext.MessageBox.show({
                         title: 'Error',
                         msg: response.statusText,
                         icon: Ext.MessageBox.ERROR
                    });
                    var currentView = currentObject.view;
                    var compRef = scope.sender.view.down('#ProjectFeatureTree');
                    currentView.controller.addCommunicationLog(response, false, compRef);
               }
          });
     },
     treeClick: function(me, record, item, index, e, eOpts) {
          var primaryKey = record.data.bConfig.primaryKey;
          if (record.data.leaf) {
               var ProjectFeature = this.view.down('#ProjectFeatureForm');
               ProjectFeature.reset();
               var gridPanel = this.view.down('#ProjectFeatureGrid');
               var foundRecord = gridPanel.store.findRecord('primaryKey', primaryKey);
               if (gridPanel && foundRecord) {
                    gridPanel.setSelection(foundRecord);
               }
          }
          var formPanel = this.getView().up().down('#ProjectFeatureForm');
          formPanel.down('#saveFormButton').setText('Update');
          var vm = formPanel.getViewModel(); /** Finding record by id */
          jsonData = {
               'findKey': primaryKey
          }
          var data = this.findRecordById(this.view.restURL, jsonData);
          this.modifyComponents(data, formPanel);
          this.updateFormUI(formPanel, 'Update', true);
          var FeatureUserMappingGrid = formPanel.down('#FeatureUserMappingGrid');
          FeatureUserMappingGrid.store.loadData(data.featureUserMapping);
          FeatureUserMappingGrid.setSelection(0);
          this.showFirstCard(formPanel);
          tabPanel = formPanel.up('tabpanel');
          tabPanel.setActiveTab(0);
     },
     /********************************Grid Controller Functions***********************************/
     onGridItemClick: function(me, record, item, index, e, eOpts) {
          var primaryKey = record.data.primaryKey;
          jsonData = {
               'findKey': primaryKey
          } /** Finding record by id */
          record.data = this.findRecordById(this.view.restURL, jsonData);
          var treePanel = this.view.up().up().down('#ProjectFeatureTree');
          var foundNode = this.findChild(treePanel.getRootNode(), 'primaryKey', primaryKey);
          if (treePanel && foundNode) {
               treePanel.setSelection(foundNode);
          }
          var formPanel = this.getView().up().down('#ProjectFeatureForm');
          formPanel.down('#saveFormButton').setText('Update');
          var data = record.data;
          this.modifyComponents(data, formPanel);
          this.updateFormUI(formPanel, 'Update', true);
          var FeatureUserMappingGrid = formPanel.down('#FeatureUserMappingGrid');
          FeatureUserMappingGrid.store.loadData(data.featureUserMapping);
          FeatureUserMappingGrid.setSelection(0);
          this.showFirstCard(formPanel);
          tabPanel = formPanel.up('tabpanel');
          tabPanel.setActiveTab(0);
     },
     renderFormValue: function(val, me) {
          store = this.view.up().down('#ProjectFeature').down('#' + me.column.dataIndex + '').store;
          if (store.data.length == 0) {
               return '';
          }
          var displayValue = store.findRecord('primaryKey', val).data.primaryDisplay;
          return displayValue != null ? displayValue : '';
     },
     setGridData: function(data) {
          var gridStore = this.view.down('#ProjectFeatureGrid').store;
          gridStore.removeAll();
          gridStore.add(data);
          gridStore.sort('primaryDisplay', 'ASC');
     },
     /********************************Form Controller Functions***********************************/
     findById: function(primaryKey) {
          var me = this;
          var restURL = this.view.restURL;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/findById',
               method: 'POST',
               controller: me,
               jsonData: {
                    'findKey': primaryKey
               },
               success: function(response, request) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         request.controller.loadData(responseData);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
               }
          }, this);
     },
     loadData: function(responseData) {
          var formPanel = this.getView().up().down('#ProjectFeatureForm');
          this.modifyComponents(responseData, formPanel);
     },
     fetchDataFromStore: function(store) {
          storeItems = store.data.items;
          obj = {};
          arr = [];
          for (counter in storeItems) {
               arr.push(storeItems[counter].data);
          }
          return obj['objArr'] = arr;
     },
     addFeatureUserMapping: function(but) {
          var formFeatureUserMapping = but.up().down('form');
          var gridFeatureUserMapping = but.up().up().down('#FeatureUserMappingGrid');
          if (formFeatureUserMapping.isValid()) {
               var values = this.getData(formFeatureUserMapping);
               values = values[gridFeatureUserMapping.bindable];
               if (gridFeatureUserMapping.selection) {
                    gridFeatureUserMapping.selection.data = values;
               } else {
                    gridFeatureUserMapping.getStore().add(values);
               }
               gridFeatureUserMapping.reconfigure();
               formFeatureUserMapping.reset();
               gridFeatureUserMapping.setSelection();
          }
     },
     onFeatureUserMappingGridItemClick: function(cellModel, record, rowIndex, columnIndex, eOpts, comp) {
          var form;
          if (comp != null) {
               form = comp.up();
          } else {
               form = this.view.down('#FeatureUserMappingForm');
          }
          form.loadRecord(record)
     },
     renderFormValue: function(value, metaData, record, row, col, store, gridView) {
          try {
               var comboStore = this.getView().down('#' + metaData.column.dataIndex).getStore();
               var index = comboStore.findExact('primaryKey', value);
               return comboStore.getAt(index).data.primaryDisplay;
          } catch (e) {
               return value;
          }
     },
     saveForm: function(but, evt) {
          var form = but.up('form');
          var firstCard = form.down('#form0');
          if (!firstCard.getForm().isValid()) {
               this.showCard(form, firstCard);
               return;
          }
          var FeatureUserMappingForm = form.down('#FeatureUserMappingForm');
          var FeatureUserMapping = form.down('#FeatureUserMappingGrid');
          if (!(FeatureUserMappingForm.isValid() || FeatureUserMapping.store.getCount() != 0)) {
               this.showCard(form, FeatureUserMappingForm);
               return;
          }
          this.addFeatureUserMapping(FeatureUserMappingForm.down('button'));
          var jsonData = this.getData(form);
          var method;
          if (but.text == 'Save') {
               method = 'POST'
          } else if (but.text == 'Update') {
               method = 'PUT';
               jsonData.systemInfo = {
                    'activeStatus': 1
               }
          }
          restURL = this.view.restURL;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/',
               but: but,
               method: method,
               maskEnable: true,
               maskEle: form,
               jsonData: jsonData,
               success: function(response, opts) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                         me.refreshMainForm(but, responseData.response.data, opts.method);
                    } else {
                         me.responseHandler(responseData.response);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
});