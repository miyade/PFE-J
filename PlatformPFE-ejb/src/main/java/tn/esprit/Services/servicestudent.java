package tn.esprit.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import tn.pfe.entity.*;


/**
 * Session Bean implementation class servicestudent
 */
@Stateless
@LocalBean
public class servicestudent implements servicestudentRemote, servicestudentLocal {
	
	@PersistenceContext
	EntityManager em ;
	@EJB
	servicesoutenance ss;

    /**
     * Default constructor. 
     */
    public servicestudent() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String addstudent(Student s) {
		em.persist(s);
		// TODO Auto-generated method stub
		return "etudiant ajouter avec succes";
	}

	@Override
	public void affecter_A_toS(int id_stduent, int id_admin) {
		Student s= em.find(Student.class,id_stduent );
		Admin a =em.find(Admin.class, id_admin);
		s.setAdmin(a);
		a.getStudents().add(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> affStudent() {
		// TODO Auto-generated method stub
		return (List<Student>) em.createQuery("select s from Student s ",Student.class).getResultList();
	}

	@Override
	public void deleteStudentbyid(int ids) {
		em.createQuery("DELETE from Student s where s.id=:id").setParameter("id", ids).executeUpdate();
		
	}

	@Override
	public void updateSrudent(Student s) {
		Student stoupdate = em.find(Student.class, s.getId());
		stoupdate.setEmail(s.getEmail());
		
		stoupdate.setGrade(s.getGrade());
		stoupdate.setFirstName(s.getFirstName());
		stoupdate.setLastName(s.getLastName());
		stoupdate.setPassword(s.getPassword());
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public List<Teacher> getencadrant() {
		List<Teacher> encadrants =new ArrayList<Teacher>() ;
		List<Student> students =em.createQuery("select s from Student s ",Student.class).getResultList();
		for(Student s :students) {
			if (s.getPfeFile().getNote()==0) {
				encadrants.add(s.getEncadrants());
				
			}
			
		}
		return encadrants;
	}

	@Override
	//@Schedule(second="0",minute="*",hour="*")
	public void notifencadrant() {
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.prot", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("pidevpfetwin@gmail.com", "123aziz456");
            }
        }
        );
        try { 
        	for(Teacher t :getencadrant()) {
        		Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pidevpfetwin@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(t.getEmail()));
                message.setSubject("note encadrant !");
                message.setText("mc/mme "+t.getFirstName()+"il ya des fiches pfe qui manque votre note ");
                Transport.send(message);
        		
        	}
        		
        	
        		
        
          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
	  
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GradProjectFile> getpfe() {
		// TODO Auto-generated method stub
		return (List<GradProjectFile>) em.createQuery("select s from GradProjectFile s ",GradProjectFile.class).getResultList();
	}

	@Override
	public List<Teacher> getrapporteur() {
		
		List<Teacher> rapporteurs =new ArrayList<Teacher>() ;
		List<Student> students =em.createQuery("select s from Student s ",Student.class).getResultList();
		for(Student s :students) {
			if (s.getPfeFile().getNote_rapporteur()==0) {
			rapporteurs.add(s.getRapporteurs());
				
			}
			
		}
		return rapporteurs;
	}

	@Override
//@Schedule(second="0",minute="*",hour="*")
	public void notifrapporteur() {
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.prot", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("pidevpfetwin@gmail.com", "123aziz456");
            }
        }
        );
        try { 
        	for(Teacher t :getrapporteur()) {
        		Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pidevpfetwin@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(t.getEmail()));
                message.setSubject("note rapporteur!");
                message.setText("mc/mme "+t.getFirstName()+"il ya des fiches pfe qui manque votre note ");
                Transport.send(message);
        		
        	}
        		
        	
        		
        
          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
	  
		
	}

	@Override
	public List <GradProjectFile> pfe_v_E_R() {
		List <GradProjectFile> pfe= new ArrayList<GradProjectFile>();
		int i = 0;
		boolean a = true;
		List<Teacher> t =new ArrayList<Teacher>() ;
		List<Student> students =em.createQuery("select s from Student s ",Student.class).getResultList();
		for(Student s :students){
			if((s.getEncadrants()==null)||(s.getRapporteurs()==null)||(s.getPfeFile().isPreValidated()==false)) {
			pfe.add(s.getPfeFile());	
			}}
		
		return pfe;
	}

	@Override
   // @Schedule(second="0",minute="*",hour="*")
	public void notifchefdepartement() {
		String s="";
		List<Chefdepartement> cdeps =em.createQuery("select o from Chefdepartement o ",Chefdepartement.class).getResultList();
		for(GradProjectFile p: pfe_v_E_R()) {
			s=s+p.getId()+" , ";
			
		}
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.prot", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("pidevpfetwin@gmail.com", "123aziz456");
            }
        }
        );
        try { 
        	for(Chefdepartement t :cdeps) {
        		Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pidevpfetwin@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(t.getEmail()));
                message.setSubject("reclamation chef departement!");
                message.setText("mc/mme  "+t.getFirstName()+" les fiche pfe d indices : "+s+" manque un rapporteur o un encadrant ou il ne sont pas valider");
                Transport.send(message);
        		
        	}
        		
        	
        		
        
          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
	  
		
	}

	@Override
	public List<GradProjectFile> PFEvalide(List<GradProjectFile> pfes) {
		List<GradProjectFile> pfesvalides = new ArrayList<GradProjectFile>();
		for(GradProjectFile p:pfes) {
			if((p.isPreValidated()==true)&&(p.getStudent().getEncadrants()!=null)&&(p.getStudent().getRapporteurs()!=null)) {
				pfesvalides.add(p);
				
			}
			
		}
		return pfesvalides;
	}

	@Override
	public boolean affecterPtoS(int id_stduent, int idpresident,Date ds) {
		boolean a =false ;
		Student s =em.find(Student.class, id_stduent);
		Teacher prsident= em.find(Teacher.class, idpresident);
		if( (ss.verifteacherocuperbydate(ds, idpresident)==false)&&(s.getPfeFile()!=null)&&(s.getEncadrants()!=null)&&(s.getRapporteurs()!=null)&&(s.getPresident()==null)) {
			
			s.setPresident(prsident);
			prsident.getEtudiantsapresident().add(s);
		}else {
			a=true ;
		}
		
return a;
		
	}

	
	@Override
	public List<Student> getStudentsansrapporteuretencadrant() {
		return (List<Student>) em.createQuery(" select c from Student c where c.rapporteurs=null and c.encadrants=null ",Student.class).getResultList();		
	}
	@Override
	public List<Student> getStudentssansencadrant() {
		return (List<Student>) em.createQuery(" select c from Student c where c.encadrants=null",Student.class).getResultList();		
	}
	@Override
	public List<Student> getStudentssansrapporteur() {
		return (List<Student>) em.createQuery(" select c from Student c where c.rapporteurs=null",Student.class).getResultList();		
	}
	@Override
	public List<Student> getStudentavecencadrant() {
		return (List<Student>) em.createQuery(" select c from Student c where c.encadrants!=null",Student.class).getResultList();
	}
	@Override
	public List<Student> getStudentavecrapp() {
		return (List<Student>) em.createQuery(" select c from Student c where c.rapporteurs!=null",Student.class).getResultList();
	}
	@Override
	public List<Student> getStudentbyid(int ids) {
		return (List<Student>) em.createQuery(" select c from Student c where c.id=:id",Student.class).setParameter("id", ids).getResultList();
	}

}


