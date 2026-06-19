package com.example.Employee;

import org.hibernate.Session;
import org.hibernate.Transaction;

class EmployeeDAO{
	public void save(Employee e) {
		Session session =HibernateUtil.getSession().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(e);
		tx.commit();
		session.close();
	}
	public Employee read(int id) {
		Session ss=HibernateUtil.getSession().openSession();
		Employee e=ss.get(Employee.class, id);
		ss.close();
		return e;
	}
	public void update(Employee e) {
		Session ss=HibernateUtil.getSession().openSession();
		Transaction tx=ss.beginTransaction();
		ss.merge(e);
		tx.commit();
		ss.close();
	}
	public void delete(int id) {
		Session ss=HibernateUtil.getSession().openSession();
		Transaction tx=ss.beginTransaction();
		Employee e=ss.get(Employee.class, id);
		if(e!=null) ss.remove(e);
		tx.commit();
		ss.close();
	}
}