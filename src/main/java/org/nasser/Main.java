package org.nasser;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    // Initialize SessionFactory once
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO(sessionFactory);
        dao.addStudent(new Student("David", 30));
        dao.getStudentById(2);
        dao.updateStudent(2, "Axel", 50);
        dao.deleteStudentById(3);
        // Close SessionFactory when done
        sessionFactory.close();
    }
}