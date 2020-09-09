package tn.pfe.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.DefaultValue;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import tn.pfe.entity.Student;



@Entity
@Table(name="GradProject_File")
@XmlRootElement(name ="GradProjectFile")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class GradProjectFile implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column(name="title_gradproject")
	private String title;
	@Column(name="description_gradproject")
	private String description;
	@Column(name="problem_gradproject")
	private String problem;
	@Column(name="functionnalities_gradproject")
	private String functionnalities;
	@Column(name="keyword_gradproject")
	private String keyword;

	
private boolean validated;
private boolean preValidated;

private String state;

private String stateRapport;

	private String anneeScolairee;

	@Temporal(TemporalType.DATE)
	private Date dateSaisie;
	
	@Temporal(TemporalType.DATE)
	private Date anneeScolaire =  new Date();
	
	private String Motif;
	
	private double note;
	
	@DefaultValue("nouveau")
	private String nouveau;
	
	private double note_rapporteur;
	
	private double note_encadrant;
	
	@OneToOne(mappedBy = "PfeFile",fetch=FetchType.EAGER)
	private Student Student;

	private String pays;
	
	@ManyToOne
	private Teacher encadreur;
	
	@OneToOne(mappedBy="pfe",cascade =CascadeType.MERGE,fetch=FetchType.EAGER)
	private Soutenance soutenance ;
	
	
	@OneToOne(mappedBy="gradproj" , fetch=FetchType.EAGER)
	private Company company;
	
	@ManyToOne
	private TemplatePFE templatePFE;
	
	@ManyToMany(mappedBy="gradProjectFiles" , fetch=FetchType.EAGER)
	private Set<projectCategory> Categorys = new HashSet<>();

	
	
	
	
	@XmlElement
	public Soutenance getSoutenance() {
		return soutenance;
	}

	public void setSoutenance(Soutenance soutenance) {
		this.soutenance = soutenance;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	@XmlElement
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@XmlElement
	public boolean isPreValidated() {
		return preValidated;
	}

	public void setPreValidated(boolean preValidated) {
		this.preValidated = preValidated;
	}

	
	@XmlElement
	public Date getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(Date anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	
	public Student getStudent() {
		return Student;
	}

	public void setStudent(Student student) {
		Student = student;
	}

	

	@XmlElement
	public Set<projectCategory> getCategoriesoffile() {
		return Categorys;
	}

	public void setCategoriesoffile(Set<projectCategory> categoriesoffile) {
		this.Categorys= categoriesoffile;
	}

	@XmlElement
	public String getMotif() {
		return Motif;
	}

	public void setMotif(String motif) {
		Motif = motif;
	}
	
	
	
	
	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
@XmlElement
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}
@XmlElement
	public String getFunctionnalities() {
		return functionnalities;
	}

	public void setFunctionnalities(String functionnalities) {
		this.functionnalities = functionnalities;
	}
@XmlElement
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

@XmlElement
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
@XmlElement
	public TemplatePFE getTemplatePFE() {
		return templatePFE;
	}

	public void setTemplatePFE(TemplatePFE templatePFE) {
		this.templatePFE = templatePFE;
	}
@XmlElement
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



@XmlTransient
	public Set<projectCategory> getCategorys() {
		return Categorys;
	}

	public void setCategorys(Set<projectCategory> categorys) {
		Categorys = categorys;
	}

	public GradProjectFile(int id, String title, String description, String problem, String functionnalities,
			String keyword, Company company, TemplatePFE templatePFE) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.problem = problem;
		this.functionnalities = functionnalities;
		this.keyword = keyword;
		this.company = company;
		this.templatePFE = templatePFE;
		//Categorys = categorys;
	}

	public GradProjectFile() {
	}

	
	@Override
	public String toString() {
		return "GradProjectFile [id=" + id + ", title=" + title + ", description=" + description + ", problem="
				+ problem + ", functionnalities=" + functionnalities + ", keyword=" + keyword + ", company=" + company
				+ ", templatePFE=" + templatePFE + ", Categorys=" + Categorys + "]";
	}

	public double getNote_rapporteur() {
		return note_rapporteur;
	}

	public void setNote_rapporteur(double note_rapporteur) {
		this.note_rapporteur = note_rapporteur;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateRapport() {
		return stateRapport;
	}

	public void setStateRapport(String stateRapport) {
		this.stateRapport = stateRapport;
	}

	public String getAnneeScolairee() {
		return anneeScolairee;
	}

	public void setAnneeScolairee(String anneeScolairee) {
		this.anneeScolairee = anneeScolairee;
	}

	public Date getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradProjectFile other = (GradProjectFile) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public Teacher getEncadreur() {
		return encadreur;
	}
	
	public boolean getValidated() {
		return validated;
	}
	public void setEncadreur(Teacher encadreur) {
		this.encadreur = encadreur;
	}
public void setValidated(boolean validated) {
	this.validated = validated;
}
	

public String getNouveau() {
	return nouveau;
}
public void setNouveau(String nouveau) {
	this.nouveau = nouveau;
}

	
public double getNote_encadrant() {
	return note_encadrant;
}
public void setNote_encadrant(double note_encadrant) {
	this.note_encadrant = note_encadrant;
}
	
	

}
