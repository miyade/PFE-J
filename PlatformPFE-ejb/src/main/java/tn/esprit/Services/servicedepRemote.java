package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Departement;


@Remote
public interface servicedepRemote {
	public String addedep( Departement dep);
public void affecter_A_todep(int id_dep, int id_admin);
public List<Departement> affdep();
public void deletedepbyid(int idd);
public void updatedep(Departement d );
public void affecter_CDtodep(int id_dep,int id_chefdep);

}
