Ext.define('Issuetracker.view.mainleftmenutree.MainPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'mainPanelWithLeftMenu',
	requires : [ 'Issuetracker.view.resource.ResourcePanel',
	             'Issuetracker.view.mainleftmenutree.TopPanel.TopPanel',
	             'Issuetracker.view.resource.DockedResourcePanel',
	             'Issuetracker.view.fw.mainViewPanel.MainPanelController'
	           ],
	controller:'mainViewPanelController',
	layout : 'border',
	items : [{
		    	region: 'west',
		        xtype: 'resourcePanel',
				placeholder : {
					xtype : 'dockedResourcePanel'
				},		
				placeholderCollapseHideMode : Ext.Element.DISPLAY, 
				collapsible : true,
				hideCollapseTool : true,
				titleCollapse : true
				
			}, {
		        region: 'center',
		        xtype: 'tabpanel',
		        itemId : 'appMainTabPanel',
				id : 'appMainTabPanel',
		        dockedItems : [{
					xtype : 'menuTopPanel'
				}],
				listeners:{
					afterrender:'aftrAppMainTabPanelRender'
				}
			}],
	listeners:{
		scope:'controller',
		afterrender:'afterRender'
	}
});
