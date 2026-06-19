package com.example.Book;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO {

    public void save(Book book) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.persist(book);

        tx.commit();
        session.close();
    }

    public Book read(int id) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Book book = session.get(Book.class, id);

        session.close();

        return book;
    }

    public void update(Book book) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.merge(book);

        tx.commit();
        session.close();
    }

    public void delete(int id) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book != null) {
            session.remove(book);
        }

        tx.commit();
        session.close();
    }
}