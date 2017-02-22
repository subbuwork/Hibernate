package com.org.hibernate.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.org.hibernate.entity.Employee;


public class ManageCriteria {

	private static SessionFactory factory = null;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
			/**
			 * Creating session factory using Hibernate 5.x 
			 * 
			 */
			//Configuration conf = new Configuration().configure("hibernate.cfb.xml");
			//StandardServiceRegistryBuilder registryBuilder  = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			//factory = conf.buildSessionFactory(registryBuilder.build());
			
			ManageCriteria manageCriteria = new ManageCriteria();
	        manageCriteria.simpleCriteria();
	        manageCriteria.restrictions();
	        manageCriteria.simpleCriteria();
	        manageCriteria.paginationUsingCriteria();
	        manageCriteria.sorringResult();
	        manageCriteria.projectionsAndAggregations();
	        
			
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
		
	@SuppressWarnings("unchecked")
	public void simpleCriteria(){
		System.out.println("====FROM CLAUSE=====");
		Session session = factory.openSession();
		//Transaction tx = null;
		List<Employee> result = null;
		try {
			//tx = session.beginTransaction();
			//Creating Criteria object in Hibernate 4.x below versions
			//Criteria criteria = session.createCriteria(Employee.class);
			//result = criteria.list();
			
			//Creating query using Hiberante 5.x API
			CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
			cq.from(Employee.class);
			result = session.createQuery(cq).getResultList();
			for(Employee employee:result){
				System.out.println("Emp ID::::"+employee.getId());
				System.out.println("First name::"+employee.getFname());
				System.out.println("Last name::"+employee.getLname());
				System.out.println("Salary::"+employee.getSal());
				System.out.println("Address::"+employee.getAddress());
				System.out.println("===>===> END <====<==");
				//tx.commit();
			}
		}catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * Restrictions...
	 */
	private void restrictions(){
		System.out.println("====Restrictions... start=====");
		Session session = factory.openSession();
		List<Employee> result = null;
		Criteria cri = session.createCriteria(Employee.class);
		// To get records having salary more than 12333
        cri.add(Restrictions.gt("sal",12333));
        // To get records having salary less than 12333
        cri.add(Restrictions.lt("sal",12333));
        
        //To get records having fistName starting with zara
        cri.add(Restrictions.like("fname", "s%"));
        
        // Case sensitive form of the above restriction.
        cri.add(Restrictions.ilike("fname","s%"));
        
        // To get records having salary in between 1000 and 2000
        cri.add(Restrictions.between("sal", 12000, 25000));
        
        // To check if the given property is null
        cri.add(Restrictions.isNull("fname"));
        
        // To check if the given property is not null
        cri.add(Restrictions.isNotNull("sal"));
        
        // To check if the given property is empty
        cri.add(Restrictions.isEmpty("sal"));
        
        // To check if the given property is not empty
        cri.add(Restrictions.isNotEmpty("laname"));
        
        //AND or OR conditions using LogicalExpression 
        Criterion sal = Restrictions.gt("sal",15000);
        Criterion names = Restrictions.ilike("fname", "s%");
        
        // To get records matching with OR conditions
        LogicalExpression orEXP = Restrictions.or(names, sal);
        cri.add(orEXP);
        
        // To get records matching with AND conditions
        LogicalExpression andEXP = Restrictions.and(sal, names);
        cri.add(andEXP);
        result = cri.list();
        for(Employee employee:result){
			System.out.println("Emp ID::::"+employee.getId());
			System.out.println("First name::"+employee.getFname());
			System.out.println("Last name::"+employee.getLname());
			System.out.println("Salary::"+employee.getSal());
			System.out.println("Address::"+employee.getAddress());
			System.out.println("===>===> END <====<==");
			//tx.commit();
		}
		
		System.out.println("====Restrictions... end=====");
		
	}
	/**
	 * Pagination using Criteria...
	 * public Criteria setFirstResult(int firstResult) 
       This method takes an integer that represents the first row in your result set, starting with row 0.
       
     * public Criteria setMaxResults(int maxResults) 
       This method tells Hibernate to retrieve a fixed number maxResults of objects.
     * Using above two methods together, we can construct a paging component in our web or 
     * Swing application. Following is the example which you can extend to fetch 10 rows at a time:  
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	private void paginationUsingCriteria(){
		System.out.println("======> Pagination using Criteria =====>");
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		List<Employee> result = criteria.list();
		 for(Employee employee:result){
				System.out.println("Emp ID::::"+employee.getId());
				System.out.println("First name::"+employee.getFname());
				System.out.println("Last name::"+employee.getLname());
				System.out.println("Salary::"+employee.getSal());
				System.out.println("Address::"+employee.getAddress());
				System.out.println("===>===> END <====<==");
				//tx.commit();
			}
		
		
	}
	
	/**
	 * Sorting Order..
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	private void sorringResult(){
		System.out.println("======> Results Sorting... =====>");
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		// To get records having salary more than 2000
		criteria.add(Restrictions.gt("sal",15000));
		
		// To sort records in descening order
		criteria.addOrder(Order.desc("sal"));
		
		// To sort records in ascending order
		criteria.addOrder(Order.asc("sal"));
		
		List<Employee> result = criteria.list();
		 for(Employee employee:result){
				System.out.println("Emp ID::::"+employee.getId());
				System.out.println("First name::"+employee.getFname());
				System.out.println("Last name::"+employee.getLname());
				System.out.println("Salary::"+employee.getSal());
				System.out.println("Address::"+employee.getAddress());
				System.out.println("===>===> END <====<==");
				//tx.commit();
			}
		
		
	}
	/**
	 * Sorting Order..
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	private void projectionsAndAggregations(){
		System.out.println("======> Results Sorting... =====>");
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		// To get total row count.
		criteria.setProjection(Projections.rowCount());
		
		// To get average of a property.
        criteria.setProjection(Projections.avg("sal"));
        
        // To get distinct count of a property.
        criteria.setProjection(Projections.countDistinct("sal"));
       
        // To get maximum of a property.
        criteria.setProjection(Projections.max("sal"));
        
        // To get minimum of a property.
		criteria.setProjection(Projections.min("sal"));
		
		// To get sum of a property.
		criteria.setProjection(Projections.sum("sal"));
		List<Employee> result = criteria.list();
		 for(Employee employee:result){
				System.out.println("Emp ID::::"+employee.getId());
				System.out.println("First name::"+employee.getFname());
				System.out.println("Last name::"+employee.getLname());
				System.out.println("Salary::"+employee.getSal());
				System.out.println("Address::"+employee.getAddress());
				System.out.println("===>===> END <====<==");
				//tx.commit();
			}
		
		
	}
}
