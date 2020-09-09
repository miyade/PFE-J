package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CoachCompany extends User implements Serializable{

	//private int attr;
	@ManyToOne
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CoachCompany(String email, String password, boolean isEnable) {
		super(email, password, isEnable);
	}


	public CoachCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
