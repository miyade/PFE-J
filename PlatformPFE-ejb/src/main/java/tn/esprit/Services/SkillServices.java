package tn.esprit.Services;

import java.util.List;
import java.util.Set;

import javax.ejb.FinderException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;
import tn.pfe.service.categorie.ProjectCategorie;

/**
 * Session Bean implementation class SkillServices
 */
@Stateless
@LocalBean
public class SkillServices implements SkillServicesRemote, SkillServicesLocal {

	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SkillServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addSkill(int idt,int idc) {
		
		Teacher t = em.find(Teacher.class, idt);
		projectCategory c = em.find(projectCategory.class, idc);
		Skill sk  = new Skill();
		sk.setCategorie(c);
		sk.getTeachers().add(t);
		em.persist(sk);
		t.getSkills().add(sk);

		
		
	
		return 1;
	}

	@Override
	public Set<Skill> getTeacherSkills(int idt) {
		
		Teacher t = em.find(Teacher.class, idt);
		
		return t.getSkills();
	}

}
