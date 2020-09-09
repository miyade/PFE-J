package tn.esprit.Services;

import javax.ejb.Remote;

import tn.pfe.entity.User;

@Remote
public interface UserServiceRemote {

	public User getUserByEmailandPassword(String login , String password);
}
