package edu.cs673.plm;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.cs673.plm.model.User;
import edu.cs673.plm.model.StatusMessage;

public class UserDao {
	private static boolean nameValid(EntityManager em, User user){
		if(((Long) em.createQuery("select count(*) from User user").getSingleResult()).intValue()>0)
			return false;
		return true;
	}

	public static StatusMessage createUser(Dba dba, User user) {
		EntityManager em = dba.getActiveEm();
		if(nameValid(em,user)){
			em.persist(user);
			return new StatusMessage(0,"Success");
		}
		return new StatusMessage(1,"Invalid Name");
	}
}
