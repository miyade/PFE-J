package tn.esprit.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;
/**
 * Session Bean implementation class servicedep
 */
@Stateless
@LocalBean
public class servicedep implements servicedepRemote, servicedepLocal {
@PersistenceContext
EntityManager em ;
    /**
     * Default constructor. 
     */
    public servicedep() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public String addedep(Departement dep) {
		em.persist(dep);
		return "departement ajouter";
	}
	@Override
	public void affecter_A_todep(int id_dep, int id_admin) {
		Departement d = em.find(Departement.class, id_dep);
		Admin a= em.find(Admin.class, id_admin);
d.setAdmin(a);
a.getDepartements().add(d);
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Departement> affdep() {
		// TODO Auto-generated method stub
		return (List<Departement>) em.createQuery("select d from Departement d ",Departement.class).getResultList();
		
	}
	@Override
	public void deletedepbyid(int idd) {
		em.createQuery("DELETE from Departement e where e.id=:id" ).setParameter("id", idd).executeUpdate();
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatedep(Departement d) {
	Departement	deptoup= em.find(Departement.class, d.getId());
	deptoup.setCodedepartement(d.getCodedepartement());
	deptoup.setNomdepartement(d.getNomdepartement());
		// TODO Auto-generated method stub
		
	}
	@Override
	public void affecter_CDtodep(int id_dep, int id_chefdep) {
		Chefdepartement cd =em.find(Chefdepartement.class, id_chefdep);
		Departement dep =em.find(Departement.class, id_dep);
		cd.setDepartement(dep);
		dep.setChefdepartement(cd);
		// TODO Auto-generated method stub
		
	}

}
