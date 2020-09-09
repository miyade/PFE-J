package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class servicedirecteurstage
 */
@Stateless
@LocalBean
public class servicedirecteurstage implements servicedirecteurstageRemote, servicedirecteurstageLocal {

    @PersistenceContext
    EntityManager em ;
    public servicedirecteurstage() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addedirecteur(Directeurdestages ds) {
		em.persist(ds);
		
		return "directeur de stage ajouter";
	}

	@Override
	public void affecter_A_toD(int id_ds, int id_admin) {
		Directeurdestages ds= em.find(Directeurdestages.class,id_ds);
		Admin admin= em.find(Admin.class, id_admin);
		ds.setAdminds(admin);
		admin.getDirecteurdesstages().add(ds);
		
		
	}

	@Override
	public List<Directeurdestages> affedirecteur() {
		
		return (List<Directeurdestages>) em.createQuery("select d from Directeurdestages d ",Directeurdestages.class).getResultList();
	}

	@Override
	public void deletedirecteurbyid(int idds) {
		em.createQuery("DELETE from  Directeurdestages s where s.id=:id").setParameter("id", idds).executeUpdate();		
		
	}

	@Override
	public void updatdirecteur(Directeurdestages ds) {
		Directeurdestages dsupdate = em.find(Directeurdestages.class, ds.getId());
		dsupdate.setEmail(ds.getEmail());
		
		dsupdate.setFirstName(ds.getFirstName());
		dsupdate.setPassword(ds.getPassword());
		dsupdate.setFirstName(ds.getFirstName());
		
		
	}
	
	@Override
	public Directeurdestages getdirecteurbyid(int id) {
		// TODO Auto-generated method stub
		return em.find(Directeurdestages.class, id);
}

}
