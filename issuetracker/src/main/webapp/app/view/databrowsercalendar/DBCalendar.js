Ext.define('Issuetracker.view.databrowsercalendar.DBCalendar', {
	extend : 'Issuetracker.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Issuetracker.view.databrowsercalendar.DBCalendarController',
	             'Issuetracker.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
