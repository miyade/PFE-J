package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Classes;

@Local
public interface serviceclassesLocal {
	public String addeclasse(Classes c);
	public void affecter_A_toC(int id_c, int id_admin);
	public List<Classes> affclasses();
	public void deleteclassebyid(int idc);
	public void updateclasse(Classes c);

}
