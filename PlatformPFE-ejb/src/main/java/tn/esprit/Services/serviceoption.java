package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class serviceoption
 */
@Stateless
@LocalBean
public class serviceoption implements serviceoptionRemote, serviceoptionLocal {

    @PersistenceContext
    EntityManager em ;
    public serviceoption() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addoption(Options o) {
		em.persist(o);
		return "option ajouter";
	}

	@Override
	public void affecter_A_toO(int id_o, int id_admin) {
	 Options O =em.find(Options.class,id_o);
	 Admin a = em.find(Admin.class, id_admin);
	 O.setAdmin(a);
	 a.getOptions().add(O);
		
	}

	@Override
	public List<Options> affoption() {
		// TODO Auto-generated method stub
		return (List<Options>) em.createQuery("select o from Options o ",Options.class).getResultList();
	}

	@Override
	public void deleteoptionbyid(int ido) {
		// TODO Auto-generated method stub
		em.createQuery("DELETE from Options o where o.id=:id" ).setParameter("id", ido).executeUpdate();
	}

	@Override
	public void updateoption(Options ds) {
		Options oup=em.find(Options.class, ds.getId());
		oup.setNom(ds.getNom());
		
	}

}
