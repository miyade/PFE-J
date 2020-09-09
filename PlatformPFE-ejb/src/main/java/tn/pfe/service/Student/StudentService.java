package tn.pfe.service.Student;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.pfe.entity.CoachCompany;
import tn.pfe.entity.SendEmail;
import tn.pfe.entity.Student;
import tn.pfe.entity.User;

/**
 * Session Bean implementation class StudentService
 */
@Stateless
@LocalBean
public class StudentService implements StudentServiceRemote, StudentServiceLocal {

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public StudentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Student> getAllStudent(int site_id){
		// TODO Auto-generated method stub
		List<Student> Students = em.createQuery("Select s from Student s where s.site.Id =:site_id ", Student.class).setParameter("site_id", site_id).getResultList();
		return Students;
	}
	
	@Override
	public List<Student> getAllStudentRecrutedoverContry(int site_id) {
		// TODO Auto-generated method stub
		List<Student> Students = em.createQuery("Select s from Student s , Company c where c.country Not like 'tunisia' AND c.id = s.company.id and s.site.Id =:site_id", Student.class).setParameter("site_id", site_id).getResultList();
		return Students;
	} 

	@Override
	public List<Student> getAllStudentRecrutedByContryByYear(String contry, int year, int site_id) {
		// TODO Auto-generated method stub
		List<Student> Students ;
		Query query =  em.createQuery("Select s from Student s , Company c  , InternshipAgreement ia where c.country like :contry and extract(year from ia.beginningDate) like :year and c.id = s.company.id and c.internagreement.id = ia.id and s.site.Id =:site_id").setParameter("contry", contry).setParameter("year", year).setParameter("site_id", site_id);
		Students = query.getResultList();
		return Students;
	}

	@Override
	public void ajouterEncadrent(String EmailRecip) {
		// TODO Auto-generated method stub
		String password ="1234";
		CoachCompany encadreur = new CoachCompany(EmailRecip, "1234" , true);
		em.persist(encadreur);
		String emailcontent ;
		emailcontent = "Bonjour Monsieur ,Bonjour Madame  <br>  <br>  Votre email pour connecter à notre plateforme de stage PFE est "+EmailRecip+" votre mot de passe est "+password;
		 
		try {
			SendEmail.generateAndSendEmail(EmailRecip, "Compte information", emailcontent, "keeptooui@gmail.com", "az191+AZ");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Student getStudnetById(int id) {
		// TODO Auto-generated method stub
		return em.find(Student.class, id);
	}
	
	

}
