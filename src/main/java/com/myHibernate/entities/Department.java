package com.myHibernate.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "location")
    private String location;



    @OneToOne(mappedBy = "managedDepartment")
    private Manager departmentHead;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    // Constructors, getters, setters, and other methods
}
