package ressources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.Services.serviceclasses;
import tn.esprit.Services.servicesoutenance;
import tn.esprit.Services.servicestudent;
import tn.pfe.entity.Classes;
import tn.pfe.entity.Soutenance;
import tn.pfe.entity.Teacher;



@Path("soutenance")
public class Soutenanceressource {
	@EJB
	servicesoutenance ss;
	@EJB
	servicestudent es;
	@EJB
	serviceclasses sc ;
	

	
	//methode pout test methodeaffecterpresident 
	 
	   @GET
	   @Produces(MediaType.APPLICATION_JSON)
	   public List <Integer> affidteacherocupp() throws ParseException{
		   SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		   Date d =sd.parse("03/11/2019 08:00:00");
		   return ss.teacherocupper(d);}
	    
	   
	   //methode pour teest methode affecter president
	   @Path("{idt}")
	   @GET
	   @Produces(MediaType.TEXT_PLAIN)
	   public boolean verif(@PathParam("idt")int idt) throws ParseException {
		   
		   SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		   Date d =sd.parse("03/11/2019 08:00:00");
		   return ss.verifteacherocuperbydate(d,idt);
		   
	   }
	   

	   @Path("{dj}/{dm}/{da}")
	   @GET
	   @Produces(MediaType.TEXT_PLAIN)
	   @Consumes(MediaType.APPLICATION_JSON)
	   public String  addalgo(@PathParam(value="dj")String dj,
			   @PathParam(value="dm")String dm ,
			   @PathParam(value="da")String da  
			   ) throws ParseException {
		   
		   String s=dj+"/"+dm+"/"+da+" ";
		 
		   
		   List<Soutenance> sa=ss.algo(s, es.getpfe(), sc.affclasses());
		   ss.add(sa);
		   
		   
		   return "ok";
	   
	   
	   }
	   @POST
	   @Path("affecterpresident/{ids}/{idp}/{dj}/{dm}/{da}/{dh}/{dmm}/{ds}")
	   @Produces(MediaType.TEXT_PLAIN)
	   public String affecterdstos(@PathParam(value = "ids")int ids,@PathParam(value = "idp")int idp,@PathParam(value="dj")String dj,@PathParam(value="dm")String dm
			   ,@PathParam(value="da")String da,@PathParam(value="dh")String dh,@PathParam(value="dmm")String dmm,@PathParam(value="ds")String ds) throws ParseException {
		   SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		   String s=dj+"/"+dm+"/"+da+" "+dh+":"+dmm+":"+ds;
		   Date d =sd.parse(s);
	  
	   	if(es.affecterPtoS(ids, idp, d)==false) {
	   		s=s+"president affecter avec succes";
	   		
	   	}else
	   		s=s+" ensiegnant ocupper ou  soutenance deja affecter";
	   	
	   	return s;
	   
}
	   
}
