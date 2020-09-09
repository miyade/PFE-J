package tn.pfe.service.TemplateTrainingCertificated;


import javax.ejb.Remote;

import tn.pfe.entity.TemplateTrainingCertificate;



@Remote
public interface TemplateTrainingCertificateServiceRemote {
	
	public void ajouter(TemplateTrainingCertificate E);
	
	public TemplateTrainingCertificate search(int id);
	
	public void modifier(TemplateTrainingCertificate E);
	
	public void delete(int id);
	
	public void exportTemplateFile(int id);

	
}
