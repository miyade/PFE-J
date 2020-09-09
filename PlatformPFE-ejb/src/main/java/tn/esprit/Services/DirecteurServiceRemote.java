package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Site;
import tn.pfe.entity.Student;
import tn.pfe.entity.User;

@Remote
public interface DirecteurServiceRemote {
	public int enableStudent(int id);
	public int validateRapport(int id);
	public GradProjectFile findGradFile(int id);
	public int maxAction(int id);
	public List<Student> getStudentsWithoutPFE(String as);
	public List<Student> getStudentsWithoutPFEPeriode(String deb,String fin);
	public int acceptSheet(int id);
	public int refuseSheet(int id);
	public int cancelSheet(int id,String decision);
	public void addSheetToArchive(GradProjectFile g,Student s);
	public User getChefDepartement();
	public Site getSiteDirecteurStage(int id);
}
