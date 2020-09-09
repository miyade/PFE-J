package tn.pfe.entity;





import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;













@Entity
public class Admin extends User implements Serializable {

	private String Element;
	
	@ManyToOne
	private SuperAdmin superadmin;
	@OneToMany(mappedBy="adminchefdep",cascade= CascadeType.ALL,fetch =FetchType.EAGER)
	private Set <Chefdepartement> chefdepartements= new HashSet<Chefdepartement>();
	
	@OneToMany(mappedBy="adminds",cascade= CascadeType.ALL,fetch =FetchType.EAGER)
	private Set <Directeurdestages> Directeurdesstages= new HashSet<Directeurdestages>();
	
	@OneToMany(mappedBy="admin",cascade= CascadeType.ALL,fetch =FetchType.EAGER)
	private Set <Student> Students= new HashSet<Student>();
	@OneToMany(mappedBy="admin",fetch=FetchType.EAGER  ,cascade= CascadeType.ALL)
	private Set <Ecole> ecoles = new HashSet<Ecole>();
	
	@OneToMany(mappedBy = "admin",fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<Options> options =  new HashSet<Options>() ;
	
	@OneToMany(mappedBy ="admin",fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<Site> sites = new HashSet<Site>();
	
	@OneToMany(mappedBy="admin",fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<Departement> departements = new HashSet<Departement>() ;
	
	@OneToMany(mappedBy ="admin",fetch= FetchType.EAGER, cascade= CascadeType.ALL)
private Set<Classes> classes = new HashSet<Classes>();
	
	@OneToMany(mappedBy = "admin",fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<Payment> payments = new HashSet<Payment>();
	

	public String getElement() {
		return Element;
	}

	public void setElement(String element) {
		Element = element;
	}

	


	@XmlTransient
		public Set<Payment> getPayments() {

		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;

	}
	@XmlTransient
	public Set<Chefdepartement> getChefdepartements() {
		return chefdepartements;
	}

	public void setChefdepartements(Set<Chefdepartement> chefdepartements) {
		this.chefdepartements = chefdepartements;
	}

	@XmlTransient
	public Set<Directeurdestages> getDirecteurdesstages() {
		return Directeurdesstages;
	}

	public void setDirecteurdesstages(Set<Directeurdestages> directeurdesstages) {
		Directeurdesstages = directeurdesstages;
	}

	@XmlTransient
public Set<Student> getStudents() {
		return Students;
	}

	public void setStudents(Set<Student> students) {
		Students = students;
	}

@XmlElement
	public SuperAdmin getSuperadmin() {
		return superadmin;
	}

	public void setSuperadmin(SuperAdmin superadmin) {
		this.superadmin = superadmin;
	}
public Admin() {
	super();
}
	
	@XmlTransient
	public Set<Ecole> getEcoles() {
		return ecoles;
	}

	public void setEcoles(Set<Ecole> ecoles) {
		this.ecoles = ecoles;
	}
	@XmlTransient
	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}
	@XmlTransient
	public Set<Site> getSites() {
		return sites;
	}

	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}
	@XmlTransient
	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}
	@XmlTransient
	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}	
	
	
	

}
