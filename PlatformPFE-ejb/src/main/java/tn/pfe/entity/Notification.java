package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Notification implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String contenu;
	
	private boolean vu;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Teacher teacher;
	
 public Notification() {
	// TODO Auto-generated constructor stub
}
 public String getContenu() {
	return contenu;
}
@XmlTransient
 public Student getStudent() {
	return student;
}
@XmlTransient
 public Teacher getTeacher() {
	return teacher;
}
 public void setContenu(String contenu) {
	this.contenu = contenu;
}
 public void setStudent(Student student) {
	this.student = student;
}
 public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
 public void setVu(boolean vu) {
	this.vu = vu;
}
 
}
