package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Admin;

@Local
public interface AdminServicesLocal {
   void payerLicence(int ida);
   Admin getadminQuiAPaye(int ida);
   public String addadmin(Admin admin);
	public List<Admin>affadmin();
	public void affecter_SA_toA(int id_admin ,int id_superadmin);
	public  void sendMessage()throws Exception ;
	public Admin getadminby(int id);
}
