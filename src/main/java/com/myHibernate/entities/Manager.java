package com.myHibernate.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "manager")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Manager extends Employee {

    @Enumerated(EnumType.STRING)
    @Column(name = "management_level")
    private ManagementLevel managementLevel;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department managedDepartment;

}

