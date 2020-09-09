package tn.pfe.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TemplatePFE implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Template;
	
	@JsonIgnore
	@OneToOne
	private Site site;
	
	@OneToMany(mappedBy="templatePFE" , fetch=FetchType.EAGER)
	private List<GradProjectFile> gradProjectFiles;
	
	
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
	
	
	
	public List<GradProjectFile> getGradProjectFiles() {
		return gradProjectFiles;
	}
	public void setGradProjectFiles(List<GradProjectFile> gradProjectFiles) {
		this.gradProjectFiles = gradProjectFiles;
	}
	public TemplatePFE(String template) {
		Template = template;
	}
	
	
	
	public TemplatePFE() {
	}
	
	public TemplatePFE(int id, String template, Site site, List<GradProjectFile> gradProjectFiles) {
		this.id = id;
		Template = template;
		this.site = site;
		this.gradProjectFiles = gradProjectFiles;
	}
	
	
	@Override
	public String toString() {
		return "TemplatePFE [id=" + id + ", Template=" + Template + ", site=" + site + ", gradProjectFiles="
				+ gradProjectFiles + "]";
	}
	public TemplatePFE(int id, String template, Site site) {
		this.id = id;
		Template = template;
		this.site = site;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public TemplatePFE(String template, Site site) {
		Template = template;
		this.site = site;
	}
	
	

	
	
	
	
	
	
	
	
	

}
