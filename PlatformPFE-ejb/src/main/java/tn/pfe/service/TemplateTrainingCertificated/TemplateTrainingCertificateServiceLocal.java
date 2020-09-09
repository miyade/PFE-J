package tn.pfe.service.TemplateTrainingCertificated;


import javax.ejb.Local;

import tn.pfe.entity.TemplateTrainingCertificate;




@Local
public interface TemplateTrainingCertificateServiceLocal {
	
	public void ajouter(TemplateTrainingCertificate T);
	
	public TemplateTrainingCertificate search(int id);
	
	public void modifier(TemplateTrainingCertificate T);

	public void delete(int id);
	
	public void exportTemplateFile(int id);


}
