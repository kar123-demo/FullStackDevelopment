package com.example.Order;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory= new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Order.class)
                    .buildSessionFactory();
   

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}