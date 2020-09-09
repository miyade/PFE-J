package tn.esprit.Services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.pfe.entity.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

	@PersistenceContext(unitName="PlatformPFEDS")
	EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public User getUserByEmailandPassword(String login , String password) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("select e FROM User e WHERE e.email =:email AND e.password =:password ", User.class);
		query.setParameter("email", login);
		query.setParameter("password", password);
		
		User user = null;
		try {
		user = query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return user;
	}

}
