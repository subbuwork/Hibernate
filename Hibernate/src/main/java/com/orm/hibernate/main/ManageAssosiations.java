/**
 * 
 */
package com.orm.hibernate.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.Address;
import com.org.hibernate.entity.Student;


/**
 * @author subbu
 *
 */
public class ManageAssosiations {

   private static SessionFactory sessionFactory = null;
	public static void main(String[] args) {
    try {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	ManageAssosiations ma = new ManageAssosiations();
        // Address address	=ma.addAddress("Machavaram","Ongole","AP",523180,"India");
    	//ma.addStudent("varsith","bandi","xavier","1st","A",address);
    	ma.addStudent();
    	
	} catch (Throwable ex) {
		System.err.println("Failed to create sessoin factory....."+ex);
		throw new ExceptionInInitializerError(ex);
	}
		
		
		
	}
	
/*	private Address addAddress(String string, String string2, String string3,
			int i, String string4) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Address address = null;
		Integer addressId = null;
		try {
			tx = session.beginTransaction();
			address = new Address(string,string2,string3,i,string4);
			addressId = (Integer) session.save(address);
		} catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return address;
	}*/
	
	private void addStudent() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Address address = null;
		
		try {
			tx = session.beginTransaction();
			address = new Address("Machavaram","Ongole","AP",523180,"India");
			Student student = new Student("niharika","bandi","Xavier","4th","A++",address);
			Student student2 = new Student("harsith","bandi","Xavier","6th","A++",address);
			session.save(student);
			session.save(student2);
			 tx.commit();
		} catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

}
