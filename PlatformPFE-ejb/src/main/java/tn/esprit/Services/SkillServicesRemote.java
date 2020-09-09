package tn.esprit.Services;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import tn.pfe.entity.*;

@Remote
public interface SkillServicesRemote {
	int addSkill(int idt,int idc);
	Set<Skill> getTeacherSkills(int idt);
}
