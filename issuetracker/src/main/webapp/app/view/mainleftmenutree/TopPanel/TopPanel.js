Ext.define('Issuetracker.view.mainleftmenutree.TopPanel.TopPanel', {
	extend : 'Ext.toolbar.Toolbar',
	xtype : 'menuTopPanel',
	requires : [ 'Issuetracker.view.mainleftmenutree.TopPanel.TopPanelController' ],
	controller : 'menuTopPanelController',
	style : {
		backgroundColor: "#fff"
	},
	margin : '0 0 2 0',
	layout :'hbox',
	items : [{
		xtype : 'button',
		icon : 'images/menu/menu.png', 
		style : {
			backgroundColor: "transparent",
			border : 0
		},
		scale : 'medium',		
		action : 'menuBtnToggle',
		itemId: 'appplicationMainMenuBtn',
		pressed : true,
		tooltip : 'Menu',
		enableToggle : true
	},{
		xtype:'textfield',
		itemId:'searchField',
		emptyText:'Search',
        id:"topPanelSearchTextBox",
		height:30,
		hidden : true,  
		plugins:'responsive',
		responsiveConfig:{
			portrait: {
				width:'17%',
	        },
	        landscape: {
	        	width:'35%',
	        }
		}
	},{
		xtype:'combobox',
		itemId : 'Lang',
		height:30,
		hidden : true,   
		valueField : 'value',
		displayField : 'name',
		listeners : {
		},
		plugins:'responsive',
		responsiveConfig:{
			portrait: {
				width:'13%',
	        },
	       landscape: {
	        	width:'8%',
	        }
		}
	},
	{
		xtype : 'button',
		name : 'img',
		itemId : 'voice',
		icon : 'images/menu/mic.png',
		scale : 'medium',
		hidden : true,  
		tooltip:'voice search',
		style : {
			backgroundColor: "transparent",
			border : 0
		},
		listeners:{
			click:'onVoiceSearchClick'
		}
	},{
		xtype:'button',
		icon:'images/menu/search.png',
		style : {
			backgroundColor: "transparent",
			border : 0
		},
		scale:'medium',
		tooltip:'search',
		id:"topPanelSearchButton",
		hidden : true,  
		listeners : {
			click : 'onSearchClick'
		}
	},{
		xtype: 'tbfill'
	}, '->',
	{
		xtype:'displayfield',
		itemId:'userNameDField'
	},{
		xtype:'splitbutton',
		itemId:'userDp',
		/*icon:'images/user/userdp.png',*/
		height:48,
		width:48,
		cls:'topToolbarSplitBtnAfter',
		scale: "large",
		style: "border:0;background-color:#fff;padding-bottom:0px;border-radius: 50%;background-image: url('images/user/userdp.png');background-repeat: no-repeat;",
		menu:[
		      {
		    	  text:'My Profile',
		    	  icon:'images/menu/myprofile.png',
		    	  listeners:{
						click:'onMyProfileClick',
		    	  }
		      },{
		    	  text:'Change Password',
		    	  icon:'images/menu/pwdReset.png',
		    	  listeners:{
						click:'onChangePwdClick',
		    	  }
		      },'-',
		      {
		    	  text:'Cloud Drive',
		    	  icon:'images/menu/clouddrive.png',
		    	  disabled : true,
		    	  listeners:{
						click:'onCloudClick',
		    	  }
		      },'-',
		      {
		    	  text:'Log Out',
		    	  icon:'images/menu/logout.png',
		    	  listeners:{
						click:'onLogoutClick',
		    	  }
		      }]
	}],
	listeners:{
		scope:'controller',
		afterrender:'afterTopPanelRender'
	}
});
