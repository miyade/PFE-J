package ressources;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.mail.handlers.text_plain;

import tn.esprit.Services.TeacherService;
import tn.pfe.entity.Student;
import tn.pfe.entity.Teacher;



@Path("teachers")
public class RessourceTeacher {
	
	@EJB
TeacherService ts ;
	public RessourceTeacher()
	{
		
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Teacher> GetTechers() 
	{
		
		return ts.getTeachers() ;
	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addTeacher(Teacher t) {
		ts.addTeacher(t);
		
		return " c bn";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void updateTeacher(Teacher t) {
	ts.updateTeacherById(t);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteTeacher(@PathParam(value = "id")int id) {
		ts.deleteTeacherById(id);
		return "deleted !!";
	}

	
	
	
}
  