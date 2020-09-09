package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.Reclamation;
import tn.pfe.entity.Student;

/**
 * Session Bean implementation class ReclamationsServices
 */
@Stateless
@LocalBean
public class ReclamationsServices implements ReclamationsServicesRemote, ReclamationsServicesLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
	
    public ReclamationsServices() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void Ajouterreclamation(Reclamation r, int idstu) {
    	Student student = em.find(Student.class, idstu);
    	r.setStudent(student);
    	em.persist(r);
    	student.setReclamation(r);
    }
    @Override
    public void deletereclamation(int recid) {
    	em.remove(em.find(Reclamation.class, recid));
    	
    }
    @Override
    public List<Reclamation> listerreclamation() {
    	return em.createQuery("select r from Reclamation r",Reclamation.class).getResultList();
    }
    @Override
    public void traiterreclamation(int recid) {
    	Reclamation reclamation = em.find(Reclamation.class, recid);
    	reclamation.setTraite(true);
    }
}
