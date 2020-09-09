package tn.pfe.service.categorie;


import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.GradProjectFile;

@Remote
public interface ProjectCategorieRemote {

	public List<GradProjectFile> getNbStageParCategorie(int id_category);
	public List<Object> StageParCategory(int site_id);

}
