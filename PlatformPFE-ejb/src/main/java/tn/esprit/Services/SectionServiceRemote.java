package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.*;

@Remote
public interface SectionServiceRemote {
	int addSection(Section sec,int idT);
	List<Section> getTeacherSectionofTeacherById(int idT);

}
