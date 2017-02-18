/**
 * 
 */
package com.org.hibernate.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This student2 class used annotations to full the One-to-May Association
 * @author subbu
 *
 */
@Entity
@Table(name="student2")
public class Student2AnnotationsBased {
	
	private int sid;
	private String fName;
	private String lName;
    private Date dob;
    private Set<CertificatesAnnotationsBased> certificates = new HashSet<CertificatesAnnotationsBased>(0);
    
	public Student2AnnotationsBased() {}

	/**
	 * @param fName
	 * @param lName
	 * @param dob
	 */
	public Student2AnnotationsBased(String fName, String lName, Date dob) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		
	}
	
	/**
	 * @param fName
	 * @param lName
	 * @param dob
	 * @param certificates
	 */
	public Student2AnnotationsBased(String fName, String lName, Date dob,
			        Set<CertificatesAnnotationsBased> certificates) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.certificates = certificates;
	}

	/**
	 * @return the sid
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sid")
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
	@Column(name="fName")
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
	@Column(name="lName")
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
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="sid",fetch=FetchType.LAZY)

	public Set<CertificatesAnnotationsBased> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<CertificatesAnnotationsBased> certificates) {
		this.certificates = certificates;
	}


	
	
}
