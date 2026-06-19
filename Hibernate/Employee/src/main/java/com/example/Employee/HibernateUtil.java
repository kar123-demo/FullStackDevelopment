package com.example.Employee;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtil{
	private static final SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
	public static SessionFactory getSession() {
		return factory;
	}
}