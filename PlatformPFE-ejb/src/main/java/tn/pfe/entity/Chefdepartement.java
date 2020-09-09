package tn.pfe.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@XmlRootElement(name="chefdepartement")
public class Chefdepartement extends User implements Serializable {
	
	@OneToOne(mappedBy ="chefdepartement",cascade= CascadeType.ALL,fetch =FetchType.EAGER)
	private Departement departement ;
	
	@ManyToOne
	private Admin adminchefdep;
	
	
	@XmlElement
public Admin getAdminchefdep() {
		return adminchefdep;
	}

	public void setAdminchefdep(Admin adminchefdep) {
		this.adminchefdep = adminchefdep;
	}

@XmlTransient
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
