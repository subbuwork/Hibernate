package com.orm.hibernate.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.CertificatesAnnotationsBased;
import com.org.hibernate.entity.Student2AnnotationsBased;

public class OneToManyAnnotationsBased {

	private static SessionFactory factory;
	public static void main(String[] args) {
		 try{
	         factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex);    

	}
		 OneToManyAnnotationsBased oneToManyAnnotationsBased = new OneToManyAnnotationsBased();
		 
		 /* Let us have a set of certificates for the first employee  */
		 Set<CertificatesAnnotationsBased> set1 = new HashSet<CertificatesAnnotationsBased>();
	      set1.add(new CertificatesAnnotationsBased("BPharmacy","AU", new Date(2010)));
	      set1.add(new CertificatesAnnotationsBased("MPharmacy","ANU",new Date(2006)));
	      set1.add(new CertificatesAnnotationsBased("MTech","ANU",new Date(2003)));
	      
	      /* Add employee records in the database */
	      Integer empID1 = oneToManyAnnotationsBased.addStudent2("Jason", "Bandi",new Date(2010), set1);
	      System.out.println("SID::"+empID1);
}
	private Integer addStudent2(String fname, String lname, Date date, Set<CertificatesAnnotationsBased> set1) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;

		try{
	         tx = session.beginTransaction();
	         Student2AnnotationsBased student = new Student2AnnotationsBased(fname, lname, date);
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
