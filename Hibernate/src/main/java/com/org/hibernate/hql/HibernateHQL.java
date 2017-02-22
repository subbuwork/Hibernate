/**
 * 
 */
package com.org.hibernate.hql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.Employee;

/**
 * @author subbu
 *
 */
public class HibernateHQL {

private static SessionFactory factory = null;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			HibernateHQL hql = new HibernateHQL();
			//FROM CLAUSE
			hql.fromClause();
			//NAMED PARAMETERS
			hql.namedParameters(5);
			//GROUP BY CLAUSE
			hql.groupByClause();
			
			//PAGINATION COMPONENT
			hql.paginationComponent();
			
			
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	private void fromClause(){
		System.out.println("====FROM CLAUSE=====");
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> empList = null;
		try {
			tx = session.beginTransaction();
			empList = new ArrayList<Employee>(0);
			String hqlQuery = "FROM com.org.hibernate.entity.Employee";
			Query query = session.createQuery(hqlQuery);
			empList = query.list();
			System.out.println(empList.size());
			for(Employee student:empList){
				System.out.println("Emp ID::"+student.getId());
				System.out.println("First name::"+student.getFname());
				System.out.println("Last name::"+student.getLname());
				System.out.println("Salary::"+student.getSal());
				System.out.println("Address::"+student.getAddress());
				System.out.println("======END ======");
			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
		}
		//return null;
		
	}
	
	private void namedParameters(Integer sid){
		System.out.println("==NAMED PARAMETERS====");
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> empList = null;
		try {
			tx = session.beginTransaction();
			empList = new ArrayList<Employee>(0);
			String hqlQuery = "FROM com.org.hibernate.entity.Employee e where e.id=:id";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("id",sid);
			empList = query.list();
			System.out.println(empList.size());
			for(Employee student:empList){
				System.out.println("Emp ID::"+student.getId());
				System.out.println("First name::"+student.getFname());
				System.out.println("Last name::"+student.getLname());
				System.out.println("Salary::"+student.getSal());
				System.out.println("Address::"+student.getAddress());
				System.out.println("===== END =======");
			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
		}
		
	}
	
	private void groupByClause(){
		System.out.println("GROUP BY CLAUSE");
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> empList = null;
		try {
			tx = session.beginTransaction();
			empList = new ArrayList<Employee>(0);
			String hqlQuery = "select sum(e.sal), e.fname FROM com.org.hibernate.entity.Employee e group by e.fname";
			Query query = session.createQuery(hqlQuery).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			//query.setParameter("id",1);
			empList = query.list();
			System.out.println(empList.size());
			Map<String,Object> aliasMap = null;
			for(Object object:empList){
				//Employee employee= (Employee)object;
				aliasMap =(Map<String,Object>) object;
				System.out.println("Emp ID::"+aliasMap.get("fname"));
				/*System.out.println("First name::"+employee.getFname());
				System.out.println("Last name::"+employee.getLname());
				System.out.println("Salary::"+employee.getSal());
				System.out.println("Address::"+employee.getAddress());*/
				System.out.println("===== END =======");
			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private void paginationComponent(){
		System.out.println("====Pagination component====");
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> empList = null;
		try {
			tx = session.beginTransaction();
			empList = new ArrayList<Employee>(0);
			String hqlQuery = "FROM com.org.hibernate.entity.Employee ";
			Query query = session.createQuery(hqlQuery);
			//query.setParameter("id",1);
			query.setFirstResult(0);
			query.setMaxResults(5);
			empList = query.list();
			System.out.println(empList.size());
			for(Employee employee:empList){
				//Employee employee= (Employee)object;
				System.out.println("Emp ID::"+employee.getId());
				System.out.println("First name::"+employee.getFname());
				System.out.println("Last name::"+employee.getLname());
				System.out.println("Salary::"+employee.getSal());
				System.out.println("Address::"+employee.getAddress());
				System.out.println("===== END =======");
			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
		}
		
	}

}
