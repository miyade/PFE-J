package tn.esprit.Services;

import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class CategorieService
 */
@Stateless
@LocalBean
public class CategorieService implements CategorieServiceRemote, CategorieServiceLocal {

	
	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CategorieService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<projectCategory> getCategories() {
		
		return (List<projectCategory>) em.createQuery(" select c from projectCategory c ",projectCategory.class).getResultList();
	}

	@Override
	public int addCategorie(projectCategory c, int idt) {
		
		em.persist(c);
		Teacher t = em.find(Teacher.class, idt);
		t.getCategoriesProposed().add(c);
		c.setTeacher(t);
		
		return c.getId();
	}

	@Override
	public void deleteCategorieById(int idC) {
		em.createQuery("DELETE from projectCategory c where c.id=:id").setParameter("id", idC).executeUpdate();
	}

	@Override
	public void updateCtegorie(projectCategory c ) {
		
		projectCategory cToUpdade = em.find(projectCategory.class, c.getId());
		cToUpdade.setDescription(c.getDescription());
		cToUpdade.setName(c.getName());
		cToUpdade.setTeacher(c.getTeacher());
		
	}

	@Override
	public void affecterCategorieToTeacher(int idC, int idT) {
		
		Teacher t  = em.find(Teacher.class, idT);
		projectCategory c = em.find(projectCategory.class, idC);
		
		c.setTeacher(t);
		
	}

	@Override
	public void affecterCategoriePrefereToTeacher(int idC, int idT) {
		Teacher t = em.find(Teacher.class, idT);
		projectCategory c = em.find(projectCategory.class, idC);
		
		t.getPreferedCategories().add(c);
		c.getTeacherpreferdCategories().add(t);
		
	}

	@Override
	public void deletepreferedCategori(int idt, int idc) {
		System.out.println("*//*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/");
		
		
		
		
		
		/*
		Teacher t  = em.find(Teacher.class, idt);
		int i2 = 0;
		int capt2 = -1;
		
		
		for(Categorie cat: t.getPreferedCategories()) {
			if(cat.getId() == idc) {
				
				
				capt2 = i2;
			}
			i2++;
		}
		
		if(capt2 != -1) {
			t.getPreferedCategories().remove(capt2);
		}
		
		*/
		
		
		
		projectCategory c = em.find(projectCategory.class, idc);
	
		for(Teacher teach: c.getTeacherspreferdCategorie()) {
			if(teach.getId() == idt) {
				teach.getPreferedCategories().remove(c);
			
			}
		
		}
		
		
		
		//em.flush();
	}

	@Override
	public Set<projectCategory> getMyPreferedCtegories(int idt) {
		Teacher t  = em.find(Teacher.class, idt);
		return t.getPreferedCategories();
	}

	@Override
	public Set<projectCategory> getMyProposedCtegories(int idt) {
		Teacher t  = em.find(Teacher.class, idt);
		return t.getCategoriesProposed();
	}

	
	

	
    

}
