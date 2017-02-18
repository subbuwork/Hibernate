/**
 * 
 */
package com.org.hibernate.entity;

import java.util.Date;
import java.util.Set;

/**
 * @author subbu
 *
 */
public class Student2 {
	private int sid;
	private String fName;
	private String lName;
    private Date dob;
    private Set<Certificates> certificates;
    
	public Student2() {}

	/**
	 * @param fName
	 * @param lName
	 * @param dob
	 */
	public Student2(String fName, String lName, Date dob) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
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
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Certificates> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificates> certificates) {
		this.certificates = certificates;
	}
	
	
}
