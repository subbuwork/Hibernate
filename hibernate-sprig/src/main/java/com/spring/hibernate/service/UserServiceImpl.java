package com.spring.hibernate.service;

import com.spring.hibernate.dao.UserDao;
import com.spring.hibernate.pojo.UserDomain;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    
 /*   public UserServiceImpl(UserDao userdao){
    	this.userDao = userdao;
    }*/
	public Integer saveUser(UserDomain userDomain) {
		return userDao.saveUser(userDomain);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
