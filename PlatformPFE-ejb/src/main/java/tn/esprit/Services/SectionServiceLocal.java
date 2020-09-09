package tn.esprit.Services;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.*;

@Local
public interface SectionServiceLocal {
	int addSection(Section sec,int idT);
	List<Section> getTeacherSectionofTeacherById(int idT);
}
