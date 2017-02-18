/**
 * 
 */
package com.org.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author subbu
 *
 */
@Entity
@Table(name="certificates")
public class CertificatesAnnotationsBased {
	private int cid;
	private String dName;
	private String uName;
	private Date year;
	private Student2AnnotationsBased student2AnnotationsBased;
	
	public CertificatesAnnotationsBased(){}

	public CertificatesAnnotationsBased(String dName, String uName, Date year) {
		super();
		this.dName = dName;
		this.uName = uName;
		this.year = year;
	}
	
	public CertificatesAnnotationsBased(String dName, String uName, Date year,Student2AnnotationsBased student2AnnotationsBased) {
		super();
		this.dName = dName;
		this.uName = uName;
		this.year = year;
		this.student2AnnotationsBased = student2AnnotationsBased;
	}

	/**
	 * @return the cid
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid")
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
	@Column(name="d_name")
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
	@Column(name="u_name")
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
	@Temporal(TemporalType.DATE)
	@Column(name="year")
	public Date getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Date year) {
		this.year = year;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sid")
	   public Student2AnnotationsBased getStudent2AnnotationsBased() {
		return student2AnnotationsBased;
	}

	public void setStudent2AnnotationsBased(
			Student2AnnotationsBased student2AnnotationsBased) {
		this.student2AnnotationsBased = student2AnnotationsBased;
	}

	public boolean equals(Object obj) {
		      if (obj == null) return false;
		      if (!this.getClass().equals(obj.getClass())) return false;

		      CertificatesAnnotationsBased obj2 = (CertificatesAnnotationsBased)obj;
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
