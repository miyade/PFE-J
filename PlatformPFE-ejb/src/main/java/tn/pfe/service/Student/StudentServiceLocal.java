package tn.pfe.service.Student;


import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import tn.pfe.entity.Student;

@Local
public interface StudentServiceLocal {
	public List<Student> getAllStudent(int site_id);
	public List<Student> getAllStudentRecrutedoverContry(int site_id);
	public List<Student> getAllStudentRecrutedByContryByYear(String contry , int year , int site_id);
	public void ajouterEncadrent(String EmailRecip);
	public Student getStudnetById(int id);

}
