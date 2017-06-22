package ru.transpult.juniortest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.transpult.juniortest.domain.dao.EmployeeDao;
import ru.transpult.juniortest.pojo.Employee;

import java.util.List;

/**
 * Created by RuAV on 21.06.2017.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee getById(int id){
        return employeeDao.getById(id);
    }

    public List<Employee> getByNames(String names){
        return employeeDao.getByNames(names);
    }

    public List<Employee> getAll(){
        return employeeDao.getAll();
    }

    public void removeById(int id){
        employeeDao.removeById(id);
    }

    public void add(Employee employee){
        employeeDao.add(employee);
    }

    public void update(Employee employee){
        employeeDao.update(employee);
    }

}
