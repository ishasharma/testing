Ext.define('Sales1.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Sales1.view.reportui.datachart.DataChartTController',
	             'Sales1.view.reportui.datachart.datagrid.DataGridView',
	             'Sales1.view.reportui.datachart.chart.ChartTabView',
	             'Sales1.view.reportui.datachart.ChartPointView' ],
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