package tn.pfe.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;




@Entity
@XmlRootElement(name = "teacher")
public class Teacher  extends User  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String image;
	private String departement;

	private int nbmaxprevalidation;
	private int nbmaxencadrement;
	private int nbmaxrap;

	private int maxAction;


	@ManyToMany(fetch = FetchType.EAGER)//our l xml
	private Set<projectCategory> PreferedCategories = new HashSet<>();
	
	
	@OneToMany(mappedBy = "Teacher", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<projectCategory> categoriesProposed = new HashSet<>() ;
	

	@OneToMany(mappedBy = "teacher" , cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Section> Sections = new HashSet<>();
	
	
	@OneToMany(mappedBy = "Teacher" , cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Recomendation> Recomendations = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Skill> Skills = new HashSet<>();
	
	
	@OneToMany(mappedBy = "encadrants", cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Student> EtudiantAEncadrer = new HashSet<>();
	
	@OneToMany(mappedBy = "rapporteurs", cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Student> Etudiantarapporter = new HashSet<>();
	
	@OneToMany(mappedBy = "prevalidateur", cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Student> Etudiantaprevalider = new HashSet<>();
	
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
	private Set<ActionTeacher> ActionsTeacher = new HashSet<>();
	
	@OneToMany(mappedBy="encadreur" ,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<GradProjectFile> pfeencadre = new HashSet<>();
	
	@OneToMany(mappedBy = "president", fetch = FetchType.EAGER)
	private Set<Student> Etudiantsapresident = new HashSet<>();
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
	private Set<Notification> notifications  = new HashSet<>();
	
	
	public void addCategorie(projectCategory c) {
		c.setTeacher(this);
		this.categoriesProposed.add(c);
	}
	
	
	@XmlTransient
	public Set<Student> getEtudiantAEncadrer() {
		return EtudiantAEncadrer;
	}



	public void setEtudiantAEncadrer(Set<Student> etudiantAEncadrer) {
		EtudiantAEncadrer = etudiantAEncadrer;
	}


	@XmlTransient
	public Set<Student> getEtudiantarapporter() {
		return Etudiantarapporter;
	}



	public void setEtudiantarapporter(Set<Student> etudiantarapporter) {
		Etudiantarapporter = etudiantarapporter;
	}



	@XmlTransient
	public Set<Skill> getSkills() {
		return Skills;
	}



	public void setSkills(Set<Skill> skills) {
		Skills = skills;
	}


	@XmlTransient
	public Set<Recomendation> getRecomendations() {
		return Recomendations;
	}



	public void setRecomendations(Set<Recomendation> recomendations) {
		Recomendations = recomendations;
	}


	@XmlElement
	@XmlElementWrapper
	@XmlTransient
	public Set<projectCategory> getCategoriesProposed() {
		return categoriesProposed;
	}



	public void setCategoriesProposed(Set<projectCategory> categoriesProposed) {
		this.categoriesProposed = categoriesProposed;
	}


	@XmlTransient
	public Set<Section> getSections() {
		return Sections;
	}



	public void setSections(Set<Section> sections) {
		Sections = sections;
	}


	@XmlElement
	@XmlElementWrapper
	@XmlTransient
	public Set<projectCategory> getPreferedCategories() {
		return PreferedCategories;
	}



	public void setPreferedCategories(Set<projectCategory> preferedCategories) {
		PreferedCategories = preferedCategories;
	}



	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
   @XmlElement
	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}


	@XmlElement
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@XmlTransient
	public Set<ActionTeacher> getActionsTeacher() {
		return ActionsTeacher;
	}


	public void setActionsTeacher(Set<ActionTeacher> actionsTeacher) {
		ActionsTeacher = actionsTeacher;
	}

	@XmlTransient
	public Set<Student> getEtudiantsapresident() {
		return Etudiantsapresident;
	}
	

	public void setEtudiantsapresident(Set<Student> etudiantsapresident) {
		Etudiantsapresident = etudiantsapresident;
	}



	public Teacher(String email, String password, boolean isEnable) {
		super(email, password, isEnable);
		// TODO Auto-generated constructor stub
	}


	public Teacher(String lastName, String firstName, String email, String password, int phoneNumber, Date birthDay,
			Boolean isEnable, Boolean connected, String token, Date dateCreation, Date lastConnect) {
		super(lastName, firstName, email, password, phoneNumber, birthDay, isEnable, connected, token, dateCreation,
				lastConnect);
		// TODO Auto-generated constructor stub
	}


	public Teacher(String image, String departement, Set<projectCategory> preferedCategories,
			Set<projectCategory> categoriesProposed, Set<Section> sections, Set<Recomendation> recomendations,
			Set<Skill> skills, Set<Student> etudiantAEncadrer, Set<Student> etudiantarapporter,
			Set<ActionTeacher> actionsTeacher, Set<Student> etudiantsapresident) {
		super();
		this.image = image;
		this.departement = departement;
		PreferedCategories = preferedCategories;
		this.categoriesProposed = categoriesProposed;
		Sections = sections;
		Recomendations = recomendations;
		Skills = skills;
		EtudiantAEncadrer = etudiantAEncadrer;
		Etudiantarapporter = etudiantarapporter;
		ActionsTeacher = actionsTeacher;

		Etudiantsapresident = etudiantsapresident;

	}
	



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (ActionsTeacher == null) {
			if (other.ActionsTeacher != null)
				return false;
		} else if (!ActionsTeacher.equals(other.ActionsTeacher))
			return false;
		if (EtudiantAEncadrer == null) {
			if (other.EtudiantAEncadrer != null)
				return false;
		} else if (!EtudiantAEncadrer.equals(other.EtudiantAEncadrer))
			return false;
		if (Etudiantarapporter == null) {
			if (other.Etudiantarapporter != null)
				return false;
		} else if (!Etudiantarapporter.equals(other.Etudiantarapporter))
			return false;
		if (Etudiantsapresident == null) {
			if (other.Etudiantsapresident != null)
				return false;
		} else if (!Etudiantsapresident.equals(other.Etudiantsapresident))
			return false;
		if (PreferedCategories == null) {
			if (other.PreferedCategories != null)
				return false;
		} else if (!PreferedCategories.equals(other.PreferedCategories))
			return false;
		if (Recomendations == null) {
			if (other.Recomendations != null)
				return false;
		} else if (!Recomendations.equals(other.Recomendations))
			return false;
		if (Sections == null) {
			if (other.Sections != null)
				return false;
		} else if (!Sections.equals(other.Sections))
			return false;
		if (Skills == null) {
			if (other.Skills != null)
				return false;
		} else if (!Skills.equals(other.Skills))
			return false;
		if (categoriesProposed == null) {
			if (other.categoriesProposed != null)
				return false;
		} else if (!categoriesProposed.equals(other.categoriesProposed))
			return false;
		if (departement == null) {
			if (other.departement != null)
				return false;
		} else if (!departement.equals(other.departement))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;

		return true;


	}

	
	public int getMaxAction() {
		return maxAction;
	}


	public void setMaxAction(int maxAction) {
		this.maxAction = maxAction;
	}


	
public int getNbmaxencadrement() {
	return nbmaxencadrement;
}
public void setNbmaxencadrement(int nbmaxencadrement) {
	this.nbmaxencadrement = nbmaxencadrement;
}
public int getNbmaxprevalidation() {
	return nbmaxprevalidation;
}
public void setNbmaxprevalidation(int nbmaxprevalidation) {
	this.nbmaxprevalidation = nbmaxprevalidation;
}
public int getNbmaxrap() {
	return nbmaxrap;
}
public void setNbmaxrap(int nbmaxrap) {
	this.nbmaxrap = nbmaxrap;
}
	@XmlTransient
	public Set<GradProjectFile> getPfeencadre() {
		return pfeencadre;
	}
	
	public void setPfeencadre(Set<GradProjectFile> pfeencadre) {
		this.pfeencadre = pfeencadre;
	}
	@XmlTransient
	public Set<Notification> getNotifications() {
		return notifications;
	}
	
	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	@XmlTransient
	public Set<Student> getEtudiantaprevalider() {
		return Etudiantaprevalider;
	}
	public void setEtudiantaprevalider(Set<Student> etudiantaprevalider) {
		Etudiantaprevalider = etudiantaprevalider;
	}
	@Override
	public String toString() {
		return getFirstName()+" "+getLastName();		
	}
}
