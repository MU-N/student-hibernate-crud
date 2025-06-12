package org.nasser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {
    private final SessionFactory sessionFactory;

    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(student);
                transaction.commit();
                System.out.println("Added student: " + student);
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Error adding student: " + e.getMessage());
                throw e;
            }
        }
    }

    public Student getStudentById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.find(Student.class, id);
            if (student != null) {
                System.out.println("Retrieved student: " + student);
            } else {
                System.out.println("No student found with id: " + id);
            }
            return student;
        } catch (Exception e) {
            System.out.println("Error retrieving student with id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    public Student updateStudent(int id, String newName, int newAge) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Student student = session.find(Student.class, id);
                if (student != null) {
                    student.setName(newName);
                    student.setAge(newAge);
                    session.merge(student);
                    transaction.commit();
                    System.out.println("Updated student: " + student);
                    return student;
                } else {
                    System.out.println("No student found with id: " + id);
                    return null;
                }
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Error updating student with id " + id + ": " + e.getMessage());
                throw e;
            }
        }
    }

    public boolean deleteStudentById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Student student = session.find(Student.class, id);
                if (student != null) {
                    session.remove(student);
                    transaction.commit();
                    System.out.println("Deleted student with id: " + id);
                    return true;
                } else {
                    System.out.println("No student found with id: " + id);
                    return false;
                }
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Error deleting student with id " + id + ": " + e.getMessage());
                throw e;
            }
        }
    }
}