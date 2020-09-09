package NotifRes;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.NotificationsServices;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Notification;
import tn.pfe.entity.Student;
import tn.pfe.entity.Teacher;

@Path("/notifres")
public class NotifResources {

	@EJB
	NotificationsServices notificationsServices;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ajoutnotifstudent")
	public void ajouternotifstudent(Notification notification , @QueryParam("idst") int idst) {
		notificationsServices.addnotifstudent(notification, idst);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ajoutnotifteacher")
	public void ajouternotifteacher(Notification notification , @QueryParam("idst") int idst) {		
		notificationsServices.addnotifteacher(notification, idst);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/notifbyteacher")
	public List<Notification> getnotifbyteacher(@QueryParam("tid") int tid){
		 return notificationsServices.getnotifbyUsertid(tid);	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/notifbystudent")
	public List<Notification> getnotifbystudent(@QueryParam("tid") int tid){
		 return notificationsServices.getnotifbyUsersid(tid);	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/markread")
	public void updatepfe(@QueryParam("id") int id) {
		notificationsServices.markasread(id);
	}
}
