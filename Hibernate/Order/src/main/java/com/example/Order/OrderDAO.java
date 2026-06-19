package com.example.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrderDAO {

  

    public void save(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(order);

        tx.commit();
        session.close();
    }

    public Order getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Order order = session.get(Order.class, id);

        session.close();
        return order;
    }

    public void update(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(order);

        tx.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Order order = session.get(Order.class, id);

        if (order != null) {
            session.remove(order);
        }

        tx.commit();
        session.close();
    }
}