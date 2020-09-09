package tn.esprit.Services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.OldPfe;

@Local
public interface GradProjectFileServiceLocal {
	public void addPfe(GradProjectFile pfe);
	public List<GradProjectFile> GetPfe();
	public void deletepfe(int id);
	public void updatepfe(GradProjectFile pfe,int id);
	public List<GradProjectFile>GetPfeValidated();
	public GradProjectFile searchSheet(int id);
	public List<GradProjectFile> getSheetsByYear(String year);
	public List<GradProjectFile> getSheetsByPays(String pays);
	public List<GradProjectFile> getSheetsOfYear();
	public List<GradProjectFile> getWaitingDefense();
	public List<GradProjectFile> getSheetsByEtat(String etat);
	public List<OldPfe> getoldpfe();
}