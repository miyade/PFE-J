package tn.pfe.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


import tn.pfe.entity.*;

@Entity
public class Student extends User implements Serializable{

	@ManyToOne
	private Company company;
	
	private int grade;

	@ManyToOne
	private Teacher encadrants ;
	
	@ManyToOne
	private Teacher prevalidateur;
	
	@ManyToOne
	private Teacher  rapporteurs;
	@ManyToOne
	private Admin admin ;
	
	@OneToOne
	private GradProjectFile PfeFile;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private Set<Notification> notifications  = new HashSet<>();
	
	@OneToOne
	private Reclamation reclamation;
	
	@ManyToOne
	private Teacher president;
	
	@ManyToOne
	private Site site;

	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@XmlTransient
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	public Teacher getEncadrants() {
		return encadrants;
	}
	

	
	public void setEncadrants(Teacher encadrants) {
		this.encadrants = encadrants;
	}

	
	public Teacher getRapporteurs() {
		return rapporteurs;
	}



	public void setRapporteurs(Teacher rapporteurs) {
		this.rapporteurs = rapporteurs;
	}
	@XmlTransient
	public GradProjectFile getPfeFile() {
		return PfeFile;
	}



	public void setPfeFile(GradProjectFile pfeFile) {
		PfeFile = pfeFile;
	}


	@XmlElement
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


	
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	public Teacher getPresident() {
		return president;
	}
	public void setPresident(Teacher president) {
		this.president = president;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	public Set<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}
	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}
	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}
	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}	
	public void setPrevalidateur(Teacher prevalidateur) {
		this.prevalidateur = prevalidateur;
	}
	public Teacher getPrevalidateur() {
		return prevalidateur;
	}
	@XmlTransient
	public Reclamation getReclamation() {
		return reclamation;
	}
	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}
}
