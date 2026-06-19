package com.example.Product1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

    public void save(Product product) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.persist(product);

        tx.commit();
        session.close();
    }
}