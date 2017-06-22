package ru.transpult.juniortest.domain.dao.impl;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.transpult.juniortest.domain.dao.DepartmentDao;
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
 * Created by RuAV on 22.06.2017.
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Qualifier(value = "departmentMapper")
    MapperFacade mapperFacade;

    @Override
    public Department getById(int id) {
        return null;
    }

    @Override
    public List<Department> getByNames(String names) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();


//        entityManager.getTransaction().begin();

        Query q = entityManager.createQuery("select b from DepartmentEntity b", DepartmentEntity.class);
        List<DepartmentEntity> entities = q.getResultList();

        for(DepartmentEntity de: entities){
            Department department = new Department();
            mapperFacade.map(de,department);
//             Department department = new Department();
//             mapperFacade.map(ee.getDepartment(), department);
//             employee.setDepartment(department);
            departments.add(department);
            System.out.println(department.toString());
        }

//        entityManager.getTransaction().commit();
        entityManager.close();

        return departments;
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public void add(Department department) {

    }

    @Override
    public void update(Department department) {

    }
}
