package tn.pfe.service.categorie;


import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.GradProjectFile;

@Local
public interface ProjectCategorieLocal {

	public List<GradProjectFile> getNbStageParCategorie(int id_category);
	public List<Object> StageParCategory(int site_id);

}
