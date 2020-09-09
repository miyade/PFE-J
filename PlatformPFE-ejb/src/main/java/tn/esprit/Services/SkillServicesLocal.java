package tn.esprit.Services;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import tn.pfe.entity.*;

@Local
public interface SkillServicesLocal {
	int addSkill(int idt,int idc);
	Set<Skill> getTeacherSkills(int idt);
}
