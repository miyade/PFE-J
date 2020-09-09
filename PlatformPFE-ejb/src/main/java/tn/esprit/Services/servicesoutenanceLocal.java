package tn.esprit.Services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Classes;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Soutenance;
import tn.pfe.entity.Teacher;



@Local
public interface servicesoutenanceLocal {
	public String addsoutenance(Soutenance s);
	public void affecterpfetos(int idpfe,int ids);
	public void affecterclassetos(int idc,int ids);
	public List<Soutenance> algo(String datesoutenance ,List<GradProjectFile> pfes,List<Classes>classes )throws ParseException;
	public String add(List<Soutenance> ss );
	public List<Integer> teacherocupper(Date ds);
	public boolean verifteacherocuperbydate(Date ds,int idt);
	public List<Soutenance> getSsoutenancebaydate(Date datesoutenance);
	
}
