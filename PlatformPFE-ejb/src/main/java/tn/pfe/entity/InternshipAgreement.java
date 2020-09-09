package tn.pfe.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import tn.pfe.entity.Company;
@Entity
@Table(name="internshipAgreement")
public class InternshipAgreement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_InternshipAgreement")
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Beginning_InternshipAgreement")
	private Date beginningDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="End_InternshipAgreement")
	private Date endingDate;
	@OneToOne(mappedBy="internagreement")
	private Company company;
	
	
	@ManyToOne
	private TemplateIntershipAgreement templateIntershipAgreement;
	
	public InternshipAgreement(Date beginningDate, Date endingDate, Company company) {
		super();
		this.beginningDate = beginningDate;
		this.endingDate = endingDate;
		this.company = company;
	}
	public InternshipAgreement(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBeginningDate() {
		return beginningDate;
	}
	public void setBeginningDate(Date beginningDate) {
		this.beginningDate = beginningDate;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public TemplateIntershipAgreement getTemplateIntershipAgreement() {
		return templateIntershipAgreement;
	}
	public void setTemplateIntershipAgreement(TemplateIntershipAgreement templateIntershipAgreement) {
		this.templateIntershipAgreement = templateIntershipAgreement;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public InternshipAgreement(int id, Date beginningDate, Date endingDate, Company company,
			TemplateIntershipAgreement templateIntershipAgreement) {
		this.id = id;
		this.beginningDate = beginningDate;
		this.endingDate = endingDate;
		this.company = company;
		this.templateIntershipAgreement = templateIntershipAgreement;
	}
	
	
	
}
