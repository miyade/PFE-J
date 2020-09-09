package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Reclamation;

@Remote
public interface ReclamationsServicesRemote {
	public void Ajouterreclamation(Reclamation r, int idstu);
	public void deletereclamation(int recid);
	public List<Reclamation> listerreclamation();
	public void traiterreclamation(int recid);
}
