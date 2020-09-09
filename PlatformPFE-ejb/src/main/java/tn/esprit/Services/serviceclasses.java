package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.Admin;
import tn.pfe.entity.Classes;

/**
 * Session Bean implementation class serviceclasses
 */
@Stateless
@LocalBean
public class serviceclasses implements serviceclassesRemote, serviceclassesLocal {

  @PersistenceContext
  EntityManager em ;
    public serviceclasses() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addeclasse(Classes c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return " cbn";
	}

	@Override
	public void affecter_A_toC(int id_c, int id_admin) {
		Classes c=em.find(Classes.class, id_c);
		Admin a=em.find(Admin.class,id_admin);
		c.setAdmin(a);
		a.getClasses().add(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Classes> affclasses() {
		// TODO Auto-generated method stub
		return (List<Classes>) em.createQuery("select o from Classes o ",Classes.class).getResultList();
	}

	@Override
	public void deleteclassebyid(int idc) {
		em.createQuery("DELETE from Classes o where o.id=:id" ).setParameter("id", idc).executeUpdate();
		
	}

	@Override
	public void updateclasse(Classes c) {
		Classes ctup=em.find(Classes.class, c.getId());
		ctup.setNomclasse(c.getNomclasse());
		ctup.setNbretudiant(c.getNbretudiant());
		// TODO Auto-generated method stub
		
	}

}
