/**
 * Created by RuAV on 23.06.2017.
 */

Ext.define('J.view.EmployeeList' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.employeelist',

    title: 'Список работников',
    store: 'EmployeeStore',

    initComponent: function() {
        this.columns = [
            {header: 'Имя',  dataIndex: 'name',  flex: 1},
            {header: 'Фамилия',  dataIndex: 'surName',  flex: 1},
            {header: 'Департамент', dataIndex: 'department.name', flex: 1}
        ];

        this.callParent(arguments);
    }
});
