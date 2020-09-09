package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Classes;

@Remote
public interface serviceclassesRemote {
	public String addeclasse(Classes c);
	public void affecter_A_toC(int id_c, int id_admin);
	public List<Classes> affclasses();
	public void deleteclassebyid(int idc);
	public void updateclasse(Classes c);

}
