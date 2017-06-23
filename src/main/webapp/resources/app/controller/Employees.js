/**
 * Created by RuAV on 23.06.2017.
 */
Ext.define('J.controller.Employees', {
    extend: 'Ext.app.Controller',

    views: ['EmployeeList', 'Employee'],
    stores: ['EmployeeStore'],
    models: ['Employees'],
    init: function() {
        this.control({
            'viewport > employeelist': {
                itemdblclick: this.editEmployee
            },
            'bookwindow button[action=new]': {
                click: this.createEmployee
            },
            'bookwindow button[action=save]': {
                click: this.updateEmployee
            },
            'bookwindow button[action=delete]': {
                click: this.deleteEmployee
            },
            'bookwindow button[action=clear]': {
                click: this.clearForm
            }
        });
    },
    // обновление
    updateEmployee: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            values = form.getValues(),
            id = form.getRecord().get('id');
        values.id=id;
        Ext.Ajax.request({
            url: 'app/data/update.php',
            params: values,
            success: function(response){
                var data=Ext.decode(response.responseText);
                if(data.success){
                    var store = Ext.widget('booklist').getStore();
                    store.load();
                    Ext.Msg.alert('Обновление',data.message);
                }
                else{
                    Ext.Msg.alert('Обновление','Не удалось обновить книгу в библиотеке');
                }
            }
        });
    },
    // создание
    createEmployee: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            values = form.getValues();
        Ext.Ajax.request({
            url: 'app/data/create.php',
            params: values,
            success: function(response, options){
                var data=Ext.decode(response.responseText);
                if(data.success){
                    Ext.Msg.alert('Создание',data.message);
                    var store = Ext.widget('booklist').getStore();
                    store.load();
                }
                else{
                    Ext.Msg.alert('Создание','Не удалось добавить книгу в библиотеку');
                }
            }
        });
    },
    // удаление
    deleteEmployee: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            id = form.getRecord().get('id');
        Ext.Ajax.request({
            url: 'app/data/delete.php',
            params: {id:id},
            success: function(response){
                var data=Ext.decode(response.responseText);
                if(data.success){
                    Ext.Msg.alert('Удаление',data.message);
                    var store = Ext.widget('booklist').getStore();
                    var record = store.getById(id);
                    store.remove(record);
                    form.getForm.reset();
                }
                else{
                    Ext.Msg.alert('Удаление','Не удалось удалить книгу из библиотеки');
                }
            }
        });
    },
    clearForm: function(grid, record) {
        var view = Ext.widget('employeewindow');
        view.down('form').getForm().reset();
    },
    editEmployee: function(grid, record) {
        var view = Ext.widget('employeewindow');
        view.down('form').loadRecord(record);
    }
});
