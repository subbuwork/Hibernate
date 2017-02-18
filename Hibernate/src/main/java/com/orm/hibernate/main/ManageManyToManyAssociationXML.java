package com.orm.hibernate.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.Certificates;
import com.org.hibernate.entity.Student2;

public class ManageManyToManyAssociationXML {
	private static SessionFactory factory; 

	public static void main(String[] args) {

		 try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		 ManageManyToManyAssociationXML ME = new ManageManyToManyAssociationXML();
	      /* Let us have a set of certificates for the first employee  */
	      Set<Certificates> certificates = new HashSet<Certificates>();

	      certificates.add(new Certificates("MCA","ANU",new Date(2007)));
	      certificates.add(new Certificates("MBA","AU", new Date(2010)));
	      certificates.add(new Certificates("PMP","JNTU", new Date(2006)));
	     
	      /* Add employee records in the database */
	      Integer sid = ME.addStudent("Manoj", "Kumar", new Date(2010), certificates);

	      /* Add another employee record in the database */
	      Integer sid2 = ME.addStudent("Dilip", "Kumar", new Date(2010), certificates);
          System.out.println("SID1::"+sid+":::SID2"+sid2);
	      /* List down all the employees */
	      ME.listStudents();;

	      /* Update employee's salary records */
	      ME.updateStudent(20, "");

	      /* Delete an employee from the database */
	      ME.deleteStudent(21);;

	      /* List down all the employees */
	      ME.listStudents();

	   }

	   /* Method to add an employee record in the database */
	   public Integer addStudent(String fname, String lname, 
	                                            Date dob, Set<Certificates> cert){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         Student2 employee = new Student2(fname, lname, dob);
	         employee.setCertificates(cert);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }

	   /* Method to list all the employees detail */
	   @SuppressWarnings({ "unchecked", "deprecation" })
	public void listStudents( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List<Student2> students = session.createQuery("FROM Student2").list(); 
	         for (Iterator<Student2> iterator1 = 
	                           students.iterator(); iterator1.hasNext();){
	            Student2 student = iterator1.next(); 
	            System.out.print("First Name: " + student.getfName()); 
	            System.out.print("  Last Name: " + student.getlName()); 
	           // System.out.println("  Salary: " + student.getSalary());
	            Set<Certificates> certificates = student.getCertificates();
	            for (Iterator<Certificates> iterator2 = 
	                         certificates.iterator(); iterator2.hasNext();){
	                  Certificates certName = (Certificates) iterator2.next(); 
	                  System.out.println("Certificate: " + certName.getdName()); 
	            }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to update salary for an employee */
	   public void updateStudent(Integer sid,  String uName){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Student2 student = 
	                    session.get(Student2.class, sid); 
	         student.setlName(uName);;
	         session.update(student);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to delete an employee from the records */
	   public void deleteStudent(Integer sid){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Student2 employee = 
	                   session.get(Student2.class, sid); 
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}

}
