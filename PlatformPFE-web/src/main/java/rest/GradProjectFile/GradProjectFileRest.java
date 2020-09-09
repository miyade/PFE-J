package rest.GradProjectFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.Services.GradProjectFileServiceLocal;
import tn.pfe.entity.GradProjectFile;

@Path("Fiche")
public class GradProjectFileRest {
	@EJB(mappedName="PlatformPFE-ear/PlatformPFE-ejb/GradProjectFileService!tn.esprit.Services.GradProjectFileServiceServiceRemote") 
	GradProjectFileServiceLocal ficheService;
	
	@GET
	@Produces("application/json")
	public Response getSheetsByEtat(@QueryParam(value="etat") String etat,@QueryParam(value="pays") String pays,
			@QueryParam(value="year") String year) {
		boolean combined=false;
		int nullvarCount=0;
		List<GradProjectFile> etatList =new ArrayList<GradProjectFile>()
				,paysList=new ArrayList<GradProjectFile>()
				,yearList=new ArrayList<GradProjectFile>()
				,finalresult=new ArrayList<GradProjectFile>();
		HashSet<GradProjectFile> hashList=new HashSet<GradProjectFile>();
		if(etat==null)
			nullvarCount++;
		else
			etatList=ficheService.getSheetsByEtat(etat);
		if(year==null)
			nullvarCount++;
		else
			yearList=ficheService.getSheetsByYear(year);
		if(pays==null)
			nullvarCount++;
		else
			paysList=ficheService.getSheetsByPays(pays);
		if(nullvarCount!=3) {
			finalresult.addAll(paysList);
			finalresult.addAll(yearList);
			finalresult.addAll(etatList);
			if(etat!=null)
				finalresult.retainAll(etatList);
			if(year!=null)
				finalresult.retainAll(yearList);
			if(pays!=null)
				finalresult.retainAll(paysList);
			hashList.addAll(finalresult);
		}
	if (hashList.size()==0)
		return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

	else {
		return Response.ok(hashList, MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*").build();
	}
	}
	
	@Path("ficheCetteAnnee")
	@GET
	@Produces("application/json")
	public Response getSheetsThisYear() {
	if (ficheService.getSheetsOfYear().size() == 0)
		return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

	else {
		return Response.ok(ficheService.getSheetsOfYear(), MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*").build();
	}
	}
	@Path("enattenteDeSoutenance")
	@GET
	@Produces("application/json")
	public Response getWaitingDefense() {
		if (ficheService.getWaitingDefense().size() == 0)
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

		else {
			return Response.ok(ficheService.getWaitingDefense(), MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getallpfe")
	public Response getoldpfe() {
		return Response.ok(ficheService.GetPfe()).build();
	}
}
