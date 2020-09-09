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

import tn.esprit.Services.serviceoption;
import tn.pfe.entity.Options;



@Path("option")
public class Optionressource {
	@EJB
	serviceoption so;
	
	@POST
	@Path("{ida}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addop(Options o ,@PathParam("ida")int ida) {
		so.addoption(o);
		so.affecter_A_toO(o.getId(), ida);
	return "c bn";	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Options> affop(){
		
		return so.affoption();}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteecole(@PathParam(value = "id")int id) {
		so.deleteoptionbyid(id);
		return "option supprimer";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateecole(Options o) {
		so.updateoption(o);
		
		
		return "option modifer" ;
	}

}
