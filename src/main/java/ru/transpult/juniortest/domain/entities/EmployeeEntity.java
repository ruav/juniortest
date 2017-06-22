/**
 * 
 */
package ru.transpult.juniortest.domain.entities;

import ru.transpult.juniortest.pojo.Department;

import javax.persistence.*;

/**
 * @author AVRudnev
 *
 */

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="employees_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name = "id", unique=true, nullable=false)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surName;
//    @Column(name="department_id")
//    private int department_id;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "department_id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="empldepartment",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
//    @JoinColumn (name="department_id",referencedColumnName="department")
    private DepartmentEntity department;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name="subdepartments",
//            joinColumns = @JoinColumn(name="department_id"),
//            inverseJoinColumns = @JoinColumn(name="subdepartment_id")
//    )
//    private DepartmentEntity departments;

    public EmployeeEntity() {

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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

//    public int getDepartment_id() {
//        return department_id;
//    }
//
//    public void setDepartment_id(int department_id) {
//        this.department_id = department_id;
//    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
