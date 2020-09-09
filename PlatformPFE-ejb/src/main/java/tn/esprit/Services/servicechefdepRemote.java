package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Chefdepartement;


@Remote
public interface servicechefdepRemote {
	public String addchefdep(Chefdepartement cd);
	public void affecter_A_toCD(int id_cd, int id_admin);
	public List<Chefdepartement> affochefdeps();
	public void deletechefdepbyid(int ido);
	public void updatechefdep(Chefdepartement ds );

}
