var mainPanel = Ext.create("Ext.panel.Panel", {
	title : 'Junior Test main panel',
	layout : 'fit',
	closable : true,
	listeners : {

		render : function() {
			Ext.Ajax.request({
				url : 'backend/test/',
				success : function(response) {
					var result = Ext.decode(response.responseText);
					Ext.Msg.alert('Some backend feedback', result);
				}

			})
		}
	}
});

Ext.define('J.view.Viewport', {
	extend : 'Ext.container.Viewport',
	requires : [ 'Ext.layout.container.VBox' ],

	layout : 'vbox',
	items : [ mainPanel ]

});
