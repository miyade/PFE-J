package tn.pfe.service.TemplatePFE;


import javax.ejb.Local;

import tn.pfe.entity.TemplatePFE;



@Local
public interface TemplatePFEServiceLocal {
	
	public void ajouter(TemplatePFE T);
	
	public TemplatePFE search(int id);
	
	public void modifier(TemplatePFE T);

	public void delete(int id);
	
	public void exportTemplateFile(int id);


}
