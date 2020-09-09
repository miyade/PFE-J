package tn.esprit.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.*;

/**
 * Session Bean implementation class servicesoutenance
 */
@Stateless
@LocalBean
public class servicesoutenance implements servicesoutenanceRemote, servicesoutenanceLocal {
	
	@PersistenceContext
	EntityManager em ;
	@EJB
	servicestudent ss;
	

    /**
     * Default constructor. 
     */
    public servicesoutenance() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addsoutenance(Soutenance s) {
		em.persist(s);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void affecterpfetos(int idpfe, int ids) {
		GradProjectFile pfe = em.find(GradProjectFile.class, idpfe);
		Soutenance s= em.find(Soutenance.class, ids);
		pfe.setSoutenance(s);
		s.setPfe(pfe);
		
	}

	@Override
	public void affecterclassetos(int idc, int ids) {
		Classes es = em.find(Classes.class, idc);
		Soutenance s= em.find(Soutenance.class, ids);
	//	es.setSoutenance(s);
		s.setClasse(es);
		
	}

	@Override
	public List<Soutenance> algo(String datesoutenance, List<GradProjectFile> pfes, List<Classes> classes) throws ParseException{
		List<GradProjectFile>pfevalide= ss.PFEvalide(pfes);
		int j = 0;
		int k = pfevalide.size()/classes.size();
		int reste =pfevalide.size()%classes.size();
		
		int indicestemps =reste ;
		
		
		String tableaudesheures[]= {"08:00:00","09:00:00","10:00:00","11:00:00","14:00:00","15:00:00","16:00:00"};
		 SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		 System.out.println(tableaudesheures[0]+datesoutenance);
		List<Soutenance> soutenance_avecclasse = new ArrayList<Soutenance>(); 
		
		for (int l=0;l<pfevalide.size();l++) {
			Soutenance s = new Soutenance();
			s.setNomSoutenance("Soutenance "+(l));
			s.setPfe(pfes.get(l));
			soutenance_avecclasse.add(s);}
		
		if(k>tableaudesheures.length) {
			for(Classes c : classes) {
				
				for(int i=0;i< tableaudesheures.length;i++) {
					soutenance_avecclasse.get(j).setClasse(c);
					soutenance_avecclasse.get(j).setDatesoutenance(sd.parse(datesoutenance+tableaudesheures[i]));
						j++;
						
				}
				}	
			System.out.println("IL Y A "+(k-tableaudesheures.length)+" SOUTENANCES EN ATTENTE DES AFFECTATION DES CLASSES A CAUSE DU NBR DE CLASSE DISPO INSSUFISANT");
		}
		else {
			for(Classes c : classes) {
				
				for(int i=0;i< k;i++) {
					soutenance_avecclasse.get(j).setClasse(c);
					soutenance_avecclasse.get(j).setDatesoutenance(sd.parse(datesoutenance+tableaudesheures[i]));
						j++;
					}
				
			
					
					
				}
				
				
				if (reste!=0) {
					for (int r=0;r<reste;r++) {
						soutenance_avecclasse.get(j).setClasse(classes.get(r));
						soutenance_avecclasse.get(j).setDatesoutenance(sd.parse(datesoutenance+tableaudesheures[k]));
						
						j++;
						
						System.out.println(j);
					}
					
				}
			
		}
		
			
		
		return soutenance_avecclasse;
	}

	@Override
	public String add(List<Soutenance> ss) {
for(Soutenance s :ss) {
	em.persist(s);
}
		return null;
	}

	

	@Override
	public List<Soutenance> getSsoutenancebaydate(Date datesoutenance) {
		
		Soutenance s= new Soutenance();
	
		return (List<Soutenance>) em.createQuery("select s from Soutenance s where s.datesoutenance=:datesoutenance ",Soutenance.class).setParameter("datesoutenance",datesoutenance ).getResultList();
	
		
	}
	@Override
	public List<Integer> teacherocupper(Date ds) {
		
		List<Integer>  idteacher = new ArrayList<Integer>();
		for(Soutenance s : getSsoutenancebaydate(ds)) {
		idteacher.add(s.getPfe().getStudent().getEncadrants().getId());
		
			idteacher.add(s.getPfe().getStudent().getRapporteurs().getId());
			if(s.getPfe().getStudent().getPresident()!=null) {
				idteacher.add(s.getPfe().getStudent().getPresident().getId());	
			}
			
		}
	
		
		return idteacher;
		
	}

	@Override
	public boolean verifteacherocuperbydate(Date ds,int idt) {
		// TODO Auto-generated method stub
		return teacherocupper(ds).contains(idt);
	}
	
		

	

	

}
