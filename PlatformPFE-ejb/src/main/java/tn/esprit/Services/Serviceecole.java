package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class Serviceecole
 */
@Stateless
@LocalBean
public class Serviceecole implements serviceecolelocal,Serviceecoleremote{
	@PersistenceContext
	EntityManager em ;
	
	
	
	@Override
	public String addecole(Ecole ecole) {
		em.persist(ecole);
		
		return "c bn" ;
	}

   
    public Serviceecole() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void affecter_A_toE(int id_ecole, int id_admin) {
		Ecole ecole= em.find(Ecole.class,id_ecole);
		Admin admin= em.find(Admin.class, id_admin);
		ecole.setAdmin(admin);
		admin.getEcoles().add(ecole);
	}


	@Override
	public List<Ecole> affecole() {
		
		
		// TODO Auto-generated method stub
	return	(List<Ecole>) em.createQuery("select e from Ecole e ",Ecole.class).getResultList();
	}
	@Override
	public void deleteecolebyid(int ide) {
		em.createQuery("DELETE from Ecole e where e.id=:id").setParameter("id", ide).executeUpdate();
	}
	@Override
	public void updateecole(Ecole e ) {
		Ecole etoupdate= em.find(Ecole.class, e.getId());
		etoupdate.setAdmin(e.getAdmin());
		etoupdate.setLogo(e.getLogo());
		etoupdate.setNom(e.getNom());
		
	}
}
