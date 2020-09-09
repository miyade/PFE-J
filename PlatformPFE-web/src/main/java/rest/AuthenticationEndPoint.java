package rest;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.esprit.Services.UserServiceLocal;
import tn.pfe.entity.User;

@Path("authentification")
public class AuthenticationEndPoint {

	@Context
	private UriInfo urlInfo;
	
	@EJB
	UserServiceLocal userService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response antentificateUser(@QueryParam(value="email")String email , @QueryParam(value="password")String password) {
		User u = userService.getUserByEmailandPassword(email, password);
		
		if(u != null) {
			/*
			authenticate(u.getEmail() , u.getPassword());
			
			String token = issueToken(u.getEmail());
			
			return Response.ok(token).build();
			
			*/
			return Response.status(Status.OK).entity(u).build();
		}
		else
			return Response.status(Status.NOT_FOUND).build();
	}


	private String issueToken(String username) {
		// Issue a token (can be a random String persisted to a database or a JWT token)
		// The issued token must be associated to a user
		// Return the issued token
		String keyString = "simplekey";
		Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
		
		System.out.println("the key is : " + key.hashCode());
		System.out.println("uriInfo.getAbsolutePath().toString() : " +
		
		urlInfo.getAbsolutePath().toString());
		
		System.out.println("Expiration date: " + toDate(LocalDateTime.now().plusMinutes(15L)));
		
		String jwtToken = Jwts.builder().setSubject(username).setIssuer(urlInfo.getAbsolutePath().toString()).setIssuedAt(new Date()).setExpiration(toDate(LocalDateTime.now().plusMinutes(15L))).signWith(SignatureAlgorithm.HS512, key).compact();
		
		System.out.println("the returned token is : " + jwtToken);
		return jwtToken;
		}
		// ======================================
		// = Private methods =
		// ======================================
		private Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		}



		private void authenticate(String username, String password) {
			// Authenticate against a database, LDAP, file or whatever
			// Throw an Exception if the credentials are invalid
			System.out.println("Authenticating user...");
		}

	
}
