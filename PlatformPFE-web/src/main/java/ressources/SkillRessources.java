package ressources;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import tn.esprit.Services.SkillServices;

import tn.pfe.entity.Skill;

@Path("skills")
public class SkillRessources {

	@EJB
	SkillServices skillser;
	
	// http://localhost:9080/PlatformPFE-web/rest/skills/1/2
	@GET
	@Path("{idt}/{idc}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addskills(@PathParam("idt")int idt,@PathParam("idc")int idc) {
		
		skillser.addSkill(idt, idc);
		
		return Response.ok(skillser.getTeacherSkills(idt), MediaType.APPLICATION_JSON).build();
		
	}                                         
	
	
	// http://localhost:9080/PlatformPFE-web/rest/skills/1
	@GET
	@Path("{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Skill> getteacherkills(@PathParam("idt")int idt) {
		
		return skillser.getTeacherSkills(idt);
		
	}       
	
	
	
	
}
