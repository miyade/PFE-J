package rest.Category;

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
import tn.pfe.entity.projectCategory;
import tn.pfe.service.categorie.ProjectCategorieLocal;


@Path("category")
public class CategoryRest {

	@EJB
	ProjectCategorieLocal categorieService ;
	
	
	@GET
	@Path("/StageParCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<GradProjectFile> getNbStageParCategorie(@QueryParam(value="id")int id) {
		return  categorieService.getNbStageParCategorie(id);
	}
	
	@GET
	@Path("/ListStageParCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> NbStageParCategorie(@QueryParam(value="site_id")int site_id) {
		return  categorieService.StageParCategory(site_id);
	}
}
