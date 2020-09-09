package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Site;

;

@Remote
public interface servicesitesRemote {
	public String addsite(Site site);
	public void affecter_A_toS(int id_site, int id_admin);
	public List<Site> affsite();
	public void deletesitebyid(int ids);
	public void updatesite(Site s );
	public void affecter_DS_toS(int id_site,int id_ds);
	public Site getSiteById(int id);
	public Site getsiteByidDirecteur(int id);

}
