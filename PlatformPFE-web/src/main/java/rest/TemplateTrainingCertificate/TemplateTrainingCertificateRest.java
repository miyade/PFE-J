package rest.TemplateTrainingCertificate;


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
import tn.pfe.entity.TemplatePFE;
import tn.pfe.entity.TemplateTrainingCertificate;
import tn.pfe.service.TemplateTrainingCertificated.TemplateTrainingCertificateServiceLocal;


@Path("templateTrainingCertificate")
public class TemplateTrainingCertificateRest {
	
	@EJB
	TemplateTrainingCertificateServiceLocal templateService;
	
	@EJB
	servicesiteLocal serviceSite;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String ajouter(@QueryParam(value="template") String template , @QueryParam(value="site_id") int site_id) {
		
		Site s = serviceSite.getSiteById(site_id);
		if(s != null) {
			TemplateTrainingCertificate T = new TemplateTrainingCertificate(template);
			T.setSite(s);
			
			templateService.ajouter(T);
			return "Template added";
		}else
			return "there is no Site with the id = "+site_id;	
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String modifier(@QueryParam(value="id") int id , @QueryParam(value="template") String Template , @QueryParam(value="site_id") int site_id) {
		Site s = serviceSite.getSiteById(site_id);
		
		if(s != null) {
		TemplateTrainingCertificate T = new TemplateTrainingCertificate(id, Template , s);
		
		if(searchTemplateTrainingCertificate(T.getId()) != null) {
			templateService.modifier(T);;
			return "The object was updated !";
		}
		else	
			return "there is no object with the id = "+id;
		}else
			return "there is no Site with the id = "+id;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TemplateTrainingCertificate searchTemplateTrainingCertificate(@QueryParam(value="id")int id) {
		return templateService.search(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String delteTemplateTrainingCertificate(@QueryParam(value="id")int id) {
		if(searchTemplateTrainingCertificate(id) != null) {
			templateService.delete(id);
			return "The object was deleted !";
	}
	else	
		return "there is no object with the id = "+id;
	}
	
	@GET
	@Path("/export")
	@Produces(MediaType.APPLICATION_JSON)
	public String exportTemplateTrainingCertificate(@QueryParam(value="id")int id) {
		if(templateService.search(id)!= null ) {
			templateService.exportTemplateFile(id);
			return "Template exported !!";
		}else
			return "There is no Template with id "+id;
	}
	
	
	
	

}
