Ext.define('Issuetracker.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Issuetracker.view.reportui.querycriteria.QueryCriteriaView',
			'Issuetracker.view.reportui.datachart.DataChartViewTab',
			'Issuetracker.view.reportui.datachart.DataChartViewPanel',
			'Issuetracker.view.reportui.ReportViewController' ,
			'Issuetracker.view.fw.MainDataPointPanel',
			'Issuetracker.view.googlemaps.map.MapPanel'
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
