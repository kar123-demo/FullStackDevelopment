package com.example.Product1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory factory =
            new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}