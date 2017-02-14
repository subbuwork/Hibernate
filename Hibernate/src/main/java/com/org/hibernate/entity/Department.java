/**
 * 
 */
package com.org.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is annotated entity class, xml configuration not requied..
 * @author subbu
 *
 */
@Entity
@Table(name= "department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="did")
	private int dId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="dname")
	private String dname;
	
	public Department(){}

	
	/**
	 * @param address
	 * @param dname
	 */
	public Department(String address, String dname) {
		super();
		this.address = address;
		this.dname = dname;
	}


	/**
	 * @return the dId
	 */
	public int getdId() {
		return dId;
	}


	/**
	 * @param dId the dId to set
	 */
	public void setdId(int dId) {
		this.dId = dId;
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
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}


	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	
}
