package PfeRes;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import tn.esprit.Services.GradProjectFileService;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.OldPfe;

@Path("/pferesource")
public class PfeResources {

@EJB
GradProjectFileService gps;

@GET
@Path("/getallpfe")
@Produces(MediaType.APPLICATION_JSON)
public List<GradProjectFile> getAllPfe(){
	return gps.GetPfe();
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/ajoutpfe")
public void addPfe(GradProjectFile pfe) {
	gps.addPfe(pfe);
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/deletepfe")
public void deletepfe(@QueryParam("id")int id) {
	gps.deletepfe(id);
}
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Path("/updatepfe")
public void updatepfe(GradProjectFile pfe,@QueryParam("idd") int id) {
	gps.updatepfe(pfe,id);
}
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/getalloldpfe")
public Response getoldpfe() {
	return Response.ok(gps.getoldpfe()).build();
}



}
