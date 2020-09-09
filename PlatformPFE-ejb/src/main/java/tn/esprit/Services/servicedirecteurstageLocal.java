package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Directeurdestages;

@Local
public interface servicedirecteurstageLocal {
	public String addedirecteur(Directeurdestages ds);
	public void affecter_A_toD(int id_ds, int id_admin);
	public List<Directeurdestages> affedirecteur();
	public void deletedirecteurbyid(int idds);
	public void updatdirecteur(Directeurdestages ds );
	public Directeurdestages getdirecteurbyid(int id);
}
