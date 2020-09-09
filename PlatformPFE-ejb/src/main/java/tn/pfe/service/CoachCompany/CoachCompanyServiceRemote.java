package tn.pfe.service.CoachCompany;

import javax.ejb.Remote;

import tn.pfe.entity.CoachCompany;

@Remote
public interface CoachCompanyServiceRemote {

	public void modifier( CoachCompany user );
	public void supprimer(int id);
	public CoachCompany getCoachCompanyById(int id);
}
