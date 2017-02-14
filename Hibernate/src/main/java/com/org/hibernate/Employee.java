/**
 * 
 */
package com.org.hibernate;

/**
 * This is xml based configuration entity class.. 
 * this will have corresponding mapping  file(Employee.hbm.xml) 
 * which will configure in hibernate.cfg.xml file
 * @author subbu
 *
 */
public class Employee {
	
	private int id;
	private String fname;
	private String lname;
	private String address;
	private int sal;
	
	public Employee(){}

	/**
	 * @param id
	 * @param fname
	 * @param lname
	 * @param address
	 * @param sal
	 */
	public Employee(String fname, String lname, String address, int sal) {
		super();
		//this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.sal = sal;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the sal
	 */
	public int getSal() {
		return sal;
	}

	/**
	 * @param sal the sal to set
	 */
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	
	
	
	
	
	

}
