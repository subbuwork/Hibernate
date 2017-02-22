/**
 * This clazz to manage employee CRUD opetations..
 */
package com.orm.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.Employee;

/**
 * @author subbu
 *
 */
public class MangeEmployee {

	/**
	 * @param args
	 */
	public static SessionFactory sessionFactory = null;
	public static void main(String[] args) {
     try {
    	 sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	 MangeEmployee me = new MangeEmployee();
    	 me.addEmployee("Harsith","bandi","India",12000);
    	 me.addEmployee("Niharika","bandi","India",15000);
    	 me.getAllEmployees();
    	// me.updateEmployee(3,12500);
    	 //me.deleteEmployee(5);
		
	} catch (HibernateException e) {
		e.printStackTrace();
	}
	}
	
	
	/* Method to add employee to employee table...*/
	private void addEmployee(String fname, String lname, String address,int sal) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try{
    	tx = session.beginTransaction();
    	Employee employee = new Employee(fname,lname,address,sal);
    	session.saveOrUpdate(employee);
    	tx.commit();
    }catch(HibernateException ex){
    	if(tx!=null) tx.rollback();
    	ex.printStackTrace();
    }finally{
    	session.close();
    }	
	}
	
	/* Method to  READ all the employees */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void getAllEmployees() {
    System.out.println("inside getAllEmployees()....");	
    Session session = sessionFactory.openSession();
	Transaction tx = null;
    try {
    	tx = session.beginTransaction();
    	List employees = session.createQuery("From Employee").list();
    	
    	for(Iterator iterator = employees.iterator();iterator.hasNext();){
    		Employee employee = (Employee) iterator.next();
    		System.out.println("  ID: " + employee.getId());
    		System.out.print("First Name: " + employee.getFname()); 
            System.out.print("  Last Name: " + employee.getLname()); 
            System.out.println("  Addrress: " + employee.getAddress());
            System.out.println("  Salary: " + employee.getSal());            
    	}
	tx.commit();	
	} catch (HibernateException e) {
		if(tx!=null) tx.rollback();
		e.printStackTrace();
	}finally{
		System.out.println("Closing session");
		session.close();
	}
	}
	
	/*
	 * Method to update Empoyee..
	 */
	public void updateEmployee(int empId, int sal){
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,empId);
			employee.setSal(sal);
			session.update(employee);
			
			tx.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	
	/*
	 * Method to delete employee from records..
	 */
	
	private void deleteEmployee(int i) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,i);
			session.delete(employee);
			tx.commit();
			
		} catch (HibernateException e) {
        if(tx!=null) tx.rollback();
        e.printStackTrace();
		
		}finally{
			session.close();
		}
	}
	

}
