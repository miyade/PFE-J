package rest.TemplateIntershipAgreement;


import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.Services.servicesiteLocal;
import tn.pfe.entity.Site;
import tn.pfe.entity.TemplateIntershipAgreement;
import tn.pfe.service.TemplateIntershipAgreement.TemplateIntershipAgreementServiceLocal;


@Path("templateIntershipAgreement")
public class TemplateIntershipAgreementRest {
	
	@EJB
	TemplateIntershipAgreementServiceLocal templateIntershipAgreementService;
	
	@EJB
	servicesiteLocal serviceSite;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response ajouter(@QueryParam(value="template") String template , @QueryParam(value="site_id") int site_id) {
		Site s = serviceSite.getSiteById(site_id);
		if(s != null) {
		TemplateIntershipAgreement T = new TemplateIntershipAgreement(template);
		T.setSite(s);
		templateIntershipAgreementService.ajouter(T);
		return Response.ok()
				.entity(templateIntershipAgreementService.search(T.getId()))
                .header("Access-Control-Allow-Origin", "*")
                .build();
	}else
		return Response.status(Status.BAD_REQUEST)
                .header("Access-Control-Allow-Origin", "*")
                .build();
			
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response modifier(@QueryParam(value="id") int id , @QueryParam(value="template") String Template , @QueryParam(value="site_id") int site_id) {
		Site s = serviceSite.getSiteById(site_id);

		if(s != null) {
			TemplateIntershipAgreement T = new TemplateIntershipAgreement(id, Template , s );
			
			if(searchTemplateIntershipAgreement(T.getId()) != null) {
				templateIntershipAgreementService.modifier(T);;
				return Response.ok()
						.entity(templateIntershipAgreementService.search(T.getId()))
		                .header("Access-Control-Allow-Origin", "*")
		                .build();
			}
			else	
				return Response.status(Status.NOT_FOUND)
		                .header("Access-Control-Allow-Origin", "*")
		                .build();
		}
		else
			return Response.status(Status.NOT_FOUND)
	                .header("Access-Control-Allow-Origin", "*")
	                .build();
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchTemplateIntershipAgreement(@QueryParam(value="id")int id) {
		return Response.ok() // 200
                .entity(templateIntershipAgreementService.search(id))
                .header("Access-Control-Allow-Origin", "*")
                .build();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTemplateIntershipAgreement(@QueryParam(value="id")int id) {
		if(searchTemplateIntershipAgreement(id) != null) {
			templateIntershipAgreementService.delete(id);
		}
		
		return Response.ok() // 200
	                .build();
	}
	
	@GET
	@Path("/export")
	@Produces(MediaType.APPLICATION_JSON)
	public String exportTemplatePFE(@QueryParam(value="id")int id) {
		if(templateIntershipAgreementService.search(id)!= null ) {
			templateIntershipAgreementService.exportTemplateIntershipAgreement(id);
			return "Template exported !!";
		}else
			return "There is no Template with id "+id;
	}
	
	
	

}
