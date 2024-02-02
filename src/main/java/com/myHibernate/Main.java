package com.myHibernate;

import com.myHibernate.SectionFactory.HibernateUtil;
import com.myHibernate.services.DepartmentService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

// ...

public class Main {


    public static void main(String[] args) {

        DepartmentService.createDepartment("HR Department", "Headquarters");

        DepartmentService.updateDepartment(1L, "New Location");

        DepartmentService.deleteDepartment(1L);

        DepartmentService.assignEmployeeToDepartment(2L, 1L);
    }
}
