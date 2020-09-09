package tn.pfe.service.CoachCompany;

import javax.ejb.Local;

import tn.pfe.entity.CoachCompany;

@Local
public interface CoachCompanyServiceLocal {

	public void modifier(CoachCompany user );
	public void supprimer(int id);
	public CoachCompany getCoachCompanyById(int id);
}
