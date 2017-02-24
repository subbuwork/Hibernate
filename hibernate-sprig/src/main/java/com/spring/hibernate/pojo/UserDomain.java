package com.spring.hibernate.pojo;

public class UserDomain {
	private Integer userID;
	private String userName;
	private String address;
	
	public UserDomain(){}

	/**
	 * @param userID
	 * @param userName
	 * @param address
	 */
	public UserDomain(Integer uid ,String userName, String address) {
		super();
		this.userID = uid;
		this.userName = userName;
		this.address = address;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
