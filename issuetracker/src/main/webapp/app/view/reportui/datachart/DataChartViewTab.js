Ext.define('Issuetracker.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Issuetracker.view.reportui.datachart.DataChartTController',
	             'Issuetracker.view.reportui.datachart.datagrid.DataGridView',
	             'Issuetracker.view.reportui.datachart.chart.ChartTabView',
	             'Issuetracker.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});