package com.hibernate.reverse.engineering;

// Generated Feb 22, 2017 6:01:37 PM by Hibernate Tools 4.3.1

/**
 * Student generated by hbm2java
 */
public class Student implements java.io.Serializable {

	private int sid;
	private Address address;
	private String branchName;
	private String colName;
	private String FName;
	private String grade;
	private String LName;

	public Student() {
	}

	public Student(int sid) {
		this.sid = sid;
	}

	public Student(int sid, Address address, String branchName, String colName,
			String FName, String grade, String LName) {
		this.sid = sid;
		this.address = address;
		this.branchName = branchName;
		this.colName = colName;
		this.FName = FName;
		this.grade = grade;
		this.LName = LName;
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getColName() {
		return this.colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getLName() {
		return this.LName;
	}

	public void setLName(String LName) {
		this.LName = LName;
	}

}