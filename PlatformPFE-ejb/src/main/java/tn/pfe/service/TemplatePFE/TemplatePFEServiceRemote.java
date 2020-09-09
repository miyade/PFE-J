package tn.pfe.service.TemplatePFE;


import javax.ejb.Remote;

import tn.pfe.entity.TemplatePFE;



@Remote
public interface TemplatePFEServiceRemote {
	
	public void ajouter(TemplatePFE E);
	
	public TemplatePFE search(int id);
	
	public void modifier(TemplatePFE E);
	
	public void delete(int id);
	
	public void exportTemplateFile(int id);

	
}
