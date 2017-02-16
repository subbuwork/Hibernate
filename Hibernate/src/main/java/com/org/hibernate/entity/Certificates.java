/**
 * 
 */
package com.org.hibernate.entity;

import java.util.Date;

/**
 * @author subbu
 *
 */
public class Certificates {
	private int cid;
	private String dName;
	private String uName;
	private Date year;
	
	public Certificates(){}

	public Certificates(String dName, String uName, Date year) {
		super();
		this.dName = dName;
		this.uName = uName;
		this.year = year;
	}

	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * @return the dName
	 */
	public String getdName() {
		return dName;
	}

	/**
	 * @param dName the dName to set
	 */
	public void setdName(String dName) {
		this.dName = dName;
	}

	/**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName the uName to set
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}

	/**
	 * @return the year
	 */
	public Date getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Date year) {
		this.year = year;
	}
	
	   public boolean equals(Object obj) {
		      if (obj == null) return false;
		      if (!this.getClass().equals(obj.getClass())) return false;

		      Certificates obj2 = (Certificates)obj;
		      if((this.cid == obj2.getCid()) && (this.dName.equals(obj2.getdName())))
		      {
		         return true;
		      }
		      return false;
		   }
		   public int hashCode() {
		      int tmp = 0;
		      tmp = ( cid + dName ).hashCode();
		      return tmp;
		   }
	

}
