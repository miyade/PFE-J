package tn.pfe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name="departement")
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String nomdepartement ;
	private String codedepartement ;
	
	@ManyToOne 
	private Admin admin ;
	
	@OneToOne
	private Chefdepartement chefdepartement ;
	
	@XmlTransient
public Chefdepartement getChefdepartement() {
		return chefdepartement;
	}

	public void setChefdepartement(Chefdepartement chefdepartement) {
		this.chefdepartement = chefdepartement;
	}

@XmlAttribute
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
@XmlElement
	public String getNomdepartement() {
		return nomdepartement;
	}

	public void setNomdepartement(String nomdepartement) {
		this.nomdepartement = nomdepartement;
	}
@XmlElement
	public String getCodedepartement() {
		return codedepartement;
	}

	public void setCodedepartement(String codedepartement) {
		this.codedepartement = codedepartement;
	}
@XmlElement
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
