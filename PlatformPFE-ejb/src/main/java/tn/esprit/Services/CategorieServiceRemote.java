package tn.esprit.Services;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import tn.pfe.entity.*;
import tn.pfe.service.categorie.ProjectCategorie;

@Remote
public interface CategorieServiceRemote {
	List<projectCategory> getCategories();
	Set<projectCategory> getMyPreferedCtegories(int idt);
	Set<projectCategory> getMyProposedCtegories(int idt);
	int addCategorie(projectCategory c, int idt);
	void deleteCategorieById(int idC);
	void updateCtegorie(projectCategory c);
	void affecterCategorieToTeacher(int idC, int idT);
	void affecterCategoriePrefereToTeacher(int idC, int idT);
	void deletepreferedCategori(int idt, int idc);
}
