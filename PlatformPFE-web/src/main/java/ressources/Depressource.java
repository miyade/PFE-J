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

import tn.esprit.Services.servicedep;
import tn.pfe.entity.Departement;



@Path("departement")
public class Depressource {
	@EJB
	servicedep sd;
	
	
	@POST
	@Path("{ida}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addecole(Departement dep,@PathParam("ida")int ida) {
		sd.addedep(dep);
		sd.affecter_A_todep(dep.getId(), ida);
	return "c bn";	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Departement> affdep(){
		
	
		return sd.affdep();
	}
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deletedep(@PathParam(value = "id")int id) {
		sd.deletedepbyid(id);
		return "dep supprimer";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateecole(Departement d) {
		sd.updatedep(d);;
		
		
		return "dep modifer" ;
	}

@POST
@Path("affecterchefdepartement/{iddep}/{idchef}")
@Produces(MediaType.TEXT_PLAIN)
public String affecterdstos(@PathParam(value = "iddep")int iddep,@PathParam(value = "idchef")int idchef) {
	sd.affecter_CDtodep(iddep, idchef);
	
	return " chefdepartement affecté ";
}

}
