package com.example.Book;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory= new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Book.class)
                    .buildSessionFactory();
   

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}