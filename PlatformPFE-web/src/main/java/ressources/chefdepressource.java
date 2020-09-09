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

import tn.esprit.Services.servicechefdep;
import tn.pfe.entity.Chefdepartement;



@Path("chefdepartement")
public class chefdepressource {
	@EJB
	servicechefdep scd;
	
	
	@POST
	@Path("{ida}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addop(Chefdepartement o ,@PathParam("ida")int ida) {
		scd.addchefdep(o);
		scd.affecter_A_toCD(o.getId(), ida);
	return "c bn";	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Chefdepartement> affop(){
		
		return scd.affochefdeps();}
	
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deletechefdep(@PathParam(value = "id")int id) {
		scd.deletechefdepbyid(id);;
		return "chef department supprimer";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatechefdep(Chefdepartement o) {
		scd.updatechefdep(o);
		
		
		return "chefdepartement modifer" ;
	}

}
