package tn.esprit.Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class servicesites
 */
@Stateless
@LocalBean
public class servicesites implements servicesitesRemote ,servicesiteLocal{

    @PersistenceContext
    EntityManager em ;
    public servicesites() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addsite(Site site) {
		em.persist(site);
		
		// TODO Auto-generated method stub
		return "site ajouter avec sucees";
	}

	@Override
	public void affecter_A_toS(int id_site, int id_admin) {
		Site site= em.find(Site.class,id_site);
		Admin admin= em.find(Admin.class, id_admin);
		site.setAdmin(admin);
		admin.getSites().add(site);
		
	}

	@Override
	public List<Site> affsite() {
		
		return (List<Site>) em.createQuery("select e from Site e ",Site.class).getResultList();
	}

	@Override
	public void deletesitebyid(int ids) {
		em.createQuery("DELETE from Site s where s.id=:id").setParameter("id", ids).executeUpdate();		
	}

	@Override
	public void updatesite(Site s) {
		Site siteupdate= em.find(Site.class, s.getId());
		siteupdate.setAddresse(s.getAddresse());
		siteupdate.setNom(s.getNom());
	}

	@Override
	public void affecter_DS_toS(int id_site, int id_ds) {
		Site s = em.find(Site.class, id_site);
		Directeurdestages ds= em.find(Directeurdestages.class, id_ds);
		s.setDirecteurdesstages(ds);
		ds.getSites().add(s);
		
	}

	@Override
	public Site getSiteById(int id) {
		// TODO Auto-generated method stub
		return em.find(Site.class, id);
	}

	@Override
	public Site getsiteByidDirecteur(int id) {
		// TODO Auto-generated method stub
		List<Site> listsites = new ArrayList<>();
		listsites = em.createQuery("select e from Site e where directeurdesstages.id = :id").setParameter("id", id).getResultList();
		
		return listsites.get(0);
	}

}
