package tn.pfe.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ActionTeacher implements Serializable {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String Description;
	
	private Timestamp dateaction = new Timestamp(System.currentTimeMillis());

	@ManyToOne
	@JsonIgnore
	private Teacher teacher;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public ActionTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlTransient
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ActionTeacher( String title, String description, Teacher teacher) {
		super();
		this.title = title;
		Description = description;
		this.teacher = teacher;
	}

	public Timestamp getDateaction() {
		return dateaction;
	}

	public void setDateaction(Timestamp dateaction) {
		this.dateaction = dateaction;
	}
	
	
	
}
