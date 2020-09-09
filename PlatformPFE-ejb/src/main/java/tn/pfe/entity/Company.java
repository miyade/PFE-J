package tn.pfe.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Company")
public class Company implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_COMPANY")
	private int id;
	@Column(name="website_COMPANY")
	private String website;
	@Column(name="address_COMPANY")
	private String address;
	@Column(name="country_COMPANY")
	private String country;
	@Column(name="gmName_COMPANY")
	private String gmName;
	@Column(name="gmLastName_COMPANY")
	private String gmLastName;
	@Column(name="gmEmail_COMPANY")
	private String gmEmail;
	@Column(name="supervisorEmail_COMPANY")
	private String supervisorEmail;
	@Column(name="phoneNumber_COMPANY")
	private Long phoneNumber;
	@OneToOne
	private InternshipAgreement internagreement;
	@OneToOne
	private GradProjectFile gradproj;
	
	@OneToMany(mappedBy="company" )
	private List<Student> students = new ArrayList<>();
	
	
	public Company(String website, String address, String country, String gmName, String gmLastName, String gmEmail,
			String supervisorEmail, Long phoneNumber) {
		super();
		this.website = website;
		this.address = address;
		this.country = country;
		this.gmName = gmName;
		this.gmLastName = gmLastName;
		this.gmEmail = gmEmail;
		this.supervisorEmail = supervisorEmail;
		this.phoneNumber = phoneNumber;
	}
	public Company(){}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGmName() {
		return gmName;
	}
	public void setGmName(String gmName) {
		this.gmName = gmName;
	}
	public String getGmEmail() {
		return gmEmail;
	}
	public void setGmEmail(String gmEmail) {
		this.gmEmail = gmEmail;
	}
	public String getGmLastName() {
		return gmLastName;
	}
	public void setGmLastName(String gmLastName) {
		this.gmLastName = gmLastName;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSupervisorEmail() {
		return supervisorEmail;
	}
	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}
	
}
