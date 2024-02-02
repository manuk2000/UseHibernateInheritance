package com.myHibernate.services;


import com.myHibernate.entities.Department;
import com.myHibernate.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class DepartmentService {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void createDepartment(String departmentName, String location) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Department department = new Department();
            department.setDepartmentName(departmentName);
            department.setLocation(location);

            session.save(department);

            transaction.commit();
        }
    }

    public static void updateDepartment(Long departmentId, String newLocation) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                department.setLocation(newLocation);
                session.update(department);
            }

            transaction.commit();
        }
    }

    public static void deleteDepartment(Long departmentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                session.delete(department);
            }

            transaction.commit();
        }
    }

    public static void assignEmployeeToDepartment(Long departmentId, Long employeeId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Department department = session.get(Department.class, departmentId);
            Employee employee = session.get(Employee.class, employeeId);

            if (department != null && employee != null) {
                department.getEmployees().add(employee);
                employee.setDepartment(department);

                session.update(department);
                session.update(employee);
            }

            transaction.commit();
        }
    }

}
