/**
 * Created by RuAV on 23.06.2017.
 */

Ext.define('J.view.Employee', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeewindow',

    title: 'Сотрудник',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [{
            xtype: 'form',
            items: [{
                xtype: 'textfield',
                name : 'name',
                fieldLabel: 'Имя'
            },{
                xtype: 'textfield',
                name : 'surName',
                fieldLabel: 'Фамилия'
            },{
                xtype: 'numberfield',
                name : 'department.name',
                fieldLabel: 'Департамент',
                minValue: 1,
            }]
        }];
        this.dockedItems=[{
            xtype:'toolbar',
            docked: 'top',
            items: [{
                text:'Создать',
                iconCls:'new-icon',
                action: 'new'
            },{
                text:'Сохранить',
                iconCls:'save-icon',
                action: 'save'
            },{
                text:'Удалить',
                iconCls:'delete-icon',
                action: 'delete'
            }]
        }];
        this.buttons = [{
            text: 'Очистить',
            scope: this,
            action: 'clear'
        }];

        this.callParent(arguments);
    }
});
