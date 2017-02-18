package com.orm.hibernate.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.Certificates;
import com.org.hibernate.entity.Student2;

public class OneToManyXMLConfiguratioin {

	private static SessionFactory factory;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		 try{
	         factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex);     

	}
		 OneToManyXMLConfiguratioin oneToManyXMLConfiguratioin = new OneToManyXMLConfiguratioin();
		 
		 /* Let us have a set of certificates for the first employee  */
		 HashSet set1 = new HashSet();
	      set1.add(new Certificates("MCA","AU", new Date(2010)));
	      set1.add(new Certificates("BSC","ANU",new Date(2006)));
	      set1.add(new Certificates("PPM","ANU",new Date(2003)));
	      
	      /* Add employee records in the database */
	      Integer empID1 = oneToManyXMLConfiguratioin.addStudent2("Neelima", "MUkkala",new Date(2010), set1);
	      System.out.println("SID::"+empID1);
	      
	      

}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Integer addStudent2(String fname, String lname, Date date, Set set1) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;

		try{
	         tx = session.beginTransaction();
	         Student2 student = new Student2(fname, lname, date);
	         student.setCertificates(set1);
	         employeeID = (Integer) session.save(student); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;

	}
}
