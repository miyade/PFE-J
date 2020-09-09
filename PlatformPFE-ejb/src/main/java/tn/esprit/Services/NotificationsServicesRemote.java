package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Notification;
import tn.pfe.entity.Student;
import tn.pfe.entity.Teacher;

@Remote
public interface NotificationsServicesRemote {
	public void addnotifteacher(Notification notification , int idt);
	public void addnotifstudent(Notification notification , int idst);
	public void markasread(int notifid);
	public List<Notification> getnotifbyUsertid(int teacherid);
	public List<Notification> getnotifbyUsersid(int studentid);
}
