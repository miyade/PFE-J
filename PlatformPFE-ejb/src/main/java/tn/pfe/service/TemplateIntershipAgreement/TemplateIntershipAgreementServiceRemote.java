package tn.pfe.service.TemplateIntershipAgreement;


import javax.ejb.Remote;

import tn.pfe.entity.TemplateIntershipAgreement;




@Remote
public interface TemplateIntershipAgreementServiceRemote {
	
	public void ajouter(TemplateIntershipAgreement E);
	
	public TemplateIntershipAgreement search(int id);

	public void modifier(TemplateIntershipAgreement E);
	
	public void delete(int id);
	
	public void exportTemplateIntershipAgreement(int id);


	
}
