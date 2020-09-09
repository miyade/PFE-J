package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;


/**
 * Session Bean implementation class servicechefdep
 */
@Stateless
@LocalBean
public class servicechefdep implements servicechefdepRemote, servicechefdepLocal {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public servicechefdep() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addchefdep(Chefdepartement cd) {
		// TODO Auto-generated method stub
		em.persist(cd);
		return "cbn";
		
	}

	@Override
	public void affecter_A_toCD(int id_cd, int id_admin) {
		// TODO Auto-generated method stub
		Chefdepartement cd=em.find(Chefdepartement.class, id_cd);
		Admin a= em.find(Admin.class, id_admin);
		cd.setAdminchefdep(a);
		a.getChefdepartements().add(cd);
	}

	@Override
	public List<Chefdepartement> affochefdeps() {
		// TODO Auto-generated method stub
		return (List<Chefdepartement>) em.createQuery("select o from Chefdepartement o ",Chefdepartement.class).getResultList();
	}

	@Override
	public void deletechefdepbyid(int ido) {
		em.createQuery("DELETE from Chefdepartement o where o.id=:id" ).setParameter("id", ido).executeUpdate();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatechefdep(Chefdepartement ds) {
	Chefdepartement	cheftup=em.find(Chefdepartement.class,ds.getId() );
	cheftup.setEmail(ds.getEmail());;
	
cheftup.setFirstName(ds.getFirstName());
cheftup.setLastName(ds.getLastName());
cheftup.setPassword(ds.getPassword());
		// TODO Auto-generated method stub
		
	}

}
