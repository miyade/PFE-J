package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
@Entity
public class Reclamation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String contenu;
	
	private Boolean traite;
	
	private String sujet;
	
	private int type;
	
	@OneToOne(mappedBy="reclamation")
	private Student student;
	
	
	
	
	public Reclamation() {
		// TODO Auto-generated constructor stub
	}
	public String getContenu() {
		return contenu;
	}
	public int getId() {
		return id;
	}
	public Student getStudent() {
		return student;
	}
	public String getSujet() {
		return sujet;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Boolean getTraite() {
		return traite;
	}
	public void setTraite(Boolean traite) {
		this.traite = traite;
	}
	
}
