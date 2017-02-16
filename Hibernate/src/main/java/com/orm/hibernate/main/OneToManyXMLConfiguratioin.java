package com.orm.hibernate.main;

import java.util.Date;
import java.util.HashSet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hibernate.entity.Certificates;

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
	      set1.add(new Certificates("","MCA", new Date(2010)));
	      set1.add(new Certificates("","BSc",new Date(2006)));
	      set1.add(new Certificates("","PMP",new Date(2003)));
	      
	      /* Add employee records in the database */
	      Integer empID1 = oneToManyXMLConfiguratioin.addStudent2("Manoj", "Kumar", 4000, set1);
	      
	      

}
	private Integer addStudent2(String string, String string2, int i,
			HashSet set1) {
		// TODO Auto-generated method stub
		return null;
	}
}
