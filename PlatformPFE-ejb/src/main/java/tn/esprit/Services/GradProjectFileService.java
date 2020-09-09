package tn.esprit.Services;


import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.OldPfe;
import tn.pfe.entity.Student;

import javax.persistence.TypedQuery;

import tn.pfe.entity.GradProjectFile;


/**
 * Session Bean implementation class GradProjectFileService
 */
@Stateless
@LocalBean
public class GradProjectFileService implements GradProjectFileServiceRemote, GradProjectFileServiceLocal {


    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;


	
    public GradProjectFileService() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void addPfe(GradProjectFile pfe) {
    	em.persist(pfe);
    	
    }
    @Override
    public void deletepfe(int id) {
    	GradProjectFile ppPfe = new GradProjectFile();
    	OldPfe oPfe = new OldPfe();
		oPfe.setMotif(ppPfe.getMotif());
		Date datemodi = new Date();		
		oPfe.setDatemodif(datemodi);
		oPfe.setEvent("deleted");
		Student ssStudent = new Student();
		if(ppPfe.getStudent()!=null) {
		ssStudent.setLastName(ppPfe.getStudent().getLastName());
		ssStudent.setFirstName(ppPfe.getStudent().getFirstName());
		oPfe.setEmetteur(ssStudent.getFirstName()+ssStudent.getLastName());
		
		em.persist(oPfe);
    	em.remove(em.find(GradProjectFile.class, id));}
		else {
			em.remove(em.find(GradProjectFile.class, id));
		}
    	
    }
    @Override
    public List<GradProjectFile> GetPfe() {
    	return (List<GradProjectFile>) em.createQuery(" select c from GradProjectFile c where c.validated = 1 ",GradProjectFile.class).getResultList();
    }
    @Override
    public List<GradProjectFile> GetPfeValidated() {
    	return (List<GradProjectFile>) em.createQuery(" select c from GradProjectFile c where c.validated = 1 ",GradProjectFile.class).getResultList();
    }
    @Override
    public List<OldPfe> getoldpfe() {
    	return (List<OldPfe>) em.createQuery(" select c from OldPfe c ",OldPfe.class).getResultList();
    }
    @Override
    public void updatepfe(GradProjectFile pfe, int id) {
    	// System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*"+pfe.getMotif()+"/*//*/*/*/*"+id);
    	Student ssStudent = new Student() ;
    	GradProjectFile ppPfe = em.find(GradProjectFile.class, id);
    	TypedQuery<Student> query = em.createQuery("SELECT f FROM Student f WHERE f.PfeFile.id=:id", Student.class);
    	query.setParameter("id", ppPfe.getId());
    	if(query.getResultList().size() != 0) {
		ssStudent =  query.getResultList().get(0);}
    	if(ppPfe != null) {
    		System.out.println("ahla");
    	OldPfe oPfe = new OldPfe();
		oPfe.setMotif(ppPfe.getMotif());
		oPfe.setNote(ppPfe.getNote());
		Date datemodi = new Date();		
		oPfe.setDatemodif(datemodi);
		//oPfe.setEvent("modification");
		oPfe.setDescription(ppPfe.getDescription());
		if(ppPfe.getEncadreur() != null) {
		oPfe.setEncadreur(ppPfe.getEncadreur());}
		if(ssStudent.getFirstName()!= null && ssStudent.getLastName()!=null) {
		oPfe.setEmetteur(ssStudent.getFirstName()+" "+ssStudent.getLastName());		}	
		ppPfe.setMotif(pfe.getMotif());
		ppPfe.setNote(pfe.getNote());
		ppPfe.setNote_rapporteur(pfe.getNote_rapporteur());
		ppPfe.setDescription(pfe.getDescription());
		em.persist(ppPfe);
		String a = "";
		if(oPfe.getDescription()!=null && ppPfe.getDescription()!=null && !oPfe.getDescription().equals(ppPfe.getDescription())) {
			a = a+"changement de description / ";
			
			oPfe.setDescription("nouvelle description : "+ppPfe.getDescription()+" | ancienne description : "+oPfe.getDescription());
		}
		if(oPfe.getEncadreur()!=null && ppPfe.getEncadreur()!=null && !oPfe.getEncadreur().equals(ppPfe.getEncadreur())) {
			a = a+"changement d'encadreur / ";
		}
		if( oPfe.getNote() != ppPfe.getNote()) {
			a = a+"changement de note de la fiche pfe / ";
		}
		if(oPfe.getNote_rapporteur()!= ppPfe.getNote_rapporteur()) {
			a = a+"changement de note rapporteur / ";
		}
		if(!oPfe.getMotif().equals(ppPfe.getMotif())) {
			a = a+"changement de Motif / ";			
			oPfe.setMotif("nouveau motif : "+ppPfe.getMotif()+" | ancien motif : "+oPfe.getMotif());
		}
		oPfe.setEvent(a);
		em.persist(oPfe);
    }else {
    	System.out.println("non trouvé");
    	System.out.println(id);
    }
    	
    }
    


    public GradProjectFile searchSheet(int id)
    {
    	return em.find(GradProjectFile.class, id);
    }
    @Override
    public List<GradProjectFile> getSheetsByEtat(String etat){
    	TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.state=:etat ", GradProjectFile.class);
    	query.setParameter("etat", etat);
		return query.getResultList();
    }

    @Override 
    public List<GradProjectFile> getSheetsByYear(String year){
    	TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.anneeScolairee=:year ", GradProjectFile.class);
    	query.setParameter("year", year);
		return query.getResultList();
    }
    @Override
    public List<GradProjectFile> getSheetsByPays(String pays){
    	TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.pays=:pays ", GradProjectFile.class);
    	query.setParameter("pays", pays);
		return query.getResultList();
    }
	@Override
	public List<GradProjectFile> getSheetsOfYear(){
		TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.state=:state AND f.anneeScolairee=:year ORDER BY f.dateSaisie DESC ", GradProjectFile.class);
    	query.setParameter("state", "encours");
    	query.setParameter("year", Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.YEAR)+1));
		return query.getResultList();
	}
	@Override
	public List<GradProjectFile> getWaitingDefense(){
		TypedQuery<GradProjectFile> query = em.createQuery("SELECT f FROM GradProjectFile f WHERE f.note>:noteE AND f.note_rapporteur>:noteR ", GradProjectFile.class);
    	query.setParameter("noteE", 0);
    	query.setParameter("noteR", 0);
		return query.getResultList();
	}
	
}
