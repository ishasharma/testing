Ext.define('Sales1.view.databrowsercalendar.DBCalendar', {
	extend : 'Sales1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Sales1.view.databrowsercalendar.DBCalendarController',
	             'Sales1.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
