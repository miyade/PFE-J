package rest.Company;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Student;
import tn.pfe.entity.projectCategory;
import tn.pfe.service.Company.CompanyServiceLocal;


@Path("company")
public class CompanyRest {

	@EJB
	CompanyServiceLocal companyService ;
	
	
	@GET
	@Path("/TopRecruted")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecrutedCompayByOrder(@QueryParam(value="site_id")int site_id) {
		
		List<Object> liste = new ArrayList<Object>();
		liste =  companyService.getRecrutedCompayByOrder(site_id);
		
		if(liste != null)
			return Response.ok()
				.entity(liste)
                .header("Access-Control-Allow-Origin", "*")
                .build();
		else
			return Response.ok()
	                .header("Access-Control-Allow-Origin", "*")
	                .build();
	}
}
