package tn.esprit.Services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Remote;

import tn.pfe.entity.*;

@Remote
public interface TeacherServiceRemote {
	
	int addTeacher(Teacher t);
	List<Teacher>  getTeachers();
	void deleteTeacherById(int id);
	boolean updateTeacherById(Teacher t);
	Teacher getTeacherById(int id);
	Set<Student> listerSdtEncadre(int idT);
	Set<GradProjectFile> listerFileWorkingOn(int idt);
	Set<GradProjectFile> listerFileEncadrer(int idt);
	Set<GradProjectFile> listerFileRapporter(int idt);
	Set<Student> listerSdtpresedent(int idT);
	Set<Student> listerSdtarapporter(int idT);
	Set<GradProjectFile> listerFilePresedent(int idt);
	void prevalide(int idt,int idfile,String role);
	void noterpfeFile(int idt,int idfile,double note,String role);
	void donnerUnMotif(int idt,int idfile,String motif,String role);
	//el king
		public void encadrerEtudiant(int idStu);
		public void rappporterEtudiant(int idStu);
		public void updateRapporteur(int idStu,int idT);
		public List<GradProjectFile> AfficherListeSansRapporteurs();
		public Map<Teacher,List<GradProjectFile>> teacherbynbencadrement();
		public Student getStudent(int idst);
		public List<GradProjectFile> fichesansrapporteur();
		public List<GradProjectFile> fichesansencadrant();
		public void updateEncadrant(int idStu,int idT);
		public void validercat(int catid);
		public List<Student> csvList () throws IOException;
		public void affecterprevalidateur(int idt , int idst);
		public User authetificate(String login, String password);
	//stat
	List<GradProjectFile> getFilesencadredByYear(int idt, int year);
	List<GradProjectFile> getFilesencadredBetween2Years(int idt, int year1, int year2);
	List<GradProjectFile> getFilesrapportedByYear(int idt, int year);
	List<GradProjectFile> getFilesrapportedBetween2Years(int idt, int year1, int year2);
	List<GradProjectFile> getFilespresendentdByYear(int idt, int year);
	List<GradProjectFile> getFilespresedentBetween2Years(int idt, int year1, int year2);
	
	Map<projectCategory, Integer> getmostencadredCategorie(int idt);
	Map<projectCategory, Integer> getmostRapportedCategorie(int idt);
	Map<projectCategory, Integer> getmostpresedentCategorie(int idt);
	
	
	Map<GradProjectFile, Double> getFileMostNote(int idt);
	
	Map<projectCategory, Double> getcategorieMostNote(int idt);
	Map<projectCategory, Double> getcategorieMostNoteenTTQRapporteur(int idt);
	
	//auto complete
		Map<projectCategory, Double> autoCompletePreferdCategorie(int idt);
	
	//extra
		void addEmploye(Student s);
		void addpfe(GradProjectFile e);
		Chefdepartement getChefdepartement(int id);
		public List<projectCategory> getallcat();
		public void unvalidercat(int catid);
}
