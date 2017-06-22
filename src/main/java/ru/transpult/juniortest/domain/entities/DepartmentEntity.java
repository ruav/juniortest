/**
 * 
 */
package ru.transpult.juniortest.domain.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * @author AVRudnev
 *
 */

@Entity
@Table(name = "departments")
public class DepartmentEntity {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="departments_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name = "department", unique=true, nullable=false)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="subdepartments",
            joinColumns = @JoinColumn(name="department_id"),
            inverseJoinColumns = @JoinColumn(name="subdepartment")
    )
    private Set<DepartmentEntity> departments;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name="empldepartment",
//            joinColumns = @JoinColumn(name = "department_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id")
//    )
    private Set<EmployeeEntity> employees;

    public DepartmentEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<DepartmentEntity> departments) {
        this.departments = departments;
    }

    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
