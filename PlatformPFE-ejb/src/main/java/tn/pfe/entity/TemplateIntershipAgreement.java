package tn.pfe.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TemplateIntershipAgreement implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Template;
	
	@JsonIgnore
	@OneToOne
	private Site site;
	
	@OneToMany(mappedBy="templateIntershipAgreement" ,fetch =FetchType.EAGER)
	private Set<InternshipAgreement> internshipAgreement;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTemplate() {
		return Template;
	}
	public void setTemplate(String template) {
		Template = template;
	}
	
	
	
	
	public TemplateIntershipAgreement(String template) {
		Template = template;
	}

	public TemplateIntershipAgreement() {
	}
	
	
	@Override
	public String toString() {
		return "TemplatePFE [id=" + id + ", Template=" + Template + "]";
	}
	public TemplateIntershipAgreement(int id, String template, Set<InternshipAgreement> internshipAgreement) {
		this.id = id;
		Template = template;
		this.internshipAgreement = internshipAgreement;
	}
	public Set<InternshipAgreement> getInternshipAgreement() {
		return internshipAgreement;
	}
	public void setInternshipAgreement(Set<InternshipAgreement> internshipAgreement) {
		this.internshipAgreement = internshipAgreement;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}

	public TemplateIntershipAgreement(int id, String template, Site site) {
		this.id = id;
		Template = template;
		this.site = site;
	}
	
	
	
	
	
	
	

}
