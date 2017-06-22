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

    private int department_id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="id")
//    private DepartmentEntity department;

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

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

//    public DepartmentEntity getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(DepartmentEntity department) {
//        this.department = department;
//    }
}
