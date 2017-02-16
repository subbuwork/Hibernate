/**
 * 
 */
package com.orm.hibernate.main;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.org.hibernate.entity.AddressXmlMapping;
import com.org.hibernate.entity.StudentXmlMapping;

/**
 * @author subbu
 *
 */
public class ManageManyToOneXmlConfiguration {


	private static SessionFactory factory = null;
	public static void main(String[] args) {
     try {
    	factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	ManageManyToOneXmlConfiguration manageManyToOneXmlConfiguration = new ManageManyToOneXmlConfiguration();
    	
    	AddressXmlMapping address = manageManyToOneXmlConfiguration.addAddress("Etcherla", "Srikakulam","AP",523180, "India");
    	
    	manageManyToOneXmlConfiguration.addStudent("Lokesh", "S", "AU", "MCA","A", address);
    	
    	manageManyToOneXmlConfiguration.addStudent("Anand", "V", "AU", "MCA","A", address);
    	//System.out.println("SID:::"+sId1+":::SID2::"+sId2);
    	
    	manageManyToOneXmlConfiguration.updateStudent(20);
    	
    	manageManyToOneXmlConfiguration.deleteStudent(3);
    	
    	manageManyToOneXmlConfiguration.getAllStudents();
    	
	} catch (Throwable e) {
		System.err.println("Unable to create sessoin factory:::"+e);
		throw new ExceptionInInitializerError(e);
	}
	}
	/*
	 * Method to add Address into address table...
	 */
	 public AddressXmlMapping addAddress(String street, String city, 
             String state, int zipcode,String country) {
				Session session = factory.openSession();
				Transaction tx = null;
				Integer addressID = null;
				AddressXmlMapping address = null;
				try{
				tx = session.beginTransaction();
				address = new AddressXmlMapping(street, city, state, zipcode,country);
				Criteria criteria =session.createCriteria(AddressXmlMapping.class);
				List addresses=criteria.add(Restrictions.eq("zipCode",zipcode)).list();
				if(addresses != null){
					System.out.println("Address Already existed in data base...");
					for(Object object :addresses){
						address = (AddressXmlMapping) object;	
						System.out.println("AddressID in for loop:::"+address.getId());
					}
				}else{
					addressID = (Integer) session.save(address);
					tx.commit();
				}
				
				System.out.println("AddressID:::"+addressID);
				
				}catch (HibernateException e) {
				if (tx!=null) tx.rollback();
				e.printStackTrace(); 
				}finally {
				session.close(); 
				}
				return address;
				}
	 
	 
	   /* Method to add an employee record in the database */
	   public void addStudent(String fName, String lName, String colName,
				String branchName, String grade, AddressXmlMapping address){
	      Session session = factory.openSession();
	      Transaction tx = null;
	     // Integer sID = null;
	      try{
	         tx = session.beginTransaction();
	         StudentXmlMapping student = new StudentXmlMapping(fName, lName, colName, branchName,grade,address);
	         session.saveOrUpdate(student); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      //return sID;
	   }

	   /*
	    * Method to update Student details...
	    */
	   public void updateStudent(int sId){
		   Session session = factory.openSession();
		      Transaction tx = null;
		      try {
		    	  tx = session.beginTransaction();
		    	  StudentXmlMapping studentXmlMapping = (StudentXmlMapping)session.get(StudentXmlMapping.class,sId);
		    	  studentXmlMapping.setColName("JNTU");
		    	  session.update(studentXmlMapping);
		    	  tx.commit();
				
			} catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      System.out.println("Student updated successfully with given sid::"+sId);
	   }
	   
	 /*
	  * Method to delete student..
	  */
 public void deleteStudent(Integer sid){
	 Session session = factory.openSession();
     Transaction tx = null;
     try {
   	  tx = session.beginTransaction();
   	  StudentXmlMapping studentXmlMapping = (StudentXmlMapping)session.load(StudentXmlMapping.class,sid);
   	  
   	  //studentXmlMapping.setColName("JNTU");
   	  session.delete(studentXmlMapping);
   	  tx.commit();
		
	} catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
     System.out.println("Student deleted successfuly with give sid::"+sid);
	
}
	   
 
/*
* Method to get All Students...
*/
 @SuppressWarnings({ "rawtypes", "deprecation" })
public void getAllStudents(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List studentXmlMapping = session.createQuery("FROM StudentXmlMapping").list();
	         for(Iterator iterator = studentXmlMapping.iterator(); iterator.hasNext(); ){
	        	 StudentXmlMapping studentXmlMapping2 = (StudentXmlMapping) iterator.next();
	        	 
	        	 System.out.println("======> Student Details ========>");
	        	 System.out.println("Student ID::"+studentXmlMapping2.getSid());
	        	 System.out.println("Student First Name::"+studentXmlMapping2.getfName());
	        	 System.out.println("Student Last Name::"+studentXmlMapping2.getlName());
	        	 System.out.println("Studetn Branch::"+studentXmlMapping2.getBranchName());
	        	 System.out.println("Student Grade::"+studentXmlMapping2.getGrade());
	        	 
	        	 System.out.println("=========> Student Address ===========>");
	        	 
	        	 System.out.println("Street Name::"+studentXmlMapping2.getAddress().getStreetName());
	        	 System.out.println("City Name:::"+studentXmlMapping2.getAddress().getCityName());
	        	 System.out.println("State Name:::"+studentXmlMapping2.getAddress().getStateName());
	        	 System.out.println("Zip Code::"+studentXmlMapping2.getAddress().getZipCode());
	        	 System.out.println("Country Name::"+studentXmlMapping2.getAddress().getCountryName());
	        	 System.out.println("");
	        	 
	         }
	        
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	     
	   
 }	   
	   
	   
}
