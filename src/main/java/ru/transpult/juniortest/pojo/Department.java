/**
 * 
 */
package ru.transpult.juniortest.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * @author AVRudnev
 *
 */

public class Department implements Serializable{

    private long id;
    private String name;
    private Set<Department> departments;
    private Set<Employee> employees;

    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
