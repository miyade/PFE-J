package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Payload;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;


import tn.pfe.entity.*;


/**
 * Session Bean implementation class AdminServices
 */
@Stateless
@LocalBean
public class AdminServices implements AdminServicesRemote, AdminServicesLocal {

	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
    
	
    public AdminServices() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void payerLicence(int ida) {
		
		Admin a = em.find(Admin.class, ida);
			Payment p = new Payment();
			Date d = new Date();
			d.setYear(new Date().getYear()+1);
			p.setExpirationDate(d);
			p.setAdmin(a);
			em.persist(p);
	}


	@Override
	public Admin getadminQuiAPaye(int ida) {
		if (em.find(Admin.class,ida) != null) {
		Admin a  = em.find(Admin.class,ida);
		for(Payment p : a.getPayments()) {
			if(p.getExpirationDate().compareTo(new Date())>0){
				return a;
			}
		}
		}
		return null;
	}
	public String addadmin(Admin admin) {
		em.persist(admin);
		
		return "success";
	}


	@Override
	public List<Admin> affadmin() {
		
		
		
		return (List<Admin>) em.createQuery("select a  from Admin a",Admin.class).getResultList();
	}

	@Override
	public void affecter_SA_toA(int id_admin, int id_superadmin) {
		
		Admin admin =em.find(Admin.class, id_admin);
		SuperAdmin sadmin=em.find(SuperAdmin.class,id_superadmin);
		admin.setSuperadmin(sadmin);
		sadmin.getAdmins().add(admin);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage()  {
		
		

		
	}
	
	@Override
	public Admin getadminby(int id) {
		return em.find(Admin.class, id);
	}

}
