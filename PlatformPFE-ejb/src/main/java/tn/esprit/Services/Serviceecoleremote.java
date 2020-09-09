package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Ecole;



@Remote
public interface Serviceecoleremote {
	public String addecole(Ecole ecole);
	public void affecter_A_toE(int id_ecole, int id_admin);
	public List<Ecole> affecole();
	public void deleteecolebyid(int ide);
	public void updateecole(Ecole e );

}
