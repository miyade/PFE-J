package ReclamationRes;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.ReclamationsServices;
import tn.pfe.entity.Notification;
import tn.pfe.entity.Reclamation;
@Path("/reclamation")
public class ReclamationRes {

	@EJB
	ReclamationsServices reclamationsServices;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ajouterreclamation")
	public void ajouterreclamation(Reclamation r , @QueryParam("idst") int idst) {
		reclamationsServices.Ajouterreclamation(r, idst);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/traiterreclamation")
	public void traiterReclamation(@QueryParam("idst") int idst) {
		reclamationsServices.traiterreclamation(idst);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllReclamation")
	public List<Reclamation> getAllreclamations(){
		 return reclamationsServices.listerreclamation();	
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deletereclamation")
	public void deletereclamation(@QueryParam("idrec") int idrec) {
		reclamationsServices.deletereclamation(idrec);
	}
	

}
