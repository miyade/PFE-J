package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recomendation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private float Rate;
	
	private String Comment;

	@ManyToOne
	@JoinColumn(name ="IdTeacher", referencedColumnName = "Id", insertable = false, updatable = false)
	private Teacher Teacher;
	
	@ManyToOne
	@JoinColumn(name ="IdSkill", referencedColumnName = "Id", insertable = false, updatable = false)
	private Skill Skill;
	
	
	
	
	
	public Recomendation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getRate() {
		return Rate;
	}

	public void setRate(float rate) {
		Rate = rate;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
	
	
	
	
	
}
