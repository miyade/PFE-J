package tn.esprit.Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.Notification;
import tn.pfe.entity.Student;
import tn.pfe.entity.Teacher;

/**
 * Session Bean implementation class NotificationsServices
 */
@Stateless
@LocalBean
public class NotificationsServices implements NotificationsServicesRemote, NotificationsServicesLocal {

    /**
     * Default constructor. 
     */
    public NotificationsServices() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
    @Override
    public void addnotifstudent(Notification notification, int idst) {
    	Student student = em.find(Student.class, idst);
    	notification.setStudent(student);
    	em.persist(notification);
    	student.getNotifications().add(notification);
    }
    @Override
    public void addnotifteacher(Notification notification, int idt) {    	
    	Teacher teacher = em.find(Teacher.class, idt);
    	em.persist(notification);
    	notification.setTeacher(teacher);
    	teacher.getNotifications().add(notification);
    }
    @Override
    public void markasread(int notifid) {
    	System.out.println(notifid +" /****************************************");
    	Notification notification = em.find(Notification.class, notifid);
    	notification.setVu(true);    	
    }
    @Override
    public List<Notification> getnotifbyUsersid(int studentid) {
    	List<Notification> notifications = new ArrayList<>();
    	List<Notification> notiflist = em.createQuery("select c from Notification c",Notification.class).getResultList();
    	Student student = em.find(Student.class, studentid);
    	for(Notification notification : notiflist) {
    		if(notification.getStudent()!=null)
    		if(notification.getStudent().equals(student)) {
    			notifications.add(notification);
    		}
    	}    
    	return notifications;
    }
    @Override
    public List<Notification> getnotifbyUsertid(int teacherid) {
    	List<Notification> notifications = new ArrayList<>();
    	List<Notification> notiflist = em.createQuery("select c from Notification c",Notification.class).getResultList();
    	Teacher student = em.find(Teacher.class, teacherid);    	
    	for(Notification notification : notiflist) {
    		if(notification.getTeacher()!=null) {
    		if(notification.getTeacher().equals(student)) {
    			notifications.add(notification);
    		}
    	}
    	}
    	return notifications;
    }
}
