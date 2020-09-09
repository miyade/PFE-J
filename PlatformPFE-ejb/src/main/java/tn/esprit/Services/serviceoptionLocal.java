package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Options;

@Local
public interface serviceoptionLocal {
	public String addoption(Options o);
	public void affecter_A_toO(int id_o, int id_admin);
	public List<Options> affoption();
	public void deleteoptionbyid(int ido);
	public void updateoption(Options ds );

}
