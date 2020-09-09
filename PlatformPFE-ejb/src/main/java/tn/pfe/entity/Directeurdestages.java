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
@XmlRootElement(name="Directeurdestages")
public class Directeurdestages extends User implements Serializable {
	
	@OneToMany(mappedBy = "directeurdesstages",fetch =FetchType.EAGER,cascade= CascadeType.ALL)
	private Set<Site> sites = new HashSet<Site>();
	
	@ManyToOne
	private Admin adminds;
	


@XmlTransient
	public Set<Site> getSites() {
		return sites;
	}

	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}
@XmlElement
	public Admin getAdminds() {
		return adminds;
	}

	public void setAdminds(Admin adminds) {
		this.adminds = adminds;
	}





}
