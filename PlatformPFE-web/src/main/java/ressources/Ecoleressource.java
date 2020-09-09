package ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.Serviceecole;
import tn.pfe.entity.Ecole;

@Path("ecole")
public class Ecoleressource {
	
	@EJB
	Serviceecole se ;
	
	
	@POST
	@Path("{ida}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addecole(Ecole ecole ,@PathParam("ida")int ida) {
		se.addecole(ecole);
		se.affecter_A_toE(ecole.getId(), ida);
	return "c bn";	
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ecole> affecole(){
		
		return se.affecole();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteecole(@PathParam(value = "id")int id) {
		se.deleteecolebyid(id);
		return "ecole supprimer";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateecole(Ecole e) {
		se.updateecole(e);
		
		
		return "ecole modifer" ;
	}

}
