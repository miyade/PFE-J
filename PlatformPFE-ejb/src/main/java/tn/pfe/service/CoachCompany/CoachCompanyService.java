package tn.pfe.service.CoachCompany;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.CoachCompany;

/**
 * Session Bean implementation class CoachCompanyService
 */
@Stateless
@LocalBean
public class CoachCompanyService implements CoachCompanyServiceRemote, CoachCompanyServiceLocal {

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CoachCompanyService() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void modifier(CoachCompany user) {
		// TODO Auto-generated method stub
		em.merge(user);
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		em.remove(getCoachCompanyById(id));
	}

	@Override
	public CoachCompany getCoachCompanyById(int id) {
		// TODO Auto-generated method stub
		return em.find(CoachCompany.class, id);
	}

}
