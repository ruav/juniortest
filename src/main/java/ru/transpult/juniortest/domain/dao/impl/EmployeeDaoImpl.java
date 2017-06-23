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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RuAV on 21.06.2017.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Qualifier(value = "employeeMapper")
    MapperFacade employeeMapperFacade;

    @Autowired
    @Qualifier(value = "departmentMapper")
    MapperFacade departmentMapperFacade;
    private static Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    public EmployeeDaoImpl() {
    }

    @Override
    public Employee getById(int id) {

        Employee employee = new Employee();

//        entityManager.getTransaction().begin();

        EmployeeEntity emp = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);
        if(emp != null) {
            Department department = new Department();
            employeeMapperFacade.map(employee, emp);
            departmentMapperFacade.map(emp.getDepartment(),department);
            employee.setDepartment(department);
        }
        entityManager.close();

        return employee;

    }

    @Override
    public List<Employee> getByNames(String names) {

        List<Employee> employees = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder.createQuery(EmployeeEntity.class);

        Root<EmployeeEntity> employeeEntityRoot = criteriaQuery.from(EmployeeEntity.class);

//        entityManager.getTransaction().begin();
        criteriaQuery.where(criteriaBuilder.or(criteriaBuilder.like(criteriaBuilder.lower(employeeEntityRoot.get("name")), names.toLowerCase()+"%"),
                criteriaBuilder.like(criteriaBuilder.lower(employeeEntityRoot.get("surName")), names.toLowerCase()+"%")));



        List<EmployeeEntity> result = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.close();

        employees = result.stream()
            .map((e) -> employeeMapperFacade.map(e, Employee.class))
            .collect(Collectors.toList());

//        employees
//            .forEach((e) -> {
//                e.getDepartment().setDepartments(new HashSet<>());
//                e.getDepartment().setEmployees(new HashSet<>());
//            });

        for(Employee employee : employees){
            if(employee.getDepartment() != null) {
                employee.getDepartment().setDepartments(new HashSet<>());
                employee.getDepartment().setEmployees(new HashSet<>());
            }
        }

        return employees;

    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        TypedQuery<EmployeeEntity> q = entityManager.createQuery("select b from EmployeeEntity b", EmployeeEntity.class);

//        entityManager.getTransaction().begin();

        List<EmployeeEntity> employeeEntities = q.getResultList();

        for(EmployeeEntity ee: employeeEntities){
            Employee employee = new Employee();
             employeeMapperFacade.map(ee,employee);
            if(ee.getDepartment() != null) {
                Department department = new Department();
                departmentMapperFacade.map(ee.getDepartment(),department);
                department.setEmployees(new HashSet<>());
                department.setDepartments(new HashSet<>());
                employee.setDepartment(department);
                employee.setDepartment_id(ee.getDepartment().getId());
            }
            employees.add(employee);
            System.out.println(employee.toString());
        }

        entityManager.close();

        return employees;
    }

    @Override
    public void removeById(int id) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void add(Employee employee) {

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName(employee.getName());
        employeeEntity.setSurName(employee.getSurName());

        entityManager.getTransaction().begin();
            entityManager.persist(employeeEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Employee employee) {

        EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, employee.getId());

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentMapperFacade.map(employee.getDepartment(), departmentEntity);


        entityManager.getTransaction().begin();

            employeeEntity.setName(employee.getName());
            employeeEntity.setSurName(employee.getSurName());
            employeeEntity.setDepartment(departmentEntity);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
