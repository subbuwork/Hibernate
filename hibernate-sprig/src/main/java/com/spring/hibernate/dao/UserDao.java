package com.spring.hibernate.dao;

import com.spring.hibernate.pojo.UserDomain;

public interface UserDao {
	
	public Integer saveUser(UserDomain userDomain);

}
