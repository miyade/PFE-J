package tn.pfe.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name="Classes")
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String nomclasse ;
private int nbretudiant ;
 @ManyToOne
 private Admin admin;
 @OneToMany(mappedBy="classe",fetch= FetchType.EAGER, cascade= CascadeType.ALL)
 private Set<Soutenance>  soutenance=new HashSet<Soutenance>() ;
 
 
 @XmlTransient
public Set<Soutenance> getSoutenance() {
	return soutenance;
}
public void setSoutenance(Set<Soutenance> soutenance) {
	this.soutenance = soutenance;
}
@XmlAttribute
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
@XmlElement
public String getNomclasse() {
	return nomclasse;
}
public void setNomclasse(String nomclasse) {
	this.nomclasse = nomclasse;
}
@XmlElement
public int getNbretudiant() {
	return nbretudiant;
}
public void setNbretudiant(int nbretudiant) {
	this.nbretudiant = nbretudiant;
}
@XmlElement
public Admin getAdmin() {
	return admin;
}
public void setAdmin(Admin admin) {
	this.admin = admin;
}

}
