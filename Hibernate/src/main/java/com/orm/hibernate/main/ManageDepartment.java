/**
 * 
 */
package com.orm.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.Department;

/**
 * @author subbu
 *
 */
public class ManageDepartment {

	private static SessionFactory sessionFactory = null;
	
	public static void main(String[] args) {
     try {
    	 sessionFactory = new Configuration().configure("hibernate.cfg.xml").
    			 addAnnotatedClass(com.org.hibernate.entity.Department.class).
    			 buildSessionFactory();
    	 ManageDepartment md = new ManageDepartment();
    	 md.addDepartment("Agr","India");
    	 md.udpateDepartment(4);
    	 md.deleteDepartment(3);
    	 md.getAllDepartments();
		
	} catch (Throwable ex) {
	System.err.println("Failed to create Sessoin fatctory object::"+ex);
	throw new ExceptionInInitializerError(ex); 
	}
		
	}
	
	/*
	 * Method for adding department
	 * 
	 */
	public void addDepartment(String dname,String address){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Department department = new Department(dname,address);
			session.saveOrUpdate(department);
			tx.commit();
			
		} catch (HibernateException e) {
        if(tx!=null) tx.rollback();
        e.printStackTrace();
		
		}finally{
			session.close();
		}
		
	}
/*
 * Method to retrive all the departments...
 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void getAllDepartments() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List departments = session.createQuery("From Department").list();
			for(Iterator iterator = departments.iterator(); iterator.hasNext();){
				Department department = (Department) iterator.next();
				
				System.out.println("Department id::"+department.getdId());
				System.out.println("Department name::"+department.getDname());
				System.out.println("Department address::"+department.getAddress());
			}
			tx.commit();
		} catch (HibernateException e) {
        if(tx!=null) tx.rollback();
		}finally{
			session.close();
		}
		
	}
	
	/*
	 *  Method to update records...
	 */
	private void udpateDepartment(int did){
		System.out.println("udpateDepartment.....");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Department department = (Department) session.load(Department.class,did);
			department.setDname("Agr");
			session.save(department);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	/*
	 *  Method to update records...
	 */
	private void deleteDepartment(int did){
		System.out.println("deleteDepartment.....");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Department department = (Department) session.load(Department.class,did);
			//department.setDname("Agr");
			session.delete(department);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	

}
