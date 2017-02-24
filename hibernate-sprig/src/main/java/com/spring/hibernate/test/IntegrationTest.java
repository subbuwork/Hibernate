/**
 * 
 */
package com.spring.hibernate.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.hibernate.pojo.UserDomain;
import com.spring.hibernate.service.UserService;

/**
 * @author subbu
 *
 */
public class IntegrationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserService userService = (UserService)context.getBean("userServiceImpl");
		UserDomain userDomain = new UserDomain(2,"subbarao","India");
		Integer userID = userService.saveUser(userDomain);
		System.out.println("User id ::"+userID);
        
	}

}
