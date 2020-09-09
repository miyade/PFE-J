package tn.pfe.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Skill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	
	
	
	private double IndividualRate;

	@OneToMany(mappedBy = "Skill" , cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Recomendation> Recomendations = new HashSet<>();
	

	@ManyToMany(mappedBy = "Skills" , cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Teacher> Teachers = new HashSet<>();
	
	
	@ManyToOne
	private projectCategory categorie;
	
	
	
	
	public Set<Teacher> getTeachers() {
		return Teachers;
	}



	public void setTeachers(Set<Teacher> teachers) {
		Teachers = teachers;
	}



	public projectCategory getCategorie() {
		return categorie;
	}



	public void setCategorie(projectCategory categorie) {
		this.categorie = categorie;
	}



	public Set<Recomendation> getRecomendations() {
		return Recomendations;
	}



	public void setRecomendations(Set<Recomendation> recomendations) {
		Recomendations = recomendations;
	}



	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getIndividualRate() {
		return IndividualRate;
	}

	public void setIndividualRate(double individualRate) {
		IndividualRate = individualRate;
	}
	
	
	
	
	
	
}
