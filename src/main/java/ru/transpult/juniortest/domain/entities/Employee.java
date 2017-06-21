/**
 * 
 */
package ru.transpult.juniortest.domain.entities;

import javax.persistence.*;

/**
 * @author AVRudnev
 *
 */

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="employees_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name = "id", unique=true, nullable=false)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surName;

//    @Column(name = "department_id", unique=true, nullable=false)
//    private Department department;

    public Employee() {

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

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
}
