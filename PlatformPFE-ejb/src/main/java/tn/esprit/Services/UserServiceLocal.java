package tn.esprit.Services;

import javax.ejb.Local;

import tn.pfe.entity.User;

@Local
public interface UserServiceLocal {

	public User getUserByEmailandPassword(String login , String password);
}
