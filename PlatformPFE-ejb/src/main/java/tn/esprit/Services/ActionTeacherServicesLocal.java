package tn.esprit.Services;

import java.util.Set;

import javax.ejb.Local;

import tn.pfe.entity.ActionTeacher;

@Local
public interface ActionTeacherServicesLocal {
		void ajouterteacherAction(int idt , ActionTeacher action);
		Set<ActionTeacher> getTeachresActions(int idt);
}
