package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class SectionService
 */
@Stateless
@LocalBean
public class SectionService implements SectionServiceRemote, SectionServiceLocal {

	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SectionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addSection(Section sec, int idT) {
		em.persist(sec);
		
		Teacher t = em.find(Teacher.class, idT);
		Section s = em.find(Section.class, sec.getId());
		
		s.setTeacher(t);
		return sec.getId();
	}

	@Override
	public List<Section> getTeacherSectionofTeacherById(int id) {
		
	TypedQuery<Section> q= em.createQuery("select s from Section s where s.teacher.id =:id ",Section.class);
				q.setParameter("id", id);
				return q.getResultList();
	}

}
