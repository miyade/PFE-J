package tn.esprit.Services;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.pfe.entity.ActionTeacher;
import tn.pfe.entity.Teacher;

/**
 * Session Bean implementation class ActionTeacherServices
 */
@Stateless
@LocalBean
public class ActionTeacherServices implements ActionTeacherServicesRemote, ActionTeacherServicesLocal {

	@PersistenceContext(unitName = "PlatformPFEDS")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ActionTeacherServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterteacherAction(int idt, ActionTeacher action) {

		Teacher t =  em.find(Teacher.class, idt);
		em.persist(action);
		action.setTeacher(t);
		
	}

	@Override
	public Set<ActionTeacher> getTeachresActions(int idt) {
		Teacher t =  em.find(Teacher.class, idt);
		
		return t.getActionsTeacher();
	}

}
