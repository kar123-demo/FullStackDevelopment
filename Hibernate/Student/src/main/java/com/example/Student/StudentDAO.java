package com.example.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.Student.HibernateUtil;
import com.example.Student.Student;

public class StudentDAO {

    public void save(Student student) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }
    public Student getStudent(int id) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Student student = session.get(Student.class, id);

        session.close();

        return student;
    }

    public void updateStudent(Student student) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.merge(student);

        tx.commit();
        session.close();
    }

    public void deleteStudent(int id) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }
}