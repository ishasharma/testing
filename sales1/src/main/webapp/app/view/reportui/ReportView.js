Ext.define('Sales1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Sales1.view.reportui.querycriteria.QueryCriteriaView',
			'Sales1.view.reportui.datachart.DataChartViewTab',
			'Sales1.view.reportui.datachart.DataChartViewPanel',
			'Sales1.view.reportui.ReportViewController' ,
			'Sales1.view.fw.MainDataPointPanel',
			'Sales1.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
