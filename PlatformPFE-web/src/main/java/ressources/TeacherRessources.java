package ressources;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itextpdf.awt.geom.gl.Crossing;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.tool.xml.css.parser.state.Properties;

import tn.esprit.Services.ActionTeacherServices;
import tn.esprit.Services.TeacherService;
import tn.pfe.entity.ActionTeacher;
import tn.pfe.entity.Teacher;
import tn.pfe.entity.projectCategory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.decorator.Delegate;
import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("teacher")
public class TeacherRessources {

	@EJB
	TeacherService teachSer;
	
	@EJB
	ActionTeacherServices actionSer;
	
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/all
		@GET
		@Path("authuser/{login}/{password}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response authUser(@PathParam("login")String login,@PathParam("password")String password) {
			
			return  Response.ok(teachSer.authetificate(login, password), MediaType.APPLICATION_JSON).build() ;
		}
	
	
	// afficher Teachers
	// http://localhost:9080/PlatformPFE-web/rest/teacher/all
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeachers() {
		
		return  Response.ok(teachSer.getTeachers(), MediaType.APPLICATION_JSON).build() ;
	}
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/update
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateTeacher(Teacher t) {
		teachSer.updateTeacherById(t);
		return "treacher updated";
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/2
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{idt}")
	public String deleteTeacher(@PathParam("idt")int idt) {
		teachSer.deleteTeacherById(idt);
		return "teacher deleted";
	}
	
	
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/1
	@GET
	@Path("{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeacherById(@PathParam("idt")int idt) {
		return Response.ok(teachSer.getTeacherById(idt),MediaType.APPLICATION_JSON).build();
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/liststdaencadrer/1
	@GET
	@Path("liststdaencadrer/{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentAEncadrer(@PathParam("idt")int idt) {
		return Response.ok(teachSer.listerSdtEncadre(idt),MediaType.APPLICATION_JSON).build();
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/liststdarapporter/1
	@GET
	@Path("liststdarapporter/{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentARapporter(@PathParam("idt")int idt) {
		return Response.ok(teachSer.listerSdtarapporter(idt),MediaType.APPLICATION_JSON).build();
	}
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/liststdapresent/1
	@GET
	@Path("liststdapresent/{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentAPresident(@PathParam("idt")int idt) {
		return Response.ok(teachSer.listerSdtarapporter(idt),MediaType.APPLICATION_JSON).build();
	}
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/listfileworkingon/1
		@GET
		@Path("listfileworkingon/{idt}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getfilesWorkingOn(@PathParam("idt")int idt) {
			return Response.ok(teachSer.listerFileWorkingOn(idt),MediaType.APPLICATION_JSON).build();
		}
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/listfileaencadrer/1
	@GET
	@Path("listfileaencadrer/{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfilesAencager(@PathParam("idt")int idt) {
		return Response.ok(teachSer.listerFileEncadrer(idt),MediaType.APPLICATION_JSON).build();
	}
	
	
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/listfilearapporter/1
	@GET
	@Path("listfilearapporter/{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfilesArapporter(@PathParam("idt")int idt) {
		return Response.ok(teachSer.listerFileRapporter(idt),MediaType.APPLICATION_JSON).build();
	}
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/listfileapresent/1
    @GET
	@Path("listfileapresent/{idt}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfilesAPresident(@PathParam("idt")int idt) {
		return Response.ok(teachSer.listerFilePresedent(idt),MediaType.APPLICATION_JSON).build();
	}
	
    
    
	// http://localhost:9080/PlatformPFE-web/rest/teacher/prevalider/1/1/encadrant 
    @GET
	@Path("prevalider/{idt}/{idf}/{role}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response prevaliderfile(@PathParam("idt")int idt,@PathParam("idf")int idf,@PathParam("role")String role) {
		teachSer.prevalide(idt, idf, role);
		 
	        
		    return Response.ok(teachSer.getTeacherById(idt), MediaType.APPLICATION_JSON).build();
	}
	
	
	// http://localhost:9080/PlatformPFE-web/rest/teacher/notter/1/1/19/encadrant 
    @GET
   	@Path("notter/{idt}/{idf}/{note}/{role}")
   	@Produces(MediaType.TEXT_PLAIN)
   	public Response noterfile(@PathParam("idt")int idt,@PathParam("idf")int idf,@PathParam("note")double note,@PathParam("role")String role) {
   		teachSer.noterpfeFile(idt, idf, note, role);
   		return Response.ok("file note", MediaType.TEXT_PLAIN).build();

   	}
    
    
	// http://localhost:9080/PlatformPFE-web/rest/teacher/motif/1/1/this is nice/encadrant 
    @GET
   	@Path("motif/{idt}/{idf}/{motif}/{role}")
   	@Produces(MediaType.TEXT_PLAIN)
   	public Response motiffile(@PathParam("idt")int idt,@PathParam("idf")int idf,@PathParam("motif")String motif,@PathParam("role")String role) {
   		teachSer.donnerUnMotif(idt, idf, motif, role);
   		return Response.ok("motif added", MediaType.TEXT_PLAIN).build();
   		
   	}
   	
    
    
 // http://localhost:9080/PlatformPFE-web/rest/teacher/fileencadreByYear/1/2019
    @GET
    @Path("fileencadreByYear/{idt}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFileEncadreByYear(@PathParam("idt")int idt, @PathParam("year")int year) {
    	return Response.ok(teachSer.getFilesencadredByYear(idt, year)).build() ;
    	}
    
    
 // http://localhost:9080/PlatformPFE-web/rest/teacher/fileencadreBetwwen2Years/1/2017/2019 
    @GET
    @Path("fileencadreBetwwen2Years/{idt}/{year1}/{year2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFileEncadreBetween2Years(@PathParam("idt")int idt, @PathParam("year1")int year1
    		, @PathParam("year2")int year2) {
    	return Response.ok(teachSer.getFilesencadredBetween2Years(idt, year1, year2)).build() ;
    	}
    
    
    // http://localhost:9080/PlatformPFE-web/rest/teacher/fileerapporterByYear/1/2019 
    @GET
    @Path("fileerapporterByYear/{idt}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilerapporterByYear(@PathParam("idt")int idt, @PathParam("year")int year) {
    	return Response.ok(teachSer.getFilesrapportedByYear(idt, year)).build() ;
    	}
    
	
    // http://localhost:9080/PlatformPFE-web/rest/teacher/filerapportedBetwwen2Years/1/2017/2019 
    @GET
    @Path("filerapportedBetwwen2Years/{idt}/{year1}/{year2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilerapportedbetween2Years(@PathParam("idt")int idt, @PathParam("year1")int year1
    		, @PathParam("year2")int year2) {
    	return Response.ok(teachSer.getFilesrapportedBetween2Years(idt, year1, year2)).build() ;
    	}
    
	
    
    
    // http://localhost:9080/PlatformPFE-web/rest/teacher/filepresedentByYear/1/2019 
    @GET
    @Path("filepresedentByYear/{idt}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilepresedentByYear(@PathParam("idt")int idt, @PathParam("year")int year) {
    	return Response.ok(teachSer.getFilespresendentdByYear(idt, year)).build() ;
    	}
    
	
    // http://localhost:9080/PlatformPFE-web/rest/teacher/filepresedentBetwwen2Years/1/2017/2019 
    @GET
    @Path("filepresedentBetwwen2Years/{idt}/{year1}/{year2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilepresedentbetween2Years(@PathParam("idt")int idt, @PathParam("year1")int year1
    		, @PathParam("year2")int year2) {
    	return Response.ok(teachSer.getFilespresedentBetween2Years(idt, year1, year2)).build() ;
    	}
    
    
    // http://localhost:9080/PlatformPFE-web/rest/teacher/mostencadredcategorie/1
    @GET
    @Path("mostencadredcategorie/{idt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<projectCategory, Integer> getmostencadredcategorie(@PathParam("idt")int idt) {
    	
   
    	return teachSer.getmostencadredCategorie(idt);
    	}
    
    // http://localhost:9080/PlatformPFE-web/rest/teacher/mostrapportedcategorie/1   
    @GET
    @Path("mostrapportedcategorie/{idt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getmostrapportedcategorie(@PathParam("idt")int idt) {
    	return Response.ok(teachSer.getmostRapportedCategorie(idt)).build() ;
    	}
    
 // http://localhost:9080/PlatformPFE-web/rest/teacher/mostpresentedcategorie/1
    @GET
    @Path("mostpresentedcategorie/{idt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getmostpresentedcategorie(@PathParam("idt")int idt) {
    	return Response.ok(teachSer.getmostpresedentCategorie(idt)).build() ;
    	}
    
    
    
    
    // http://localhost:9080/PlatformPFE-web/rest/teacher/bestnoteencadredcategorie/1
    @GET
    @Path("bestnoteencadredcategorie/{idt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbestnoteofeachCategorieencadre(@PathParam("idt")int idt) {
    	return Response.ok(teachSer.getcategorieMostNote(idt)).build() ;
    	}
    
    
    
    // http://localhost:9080/PlatformPFE-web/rest/teacher/bestnoterapportedcategorie/1
    @GET
    @Path("bestnoterapportedcategorie/{idt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbestnoteofeachCategorierapported(@PathParam("idt")int idt) {
    	return Response.ok(teachSer.getcategorieMostNoteenTTQRapporteur(idt)).build() ;
    	}
    
    
 // http://localhost:9080/PlatformPFE-web/rest/teacher/autocomplete/1
    @GET
    @Path("autocomplete/{idt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getautoComplete(@PathParam("idt")int idt) {
    	return Response.ok(teachSer.autoCompletePreferdCategorie(idt)).build() ;
    	}
    

    // http://localhost:9080/PlatformPFE-web/rest/teacher/getActions/1
    @GET
    @Path("getActions/{idt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getactions(@PathParam("idt")int idt) {
    	 List<ActionTeacher> lstOfEmployee = actionSer.getTeachresActions(idt).stream()
    	    		.sorted(Comparator.comparing(
    	    		        ActionTeacher::getId).reversed()) //comparator
    	    		        .collect(Collectors.toList());
    	 
    	 List<ActionTeacher> last8Actions = new ArrayList<ActionTeacher>();
    	
    	 for(int i = 0 ; i < 5 ; i++) {
    		 
    		 if(lstOfEmployee.get(i) != null) {
    			 last8Actions.add(lstOfEmployee.get(i));
    		 }
    		 
    	 }
    	 
    	return Response.ok(last8Actions).build() ;
    	}
   
    
    
	


 	//chef dep
 		@GET
 		@Path("/chef/{idt}")
 		@Produces(MediaType.APPLICATION_JSON)
 		public Response getChefDepartement(@PathParam("idt")int idt) {
 			return Response.ok(teachSer.getChefdepartement(idt),MediaType.APPLICATION_JSON).build();
 		}
 		//student
 		@GET
 		@Path("/student/{idst}")
 		@Produces(MediaType.APPLICATION_JSON)
 		public Response getStudent(@PathParam("idst")int idst) {
 			return Response.ok(teachSer.getStudent(idst),MediaType.APPLICATION_JSON).build();
 		}

}
