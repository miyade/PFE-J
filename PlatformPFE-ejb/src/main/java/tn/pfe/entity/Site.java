package tn.pfe.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement(name="Site")
public class Site {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String nom;
	private String addresse ;
	
	@ManyToOne
	private Admin admin ;
	
	@ManyToOne
	private Directeurdestages directeurdesstages ;
	
	@OneToOne
	private TemplatePFE templatePFE;
	
	
	@OneToOne
	private TemplateIntershipAgreement templateIntershipAgreement;
	
	@OneToOne
	private TemplateTrainingCertificate templateTrainingCertificate;
	
	@JsonIgnore
	@OneToMany(mappedBy="site" ,fetch = FetchType.EAGER)
	private Set<Student> students;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="site" ,fetch = FetchType.EAGER)
	private Set<projectCategory> projetcategorys;
	
	@XmlElement
public Directeurdestages getDirecteurdesstages() {
		return directeurdesstages;
	}

	public void setDirecteurdesstages(Directeurdestages directeurdesstages) {
		this.directeurdesstages = directeurdesstages;
	}

@XmlAttribute
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
@XmlElement
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
@XmlElement
	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
@XmlElement
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public TemplatePFE getTemplatePFE() {
		return templatePFE;
	}

	public void setTemplatePFE(TemplatePFE templatePFE) {
		this.templatePFE = templatePFE;
	}

	public TemplateIntershipAgreement getTemplateIntershipAgreement() {
		return templateIntershipAgreement;
	}

	public void setTemplateIntershipAgreement(TemplateIntershipAgreement templateIntershipAgreement) {
		this.templateIntershipAgreement = templateIntershipAgreement;
	}

	public TemplateTrainingCertificate getTemplateTrainingCertificate() {
		return templateTrainingCertificate;
	}

	public void setTemplateTrainingCertificate(TemplateTrainingCertificate templateTrainingCertificate) {
		this.templateTrainingCertificate = templateTrainingCertificate;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<projectCategory> getProjetcategorys() {
		return projetcategorys;
	}

	public void setProjetcategorys(Set<projectCategory> projetcategorys) {
		this.projetcategorys = projetcategorys;
	}

	
	
}
