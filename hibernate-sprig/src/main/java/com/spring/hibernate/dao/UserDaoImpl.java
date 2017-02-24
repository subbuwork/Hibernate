package com.spring.hibernate.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.sparing.hibernate.entity.Userxml;
import com.spring.hibernate.pojo.UserDomain;

public class UserDaoImpl implements UserDao {
    HibernateTemplate template;
    Integer userID = null;
    
  /*  public UserDaoImpl(HibernateTemplate template){
    	this.template = template;
    }*/
    //@Transactional
	public Integer saveUser(UserDomain userDomain) {
		System.out.println(".........UserDaoImpl saveUser()......"+"::user id::"+userDomain.getUserID()+"User Name::"+userDomain.getUserName()+":::address::"+userDomain.getAddress());
		Userxml user = new Userxml(userDomain.getUserID(),userDomain.getUserName(),userDomain.getAddress());
        template.save(user);
  
        System.out.println("User saved successfully with ID::"+userID);
		return userID;
	}

/*	public HibernateTemplate getTemplate() {
		return template;
	}
*/
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	

}
