package edu.cs673.plm;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.cs673.plm.model.Project;

public class ProjectDao {
	public static long getMemberCount(Dba dba, Project project){
		EntityManager em = dba.getActiveEm();
		Query q = em.createQuery("select project from Project project where project:id = :id")
						.setParameter("id",project.getId());
		try{
			project = (Project)q.getSingleResult();
		} catch(Exception e){
			return 0;
		}

		return project.getUserProjects().size();
	}
}
