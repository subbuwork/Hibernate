/**
 * 
 */
package com.org.hibernate.entity;

/**
 * This class for demonstrating xml configuration for Many to one association
 * @author subbu
 *
 */

public class StudentXmlMapping {

	private int sid;
	
	private String fName;
	
	private String lName;
	
	private String colName;
	
	private String branchName;
	
	private String grade;
	
	private AddressXmlMapping address;
	
	public StudentXmlMapping(){}

	public StudentXmlMapping(String fName, String lName, String colName,
			String branchName, String grade, AddressXmlMapping address) {
		super();
		//this.sid =sid;
		this.fName = fName;
		this.lName = lName;
		this.colName = colName;
		this.branchName = branchName;
		this.grade = grade;
		this.address = address;
	}

	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the colName
	 */
	public String getColName() {
		return colName;
	}

	/**
	 * @param colName the colName to set
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the address
	 */
	public AddressXmlMapping getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressXmlMapping address) {
		this.address = address;
	}
	
	
	
	

}
