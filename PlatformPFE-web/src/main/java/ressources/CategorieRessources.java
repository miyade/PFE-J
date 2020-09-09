package ressources;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.datatype.joda.deser.PeriodDeserializer;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.sun.jersey.api.client.ClientResponse.Status;

import tn.esprit.Services.CategorieService;
import tn.pfe.entity.projectCategory;

@Path("categories")
public class CategorieRessources {

	@EJB
	CategorieService catser;
	
	// http://localhost:9080/PlatformPFE-web/rest/categories
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getallCategories() {
		return Response.ok(catser.getCategories(), MediaType.APPLICATION_JSON).build();
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/categories/propose/{idt}
	@POST
	@Path("propose/{idt}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addCategorie(projectCategory c, @PathParam("idt")int idt) {
		catser.addCategorie(c, idt);
		return Response.ok().build();
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/categories/2
	@DELETE
	@Path("{idc}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCategorie(@PathParam("idc")int idc) {
		catser.deleteCategorieById(idc);
		return "categorie deleted";
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/categories
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCategorie(projectCategory c) {
		catser.updateCtegorie(c);
		return "categorie updated";
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/categories/{idc}/{idt}
	@POST
	@Path("{idc}/{idt}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response affecterproposedcategorie(@PathParam("idc")int idc, @PathParam("idt")int idt) {
		catser.affecterCategorieToTeacher(idc, idt);
		return Response.ok().build();
	}
	
	// http://localhost:9080/PlatformPFE-web/rest/categories/preferedCat/nomc/{idt}
	@GET
	@Path("preferedCat/{nomc}/{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response affecterpreferedcategorie(@PathParam("nomc")String nomc, @PathParam("idt")int idt) {
		
		for ( projectCategory c : catser.getCategories() ) {
				if(c.getName().equals(nomc)) {
					catser.affecterCategoriePrefereToTeacher(c.getId(), idt);
					return Response.ok(c).build();
				}
		}
		
		return Response.ok().build();
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/categories/DELETEpreferedCat/{idc}/{idt}
	@DELETE
	@Path("DELETEpreferedCat/{idc}/{idt}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response SUPPRIMERpreferedcategorie(@PathParam("idc")int idc, @PathParam("idt")int idt) {
		catser.deletepreferedCategori(idt, idc);;
		return Response.status(Status.NO_CONTENT)
	            .entity("deleted").type("text/plain")
	            .build();
	}
	
	// http://localhost:9080/PlatformPFE-web/rest/categories/MyPrefered/{idt}
		@GET
		@Path("MyPrefered/{idt}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response GetMyPreferedCategoie(@PathParam("idt")int idt) {
			
			return   Response.ok(catser.getMyPreferedCtegories(idt), MediaType.APPLICATION_JSON).build();
		}
		
		// http://localhost:9080/PlatformPFE-web/rest/categories/MyProposed/{idt}
				@GET
				@Path("MyProposed/{idt}")
				@Produces(MediaType.APPLICATION_JSON)
				public Response GetMyProposedCategoie(@PathParam("idt")int idt) {
					
					return   Response.ok(catser.getMyProposedCtegories(idt), MediaType.APPLICATION_JSON).build();
				}
	
	
	
}
