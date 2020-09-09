package rest.Student;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.pfe.entity.Student;
import tn.pfe.service.Student.StudentServiceLocal;


@Path("student")
public class StudentRest {

	@EJB
	StudentServiceLocal studentService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudent(@QueryParam(value="site_id")int site_id) {
		List<Student> liste = new ArrayList<Student>();
		liste = studentService.getAllStudent(site_id);
		
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
	
	@GET
	@Path("getAllStudentRecrutedoverContry")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudentRecrutedoverContry(@QueryParam(value="site_id")int site_id) {
		List<Student> liste = new ArrayList<Student>();
		liste = studentService.getAllStudentRecrutedoverContry(site_id);
		
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
	
	@GET
	@Path("getAllStudentRecrutedbyContryandYear")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudentRecrutedByContryByYear(@QueryParam(value="contry")String contry , @QueryParam(value="year")int year ,@QueryParam(value="site_id")int site_id) {
		
		List<Student> liste = new ArrayList<Student>();
		liste =  studentService.getAllStudentRecrutedByContryByYear(contry , year , site_id);
		
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
	
	@POST
	@Path("ajouterEncadreur")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterEncadreur(@QueryParam(value="email")String email ) {
		studentService.ajouterEncadrent(email);
	}
	
	@GET
	@Path("searchStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudnetById(@QueryParam(value="id")int id) {
		Student student = studentService.getStudnetById(id);
		
		if(student != null)
			return Response.ok()
				.entity(student)
                .header("Access-Control-Allow-Origin", "*")
                .build();
		else
			return Response.ok()
	                .header("Access-Control-Allow-Origin", "*")
	                .build();
			
	}
	
}
