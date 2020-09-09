package tn.esprit.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.pfe.entity.Archive_GradProjectFile;
import tn.pfe.entity.Chefdepartement;
import tn.pfe.entity.Directeurdestages;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Site;
import tn.pfe.entity.Student;
import tn.pfe.entity.User;

/**
 * Session Bean implementation class DirecteurService
 */
@Stateless
@LocalBean
public class DirecteurService implements DirecteurServiceRemote, DirecteurServiceLocal {

	@PersistenceContext
	public EntityManager em;
    /**
     * Default constructor. 
     */
    public DirecteurService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int enableStudent(int id) {
    	Query query = em.createQuery("UPDATE User f SET isEnable=:enable WHERE f.id=:id");
    	query.setParameter("enable", true);
    	query.setParameter("id",id);
    	return query.executeUpdate();
    }
    
    @Override
    public int validateRapport(int id) {
    	Query query = em.createQuery("UPDATE GradProjectFile f SET stateRapport=:valide WHERE f.id=:id");
    	query.setParameter("valide", "valide");
    	query.setParameter("id",id);
    	return query.executeUpdate();
    }
    @Override
    public GradProjectFile findGradFile(int id) {
    	return em.find(GradProjectFile.class, id);
    }
    @Override
    public int maxAction(int id) {
    	Query query = em.createQuery("UPDATE User f SET maxAction=:nbr WHERE f.id=:id");
    	query.setParameter("valide", "valide");
    	query.setParameter("id",id);
    	return query.executeUpdate();
    }
    @Override
	public List<Student> getStudentsWithoutPFE(String as){
		List<Student> Students ;
		TypedQuery<Student> query =  em.createQuery("Select s from Student s where s.grade=:grade and s.PfeFile=NULL and EXTRACT(YEAR FROM s.dateCreation)=:annee",Student.class);
				query.setParameter("grade", Integer.valueOf(5));
				query.setParameter("annee", Integer.parseInt(as.substring(0, 4)));
		return query.getResultList();
	}
    @Override
	public List<Student> getStudentsWithoutPFEPeriode(String deb,String fin){
		List<Student> Students ;
		Query query =  em.createQuery("Select s from Student s where s.grade=:grade and s.PfeFile=NULL and EXTRACT(YEAR FROM s.dateCreation) BETWEEN :annee1 AND :annee2")
				.setParameter("grade", 5)
				.setParameter("annee1",Integer.parseInt(deb.substring(0,4)))
				.setParameter("annee2",Integer.parseInt(fin.substring(0,4)));
		Students = query.getResultList();
		return Students;
	}
    @Override
    public int acceptSheet(int id) {
    	Query query = em.createQuery("UPDATE GradProjectFile g SET g.state=:valide WHERE g.id=:id");
    	query.setParameter("valide", "acceptée");
    	query.setParameter("id",id);
    	return query.executeUpdate();
    }
    @Override
    public int refuseSheet(int id) {
    	Query query = em.createQuery("UPDATE GradProjectFile g SET g.state=:refuse WHERE g.id=:id");
    	query.setParameter("refuse", "refusée");
    	query.setParameter("id",id);
    	return query.executeUpdate();
    }
    @Override
    public int cancelSheet(int id,String decision) {
    	Query query = em.createQuery("UPDATE GradProjectFile g SET g.state=:refuse WHERE g.id=:id");
    	query.setParameter("refuse", decision);
    	query.setParameter("id",id);
    	return query.executeUpdate();
    }
    @Override
    public void addSheetToArchive(GradProjectFile g,Student s) {
    	Archive_GradProjectFile ar=new Archive_GradProjectFile();
		ar.setGrad(g);
		Student s1=em.find(Student.class, s.getId());
		s1.setPfeFile(null);
		ar.setStudent(s1);
    	em.persist(ar);
    }
    @Override 
    public User getChefDepartement() {
		TypedQuery<Chefdepartement> query =  em.createQuery("Select s from Chefdepartement s ",Chefdepartement.class);
		return query.getSingleResult();
    }

	@Override
	public Site getSiteDirecteurStage(int id) {
		// TODO Auto-generated method stub
		Set<Site> Listesites = new HashSet<Site>();

		Listesites = em.find(Directeurdestages.class, id).getSites();

		for (Site site : Listesites) {
				return site;
		}
		return null;

	}
}
