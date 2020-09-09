package tn.pfe.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name="Soutenance")
public class Soutenance implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String nomSoutenance ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datesoutenance ;
	
	@OneToOne(cascade =CascadeType.MERGE,fetch=FetchType.EAGER)
	private GradProjectFile pfe ;
	
	@ManyToOne (cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	private Classes classe ;
	
	@XmlElement
public Classes getClasse() {
		return classe;
	}

	public void setClasse(Classes classe) {
		this.classe = classe;
	}

@XmlAttribute
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
@XmlElement
	public String getNomSoutenance() {
		return nomSoutenance;
	}

	public void setNomSoutenance(String nomSoutenance) {
		this.nomSoutenance = nomSoutenance;
	}






@XmlElement
	public Date getDatesoutenance() {
	return datesoutenance;
}
public void setDatesoutenance(Date datesoutenance) {
	this.datesoutenance = datesoutenance;
}

@XmlTransient
public GradProjectFile getPfe() {
	return pfe;
}
	public void setPfe(GradProjectFile pfe) {
		this.pfe = pfe;
	}
	
	

}
