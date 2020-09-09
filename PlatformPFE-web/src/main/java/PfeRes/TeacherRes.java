package PfeRes;

import java.io.IOException;
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
import javax.ws.rs.core.Response;

import tn.esprit.Services.TeacherService;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Student;
import tn.pfe.entity.Teacher;
import tn.pfe.entity.projectCategory;

@Path("/teacherres")
public class TeacherRes {
	
	@EJB
	TeacherService teacherServices;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/affecterencadrant")
	public void affecterencadrant(@QueryParam("idStu") int idStu) {
		teacherServices.encadrerEtudiant(idStu);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/affecterrapporteur")
	public void affecterapporteur(@QueryParam("idStu") int idStu) {
		teacherServices.rappporterEtudiant(idStu);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pfesansrapporteur")
	public List<GradProjectFile> getpfesansrapporteur(){
		return teacherServices.AfficherListeSansRapporteurs();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/csvlist")
	public List<Student> getcsvlist() throws IOException{
		return teacherServices.csvList();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updaterapporteur")
	public void updatepfe(@QueryParam("idst") int idst,@QueryParam("idt") int idt) {
		teacherServices.updateRapporteur(idst, idt);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateencadrant")
	public void updateencadrant(@QueryParam("idst") int idst,@QueryParam("idt") int idt) {
		teacherServices.updateEncadrant(idst, idt);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/teachers")
	public Response getteachers(){
		return Response.ok(teacherServices.teacherbynbencadrement(),MediaType.APPLICATION_JSON).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pfewithoutrap")
	public List<GradProjectFile> getpfesansrapporteurs(){
		return teacherServices.fichesansrapporteur();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallcat")
	public List<projectCategory> getAllcat(){
		return teacherServices.getallcat();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pfewithoutencadrant")
	public List<GradProjectFile> getpfesansencadrants(){
		return teacherServices.fichesansencadrant();

	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/validecat")
	public void validecat(@QueryParam("idcat") int idcat) {
		teacherServices.validercat(idcat);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/unvalidecat")
	public void unvalidecat(@QueryParam("idcat") int idcat) {
		teacherServices.unvalidercat(idcat);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/affecterprevalidateur")
	public void prevalider(@QueryParam("idt") int idt,@QueryParam("idst") int idst) {
		teacherServices.affecterprevalidateur(idt, idst);
	}
	
}
