package ru.transpult.juniortest.domain.dao.impl;

import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.transpult.juniortest.domain.dao.EmployeeDao;
import ru.transpult.juniortest.domain.entities.DepartmentEntity;
import ru.transpult.juniortest.domain.entities.EmployeeEntity;
import ru.transpult.juniortest.pojo.Department;
import ru.transpult.juniortest.pojo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuAV on 21.06.2017.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Qualifier(value = "employeeMapper")
    MapperFacade mapperFacade;

    private static Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    public EmployeeDaoImpl() {
    }

    @Override
    public Employee getById(int id) {

        Employee employee = new Employee();
//        entityManager.getTransaction().begin();

        EmployeeEntity emp = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);
        if(emp != null) {
            mapperFacade.map(emp,employee);
        }
//        entityManager.getTransaction().commit();
        entityManager.close();

        return employee;

    }

    @Override
    public List<Employee> getByNames(String names) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();


//        entityManager.getTransaction().begin();

        Query q = entityManager.createQuery("select b from EmployeeEntity b", EmployeeEntity.class);
        List<EmployeeEntity> employeeEntities = q.getResultList();

        for(EmployeeEntity ee: employeeEntities){
            Employee employee = new Employee();
             mapperFacade.map(ee,employee);
//             Department department = new Department();
//             mapperFacade.map(ee.getDepartment(), department);
//             employee.setDepartment(department);
            employees.add(employee);
            System.out.println(employee.toString());
        }

//        entityManager.getTransaction().commit();
        entityManager.close();

        return employees;
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }
}
