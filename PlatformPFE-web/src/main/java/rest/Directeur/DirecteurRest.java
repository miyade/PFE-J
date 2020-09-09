package rest.Directeur;

import java.util.List;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.Services.DirecteurServiceLocal;
import tn.pfe.entity.Archive_GradProjectFile;
import tn.pfe.entity.SendEmail;
import tn.pfe.entity.Site;
import tn.pfe.entity.Student;

@Path("Direction")
public class DirecteurRest {
	@EJB(mappedName="PlatformPFE-ear/PlatformPFE-ejb/DirecteurService!tn.esprit.Services.DirecteurServiceServiceRemote") 
	DirecteurServiceLocal directeurServices;
	
	@Path("/activerEtudiant")
	@PUT
	@Produces("application/json")
	public Response enableStudent(@QueryParam(value="id") String id) {
	if(directeurServices.enableStudent(Integer.parseInt(id))==0)
		return Response.status(Response.Status.NOT_MODIFIED).entity("Pas de contenu").build();

	else {
		return Response.status(Response.Status.OK).build();
	}
	}
	
	@Path("/validerRapport")
	@PUT
	@Produces("application/json")
	public Response ValidateRapport(@QueryParam(value="id") String id) {
	if(directeurServices.validateRapport(Integer.parseInt(id))==0)
		return Response.status(Response.Status.NOT_MODIFIED).entity("Pas de contenu").build();

	else {
		return Response.ok(directeurServices.findGradFile(Integer.parseInt(id)),MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*").build();
	}
	}
	@Path("MaxAction")
	@PUT
	@Produces("application/json")
	public Response MaxAction(@QueryParam(value="id") String id) {
		if(directeurServices.maxAction(Integer.parseInt(id))==0)
			return Response.status(Response.Status.NOT_MODIFIED).entity("Pas de contenu").build();

		else {
			return Response.ok(directeurServices.findGradFile(Integer.parseInt(id)),MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	@Path("listeSansFiche")
	@GET
	@Produces("application/json")
	public Response getStudentsWithoutPFE(@QueryParam(value="anneeScolaire") String as){
		
		if (directeurServices.getStudentsWithoutPFE(as).size()==0)
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

		else {
			return Response.ok(directeurServices.getStudentsWithoutPFE(as), MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	@Path("listeSansFichePeriode")
	@GET
	@Produces("application/json")
	public Response getStudentsWithoutPFEPeriode(@QueryParam(value="deb") String deb,@QueryParam(value="fin") String fin){
		
		if (directeurServices.getStudentsWithoutPFEPeriode(deb,fin).size()==0)
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

		else {
			return Response.ok(directeurServices.getStudentsWithoutPFEPeriode(deb,fin), MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	@Path("accepterFiche")
	@PUT
	@Produces("application/json")
	public Response acceptSheet(@QueryParam(value = "id")String id) throws AddressException, MessagingException {
		if(directeurServices.acceptSheet(Integer.parseInt(id))==0) {
			return Response.status(Response.Status.NOT_MODIFIED).entity("Pas de contenu").build();
		}

		else {
			SendEmail mail=new SendEmail();
			mail.generateAndSendEmail(directeurServices.getChefDepartement().getEmail(),"Fiche acceptée", "Vous trouvez ci-joint une fiche acceptée "+
			directeurServices.findGradFile(Integer.parseInt(id)).toString(), "ismail.abdennadher@esprit.tn", "22827736");//ne9sa
			return Response.ok(directeurServices.findGradFile(Integer.parseInt(id)),MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();//ne9sa
		}
	}
	@Path("refuserFiche")
	@PUT
	@Produces("application/json")
	public Response refuseSheet(@QueryParam(value = "id")String id) throws AddressException, MessagingException {
		if(directeurServices.refuseSheet(Integer.parseInt(id))==0) {
			return Response.status(Response.Status.NOT_MODIFIED).entity("Pas de contenu").build();
		}

		else {
			SendEmail mail=new SendEmail();
			Student s=directeurServices.findGradFile(Integer.parseInt(id)).getStudent();
			mail.generateAndSendEmail(s.getEmail(),"Fiche refusée", "Mr "+s.getFirstName()+
					" je vous informe que votre fiche a été refusée \n Veuillez corriger tout erreur"
					, "ismail.abdennadher@esprit.tn", "22827736");//ne9sa
			return Response.ok(directeurServices.findGradFile(Integer.parseInt(id)),MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	@Path("annulerFiche")
	@PUT
	@Produces("application/json")
	public Response cancelSheet(@QueryParam(value = "id")String id,@QueryParam(value = "decision")String decision,
			@QueryParam(value = "motif")String motif) throws AddressException, MessagingException {
		if(directeurServices.cancelSheet(Integer.parseInt(id),decision)==0) {
			return Response.status(Response.Status.NOT_MODIFIED).entity("Pas de contenu").build();
		}

		else {
			SendEmail mail=new SendEmail();
			Student s=directeurServices.findGradFile(Integer.parseInt(id)).getStudent();
			if(motif!=null) {
			mail.generateAndSendEmail(s.getEmail(),"Demande d'annulation "+decision, "Mr "+s.getFirstName()+
					" je vous informe que votre demande d'annulation a été refusée \n Motif:"+motif+"."
					, "ismail.abdennadher@esprit.tn", "22827736");//ne9sa
			}
			else
			{
				directeurServices.addSheetToArchive(directeurServices.findGradFile(Integer.parseInt(id)), s);
				mail.generateAndSendEmail(s.getEmail(),"Demande d'annulation "+decision, "Mr "+s.getFirstName()+
						" je vous informe que votre demande d'annulation a été acceptée."
						, "ismail.abdennadher@esprit.tn", "22827736");//ne9sa
			}
			return Response.ok(directeurServices.findGradFile(Integer.parseInt(id)),MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@Path("Site")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Site getSiteDirecteurStage(@QueryParam(value="id")int id) {
		
		return directeurServices.getSiteDirecteurStage(id);
	}	
}
