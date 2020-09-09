package tn.pfe.service.TemplateIntershipAgreement;


import javax.ejb.Local;

import tn.pfe.entity.TemplateIntershipAgreement;




@Local
public interface TemplateIntershipAgreementServiceLocal {
	
	public void ajouter(TemplateIntershipAgreement T);
	
	public TemplateIntershipAgreement search(int id);
	
	public void modifier(TemplateIntershipAgreement T);

	public void delete(int id);

	public void exportTemplateIntershipAgreement(int id);

}
