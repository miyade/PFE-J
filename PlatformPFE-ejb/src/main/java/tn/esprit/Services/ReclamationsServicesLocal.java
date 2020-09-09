package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Reclamation;

@Local
public interface ReclamationsServicesLocal {
	public void Ajouterreclamation(Reclamation r, int idstu);
	public void deletereclamation(int recid);
	public List<Reclamation> listerreclamation();
	public void traiterreclamation(int recid);
}
