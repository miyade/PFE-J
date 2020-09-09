package tn.pfe.service.Company;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.Company;
import tn.pfe.entity.Student;

/**
 * Session Bean implementation class CompanyService
 */
@Stateless
@LocalBean
public class CompanyService implements CompanyServiceRemote, CompanyServiceLocal {

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CompanyService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Object> getRecrutedCompayByOrder(int site_id) {
		// TODO Auto-generated method stub
		List<Object> Companys = em.createQuery("select c , COUNT(s.company.id) AS nb from Student s , Company c WHERE s.company.id = c.id and s.site.id =:site_id  GROUP BY c.id ORDER by nb DESC").setParameter("site_id", site_id).getResultList();
		return Companys;
	}

}
