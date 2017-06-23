Ext.Loader.setPath('J', 'resources/frontend');
Ext.Loader.setConfig({
  enabled : true
});


Ext.application({
  name : 'J',
  appFolder : 'resources/app',
  autoCreateViewport : true,
  requires : ['Ext.container.Viewport'],
  layout : 'fit',
    controllers: ['Employees'],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'employeelist'
            }
        });
    }
  
});
