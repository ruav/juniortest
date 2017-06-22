package ru.transpult.juniortest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.transpult.juniortest.domain.dao.DepartmentDao;
import ru.transpult.juniortest.domain.dao.EmployeeDao;
import ru.transpult.juniortest.pojo.Department;
import ru.transpult.juniortest.pojo.Employee;

import java.util.List;

/**
 * Created by RuAV on 21.06.2017.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public Department getById(int id){
        return departmentDao.getById(id);
    }

    public List<Department> getByNames(String names){
        return departmentDao.getByNames(names);
    }

    public List<Department> getAll(){
        return departmentDao.getAll();
    }

    public void removeById(int id){
        departmentDao.removeById(id);
    }

    public void add(Department department){
        departmentDao.add(department);
    }

    public void update(Department department){
        departmentDao.update(department);
    }

}
