package tn.pfe.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OldPfe extends GradProjectFile implements Serializable{
	@Id
	private int id;
	private Date datemodif;
	private String event;
	private String emetteur;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public OldPfe() {
	// TODO Auto-generated constructor stub
}
@Override
public Date getAnneeScolaire() {
	// TODO Auto-generated method stub
	return super.getAnneeScolaire();
}
@Override
public Set<projectCategory> getCategoriesoffile() {
	// TODO Auto-generated method stub
	return super.getCategoriesoffile();
}
@Override
public Set<projectCategory> getCategorys() {
	// TODO Auto-generated method stub
	return super.getCategorys();
}
@Override
public Company getCompany() {
	// TODO Auto-generated method stub
	return super.getCompany();
}
@Override
public String getDescription() {
	// TODO Auto-generated method stub
	return super.getDescription();
}
@Override
public String getFunctionnalities() {
	// TODO Auto-generated method stub
	return super.getFunctionnalities();
}

@Override
public String getKeyword() {
	// TODO Auto-generated method stub
	return super.getKeyword();
}
@Override
public String getMotif() {
	// TODO Auto-generated method stub
	return super.getMotif();
}
@Override
public double getNote() {
	// TODO Auto-generated method stub
	return super.getNote();
}
@Override
public double getNote_rapporteur() {
	// TODO Auto-generated method stub
	return super.getNote_rapporteur();
}
@Override
public String getProblem() {
	// TODO Auto-generated method stub
	return super.getProblem();
}
@Override
public Soutenance getSoutenance() {
	// TODO Auto-generated method stub
	return super.getSoutenance();
}
@Override
public tn.pfe.entity.Student getStudent() {
	// TODO Auto-generated method stub
	return super.getStudent();
}
@Override
public TemplatePFE getTemplatePFE() {
	// TODO Auto-generated method stub
	return super.getTemplatePFE();
}
@Override
public String getTitle() {
	// TODO Auto-generated method stub
	return super.getTitle();
}
public Date getDatemodif() {
	return datemodif;
}
public String getEmetteur() {
	return emetteur;
}
public String getEvent() {
	return event;
}
@Override
public void setAnneeScolaire(Date anneeScolaire) {
	// TODO Auto-generated method stub
	super.setAnneeScolaire(anneeScolaire);
}
@Override
public void setCategoriesoffile(Set<projectCategory> categoriesoffile) {
	// TODO Auto-generated method stub
	super.setCategoriesoffile(categoriesoffile);
}
@Override
public void setCategorys(Set<projectCategory> categorys) {
	// TODO Auto-generated method stub
	super.setCategorys(categorys);
}
@Override
public void setCompany(Company company) {
	// TODO Auto-generated method stub
	super.setCompany(company);
}
@Override
public void setDescription(String description) {
	// TODO Auto-generated method stub
	super.setDescription(description);
}
@Override
public void setFunctionnalities(String functionnalities) {
	// TODO Auto-generated method stub
	super.setFunctionnalities(functionnalities);
}
@Override
public void setKeyword(String keyword) {
	// TODO Auto-generated method stub
	super.setKeyword(keyword);
}
@Override
public void setMotif(String motif) {
	// TODO Auto-generated method stub
	super.setMotif(motif);
}
@Override
public void setNote(double note) {
	// TODO Auto-generated method stub
	super.setNote(note);
}
@Override
public void setNote_rapporteur(double note_rapporteur) {
	// TODO Auto-generated method stub
	super.setNote_rapporteur(note_rapporteur);
}
@Override
public void setPreValidated(boolean preValidated) {
	// TODO Auto-generated method stub
	super.setPreValidated(preValidated);
}
@Override
public void setProblem(String problem) {
	// TODO Auto-generated method stub
	super.setProblem(problem);
}
@Override
public void setSoutenance(Soutenance soutenance) {
	// TODO Auto-generated method stub
	super.setSoutenance(soutenance);
}
@Override
public void setStudent(tn.pfe.entity.Student student) {
	// TODO Auto-generated method stub
	super.setStudent(student);
}
@Override
public void setTemplatePFE(TemplatePFE templatePFE) {
	// TODO Auto-generated method stub
	super.setTemplatePFE(templatePFE);
}
@Override
public void setTitle(String title) {
	// TODO Auto-generated method stub
	super.setTitle(title);
}
public void setDatemodif(Date datemodif) {
	this.datemodif = datemodif;
}
public void setEmetteur(String emetteur) {
	this.emetteur = emetteur;
}
public void setEvent(String event) {
	this.event = event;
}

@Override
public String getAnneeScolairee() {
	// TODO Auto-generated method stub
	return super.getAnneeScolairee();
}
@Override
public Date getDateSaisie() {
	// TODO Auto-generated method stub
	return super.getDateSaisie();
}
@Override
public Teacher getEncadreur() {
	// TODO Auto-generated method stub
	return super.getEncadreur();
}
@Override
public int getId() {
	// TODO Auto-generated method stub
	return super.getId();
}
@Override
public String getNouveau() {
	// TODO Auto-generated method stub
	return super.getNouveau();
}
@Override
public String getPays() {
	// TODO Auto-generated method stub
	return super.getPays();
}
@Override
public String getState() {
	// TODO Auto-generated method stub
	return super.getState();
}
@Override
public String getStateRapport() {
	// TODO Auto-generated method stub
	return super.getStateRapport();
}
@Override
public boolean getValidated() {
	// TODO Auto-generated method stub
	return super.getValidated();
}
@Override
public void setAnneeScolairee(String anneeScolairee) {
	// TODO Auto-generated method stub
	super.setAnneeScolairee(anneeScolairee);
}
@Override
public void setDateSaisie(Date dateSaisie) {
	// TODO Auto-generated method stub
	super.setDateSaisie(dateSaisie);
}
@Override
public void setEncadreur(Teacher encadreur) {
	// TODO Auto-generated method stub
	super.setEncadreur(encadreur);
}
@Override
public void setId(int id) {
	// TODO Auto-generated method stub
	super.setId(id);
}
@Override
public void setNouveau(String nouveau) {
	// TODO Auto-generated method stub
	super.setNouveau(nouveau);
}
@Override
public void setPays(String pays) {
	// TODO Auto-generated method stub
	super.setPays(pays);
}
@Override
public void setState(String state) {
	// TODO Auto-generated method stub
	super.setState(state);
}
@Override
public void setStateRapport(String stateRapport) {
	// TODO Auto-generated method stub
	super.setStateRapport(stateRapport);
}
@Override
public void setValidated(boolean validated) {
	// TODO Auto-generated method stub
	super.setValidated(validated);
}



}
