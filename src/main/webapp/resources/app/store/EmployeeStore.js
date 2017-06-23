/**
 * Created by RuAV on 23.06.2017.
 */


Ext.define('J.store.EmployeeStore', {
    extend: 'Ext.data.Store',
    model: 'J.model.Employee',
    autoLoad: true,
    storeId: 'EmployeeStore',
    proxy: {
        type: 'ajax',
        url: 'backend/employee/all',
        reader: {
            type: 'json'
            // ,
            // root: 'books',
            // successProperty: 'success'
        }
    }
});