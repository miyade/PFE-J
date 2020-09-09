package ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.AdminServices;
import tn.pfe.entity.Admin;



@Path("admin")
public class Adminressource {
	
	@EJB
	AdminServices sa ;

	@POST
	@Path("{idsa}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addadmin(Admin admin,@PathParam("idsa")int idsa) {
	
		sa.addadmin(admin);
		sa.affecter_SA_toA(admin.getId(), idsa);
		
		return "c bn" ;
	}
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Admin> Getadmins() 
	{
		
		return sa.affadmin() ;
	
	}
	@Path("mail")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String mail() {
		sa.sendMessage();
		return "mail okk ";
	}
	
	
	
	
	@POST
	@Path("payer/{idf}")
	public void payer(@PathParam("idf")int ida) {
		sa.payerLicence(ida);
	}
	
	@GET
	@Path("{ida}")
	@Produces(MediaType.APPLICATION_JSON)
	public Admin getadmin (@PathParam("ida")int ida) {
		return sa.getadminQuiAPaye(ida);
	}
	
	
	
}
