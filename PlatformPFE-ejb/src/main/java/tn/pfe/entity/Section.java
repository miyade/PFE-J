package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Section implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	
	private String Title;
	
	private String Description;
	
	private String Entreprisedacceuil;
	
	@Enumerated(EnumType.STRING)
	private SectionType Section;

	@ManyToOne
	private Teacher teacher;
	
	
	
	
	
	@XmlElement
	public String getEntreprisedacceuil() {
		return Entreprisedacceuil;
	}




	public void setEntreprisedacceuil(String entreprisedacceuil) {
		Entreprisedacceuil = entreprisedacceuil;
	}




	@XmlElement
	public Teacher getTeacher() {
		return teacher;
	}




	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}




	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}



    @XmlElement
	public int getId() {
		return Id;
	}




	public void setId(int id) {
		Id = id;
	}



	@XmlElement
	public String getTitle() {
		return Title;
	}




	public void setTitle(String title) {
		Title = title;
	}



	@XmlElement
	public String getDescription() {
		return Description;
	}




	public void setDescription(String description) {
		Description = description;
	}



	@XmlElement
	public SectionType getSection() {
		return Section;
	}




	public void setSection(SectionType section) {
		Section = section;
	}
	
	
}
