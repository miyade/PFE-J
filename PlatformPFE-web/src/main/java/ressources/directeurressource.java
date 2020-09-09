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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.servicedirecteurstage;
import tn.pfe.entity.Directeurdestages;
import tn.pfe.entity.Site;


@Path("directeurdestages")
public class directeurressource {
	
	@EJB
	servicedirecteurstage sds;
	
	
	@POST
	@Path("{ida}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addds(Directeurdestages ds ,@PathParam("ida")int ida) {
		sds.addedirecteur(ds);
		sds.affecter_A_toD(ds.getId(), ida);
	return "c bn";	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Directeurdestages> affds(){
		
		return sds.affedirecteur();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteds(@PathParam(value = "id")int id) {
		sds.deletedirecteurbyid(id);;
		return "directeur supprimer";}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatdse(Directeurdestages ds) {
		sds.updatdirecteur(ds);
		
		return "directeur modifer" ;
	}
	
		@Path("{id}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public Directeurdestages getdirecteurbyid(@PathParam(value="id")int id) {
				
				return sds.getdirecteurbyid(id);
			}
		

}
