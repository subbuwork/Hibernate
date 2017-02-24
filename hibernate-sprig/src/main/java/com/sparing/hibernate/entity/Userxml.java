package com.sparing.hibernate.entity;

public class Userxml {

	private Integer uid;
	
	private String userName;
	
	private String address;
	
	public Userxml(){}

	/**
	 * @param userName
	 * @param address
	 */
	public Userxml(Integer uid ,String userName, String address) {
		this.uid = uid;
		this.userName = userName;
		this.address = address;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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
