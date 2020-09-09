package tn.esprit.Services;

import java.util.Set;

import javax.ejb.Remote;

import tn.pfe.entity.ActionTeacher;

@Remote
public interface ActionTeacherServicesRemote {
	void ajouterteacherAction(int idt , ActionTeacher action);
	Set<ActionTeacher> getTeachresActions(int idt);
}
