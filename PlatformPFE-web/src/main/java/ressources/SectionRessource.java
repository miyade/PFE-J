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


import tn.esprit.Services.SectionService;
import tn.pfe.entity.Section;

@Path("section")
public class SectionRessource {
	@EJB
	SectionService sectionSer;
	
	@GET
	@Path("{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	private List<Section> getSectionsOfTeacher(@PathParam("idt")int idt) {
		System.out.println("heyyyyy   you !!");	
		return sectionSer.getTeacherSectionofTeacherById(idt);
		
		}
	
	
	
	@POST
	@Path("{idt}")
	@Consumes(MediaType.APPLICATION_JSON)
	private void addSection(Section s , @PathParam("idt")int idt) {
		sectionSer.addSection(s, idt);
	}
	
	
	
	
	
	
}
