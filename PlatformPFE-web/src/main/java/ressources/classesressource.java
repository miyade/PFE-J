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

import tn.esprit.Services.serviceclasses;
import tn.pfe.entity.Classes;



@Path("classes")
public class classesressource {
	@EJB
	serviceclasses sc;
	

	@POST
	@Path("{ida}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addclasse(Classes c ,@PathParam("ida")int ida) {
		sc.addeclasse(c);
		sc.affecter_A_toC(c.getId(), ida);
	return "c bn";	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Classes> affclasses(){
		
		return sc.affclasses();}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteecole(@PathParam(value = "id")int id) {
		sc.deleteclassebyid(id);;
		return "classe supprimer";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateclasse(Classes c) {
		sc.updateclasse(c);
		
		
		return "option modifer" ;
	}

}
