package rest.CoachCompany;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tn.pfe.entity.CoachCompany;
import tn.pfe.service.CoachCompany.CoachCompanyServiceLocal;

@Path("coachCompany")
public class CoachCompanyRest {

	@EJB
	CoachCompanyServiceLocal coachCompanyService;
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CoachCompany modifier(CoachCompany user ) {
		if(coachCompanyService.getCoachCompanyById(user.getId()) != null) {
			coachCompanyService.modifier(user);
			return user;
		}else
			return null;
	}
	
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public String supprimer(@QueryParam(value="id")int id) {
		if(coachCompanyService.getCoachCompanyById(id)!= null) {
			coachCompanyService.supprimer(id);
			return "user deleted !";
		}else
			return "there is no user with this id";
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CoachCompany getCoachCompanyById(@QueryParam(value="id")int id) {
		return coachCompanyService.getCoachCompanyById(id);
	}
}
